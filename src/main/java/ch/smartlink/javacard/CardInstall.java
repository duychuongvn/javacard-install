package ch.smartlink.javacard;

import ch.smartlink.javacard.model.ADF;
import ch.smartlink.javacard.model.Key;
import ch.smartlink.javacard.util.MessageUtil;
import org.osptalliance.cipurse.CipurseException;
import org.osptalliance.cipurse.IAes;
import org.osptalliance.cipurse.ICommsChannel;
import org.osptalliance.cipurse.ILogger;
import org.osptalliance.cipurse.commands.*;
import org.osptalliance.cipurse.impl.AES;
import org.osptalliance.cipurse.impl.Logger;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huynhduychuong on 2/25/2016.
 */
public class CardInstall {

    private ICommsChannel commsChannel;
    private IAes aes;
    private ILogger logger;

    private ICipurseAdministration cipurseAdministration;
    private ICipurseOperational cipurseOperational;
    private CipurseCardHandler cipurseCardHandler;

    public CardInstall(ICommsChannel commsChannel) throws CipurseException {
        this.commsChannel = commsChannel;
        this.aes = new AES();
        this.logger = new Logger();
        this.init();
    }

    public void init() throws CipurseException {
        cipurseCardHandler = new CipurseCardHandler(commsChannel, aes, logger);
        CommandAPI commandAPI = CommandAPIFactory.getInstance().buildCommandAPI();
        commandAPI.setVersion(CommandAPI.Version.V3);
        cipurseAdministration = commandAPI.getCipurseAdministration(cipurseCardHandler);
        cipurseOperational = commandAPI.getCipurseOperational(cipurseCardHandler);
    }

    public void installADF(ADF adf) throws CipurseException {
        cipurseCardHandler.reset(0);
        cipurseOperational.selectMF();
        DFFileAttributes dfFileAttributes = new DFFileAttributes();
        dfFileAttributes.aidValue = new ByteArray(adf.getAID()).getBytes();
        dfFileAttributes.appProfile = DFFileAttributes.PROFILE_L;
        dfFileAttributes.fileDescriptor = DFFileAttributes.ADF_FILE_TYPE;
        dfFileAttributes.encKeyNo = (short) 0x00;
        dfFileAttributes.numOfKeys = (short) adf.getNbrK();
        dfFileAttributes.numOfEFs = (short) adf.getNbrEF();
        dfFileAttributes.numOfSFIDs = (short) adf.getNbrSFID();
        dfFileAttributes.fileID = adf.getFileID();
        KeyAttributeInfo[] keySet = getKeyAttributeInfo(adf, dfFileAttributes);

        SMR smrADf = new SMR(new ByteArray(adf.getSMR()));
        ART[] arts = getARTs(adf);
        SecurityAttributes securityAttributes = new SecurityAttributes(smrADf, arts);
        ByteArray response = cipurseAdministration.createFileADF(dfFileAttributes, securityAttributes, keySet);
        System.out.println(response);
    }

    private void createFileElements(ADF adf) throws CipurseException {
        cipurseOperational.selectFilebyAID(new ByteArray(adf.getAID()));
        SMR smrADf = new SMR(new ByteArray(adf.getSMR()));
        ART[] arts = getARTs(adf);

    }

    private KeyAttributeInfo[] getKeyAttributeInfo(ADF adf, DFFileAttributes dfFileAttributes) {
        List<Key> keys = adf.getKeySet() != null ? adf.getKeySet().getKeys() : new ArrayList<Key>();
        KeyAttributeInfo[] keySet = new KeyAttributeInfo[keys.size()];
        for (int i = 0; i < keySet.length; i++) {
            Key key = keys.get(i);
            KeyAttributeInfo keyAttributeInfo = new KeyAttributeInfo();
            keyAttributeInfo.setKeyValue(new ByteArray(key.getKeyValue()));
            keyAttributeInfo.keyLength = (short) key.getKeyLegth();
            keyAttributeInfo.keyAlgoId = key.getKeyAlgoId();
            keyAttributeInfo.keyAddInfo = new Short(key.getKeyAddlInfo());
            keyAttributeInfo.keySecAttrib = new Short(key.getKeySecAttrib());
            keySet[i] = keyAttributeInfo;
        }
        return keySet;
    }

    /**
     *
     * @param adf
     * @return
     */
    private ART[] getARTs(ADF adf) {
        ByteArray adfArt = new ByteArray(adf.getART());

        ART[] arts = new ART[adf.getNbrK() + 1];
        for (int i = 0; i < arts.length; i++) {
            arts[i] = new ART(adfArt.getByte(i));
        }
        return arts;
    }

}

