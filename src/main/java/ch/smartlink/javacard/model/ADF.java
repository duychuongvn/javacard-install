package ch.smartlink.javacard.model;

import ch.smartlink.javacard.model.adapter.HexStringAdapter;
import ch.smartlink.javacard.model.adapter.HexStringIntegerAdapter;
import ch.smartlink.javacard.model.adapter.HexStringShortAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huynhduychuong on 1/22/2016.
 *  data: ADF AID="DF 00 00 00 00 00 11 11" FD="df_cipurse" FileID="0x5F01" NbrEF="5" NbrSFID="5" Type="0x40" filename="ADF 5F01"
 */
@XmlType(propOrder = {"keySet", "elementFiles"})
@XmlRootElement(name = "ADF")

public class ADF {

    private String AID;

    private ADFDefinition fileDefinition;

    private Integer fileID;

    private int nbrEF;

    private int nbrSFID;
    private Short type;

    private String filename;
    private int nbrK;
    private String SMR;
    private KeySet keySet;
    private List<ElementFile> elementFiles = new ArrayList<ElementFile>();
    private String ART;

    @XmlAttribute(name = "AID")
    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }
    @XmlAttribute(name = "FD")
    public ADFDefinition getFileDefinition() {
        return fileDefinition;
    }

    public void setFileDefinition(ADFDefinition fileDefinition) {
        this.fileDefinition = fileDefinition;
    }
    @XmlAttribute(name = "FileID")
    @XmlJavaTypeAdapter(HexStringIntegerAdapter.class)
    public Integer getFileID() {
        return fileID;
    }

    public void setFileID(Integer fileID) {
        this.fileID = fileID;
    }
    @XmlAttribute(name = "NbrEF")
    public int getNbrEF() {
        return nbrEF;
    }

    public void setNbrEF(int nbrEF) {
        this.nbrEF = nbrEF;
    }
    @XmlAttribute(name = "NbrSFID")
    public int getNbrSFID() {
        return nbrSFID;
    }

    public void setNbrSFID(int nbrSFID) {
        this.nbrSFID = nbrSFID;
    }
    @XmlAttribute(name = "Type")
    @XmlJavaTypeAdapter(HexStringShortAdapter.class)
    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
    @XmlAttribute(name = "filename")
    public String getFilename() {
        return filename;
    }
    @XmlAttribute(name = "ART")
    public String getART() {
        return ART;
    }

    public void setART(String ART) {
        this.ART = ART;
    }
    @XmlAttribute(name = "SMR")
    @XmlJavaTypeAdapter(HexStringAdapter.class)
    public String getSMR() {
        return SMR;
    }

    public void setSMR(String SMR) {
        this.SMR = SMR;
    }
    @XmlAttribute(name = "NbrK")
    public int getNbrK() {
        return nbrK;
    }

    public void setNbrK(int nbrK) {
        this.nbrK = nbrK;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    @XmlElement(name = "EF")
    public List<ElementFile> getElementFiles() {
        return elementFiles;
    }

    public void setElementFiles(List<ElementFile> elementFiles) {
        this.elementFiles = elementFiles;
    }
    @XmlElement(name = "KeySet")
    public KeySet getKeySet() {
        return keySet;
    }

    public void setKeySet(KeySet keySet) {
        this.keySet = keySet;
    }
}
