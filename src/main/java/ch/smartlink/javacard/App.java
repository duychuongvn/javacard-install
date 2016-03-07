package ch.smartlink.javacard;

import ch.smartlink.javacard.model.ADF;
import ch.smartlink.javacard.model.MasterFile;
import ch.smartlink.javacard.util.XmlUtil;
import org.osptalliance.cipurse.CipurseException;
import org.osptalliance.cipurse.ICommsChannel;
import org.osptalliance.cipurse.impl.CommsChannel;

import javax.swing.*;
import javax.xml.bind.JAXBException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws JAXBException {
        System.out.println("Hello World!");

        String applet = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<MF ART=\"FF FF FF FF FF FF FF FF FF\" FileID=\"0x3F00\" NbrK=\"8\" SMR=\"0x0000\" filename=\"CIPURSE MF\">\n" +
                "<KeySet>\n" +
                "<key KEY_ADDL_INFO=\"0x01\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:Unknown Key - KVV=5A9A4D\" kvv=\"5A 9A 4D\"/>\n" +
                "<key KEY_ADDL_INFO=\"0x01\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:CIPURSE/MF_DefaultKey\" kvv=\"5F D6 7B\"/>\n" +
                "<key KEY_ADDL_INFO=\"0x00\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:CIPURSE/MF_DefaultKey\" kvv=\"5F D6 7B\"/>\n" +
                "<key KEY_ADDL_INFO=\"0x00\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:CIPURSE/MF_DefaultKey\" kvv=\"5F D6 7B\"/>\n" +
                "<key KEY_ADDL_INFO=\"0x00\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:CIPURSE/MF_DefaultKey\" kvv=\"5F D6 7B\"/>\n" +
                "<key KEY_ADDL_INFO=\"0x00\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:CIPURSE/MF_DefaultKey\" kvv=\"5F D6 7B\"/>\n" +
                "<key KEY_ADDL_INFO=\"0x00\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:CIPURSE/MF_DefaultKey\" kvv=\"5F D6 7B\"/>\n" +
                "<key KEY_ADDL_INFO=\"0x00\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"vault:CIPURSE/MF_DefaultKey\" kvv=\"5F D6 7B\"/>\n" +
                "</KeySet>\n" +
                "<EF ART=\"C1 C1 C1 C1 C1 C1 C1 C1 C1\" FD=\"binary\" FileID=\"0x2FF1\" FileSize=\"24\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"EF.FILELIST\">\n" +
                "<content type=\"binary\">2F F7 00 01 2F F3 00 01 2F F1 00 01 5F 02 00 3F 5F 01 00 38 5F 04 00 38</content>\n" +
                "</EF>\n" +
                "<EF ART=\"C3 C3 C3 C3 C3 C3 C3 C3 C3\" FD=\"binary\" FileID=\"0x2FF3\" FileSize=\"26\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"EF.IO_CONFIG\">\n" +
                "<content type=\"binary\">8B 07 80 84 00 78 77 74 03 8C 07 77 43 32 54 01 01 00 00 00 00 00 00 00 00 00</content>\n" +
                "</EF>\n" +
                "<EF ART=\"C1 C1 C1 C1 C1 C1 C1 C1 C1\" FD=\"binary\" FileID=\"0x2FF7\" FileSize=\"40\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"EF.ID_INFO\">\n" +
                "<content type=\"binary\">02 02 05 07 00 00 00 00 05 37 70 29 55 05 10 61 C2 00 00 03 E9 00 00 00 02 00 00 00 00 00 00 00 00 84 01 01 00 43 32 54</content>\n" +
                "</EF>\n" +
                "<ADF AID=\"DF 00 00 00 00 00 11 11\" FD=\"df_cipurse\" FileID=\"0x5F01\" NbrEF=\"5\" NbrSFID=\"5\" Type=\"0x40\" filename=\"ADF 5F01\">\n" +
                "<EF FD=\"binary\" FileID=\"0x2FF1\" FileSize=\"16\" SFID=\"0x00\" filename=\"EF.FILELIST\">\n" +
                "<content type=\"binary\">2F F7 00 01 2F F1 00 01 5F 02 01 01 5F 03 00 06</content>\n" +
                "</EF>\n" +
                "<EF FD=\"binary\" FileID=\"0x2FF7\" FileSize=\"40\" SFID=\"0x00\" filename=\"EF.ID_INFO\">\n" +
                "<content type=\"binary\">02 02 05 07 00 00 00 00 05 37 70 29 55 05 10 61 C2 00 00 03 E9 00 00 00 02 00 00 00 00 00 00 00 00 84 01 01 00 43 32 54</content>\n" +
                "</EF>\n" +
                "<EF FD=\"binary\" FileID=\"0x5F02\" FileSize=\"58\" SFID=\"0x01\" filename=\"Binary file\">\n" +
                "<content type=\"binary\">33 37 66 38 33 32 32 61 2D 66 34 65 62 2D 34 34 33 31 2D 62 65 66 36 2D 61 30 36 30 62 37 65 64 36 63 63 34 3A 3A 3A 30 30 30 30 30 30 2D 31 34 30 2E 30 30 3A 3A 3A 45 55 52</content>\n" +
                "</EF>\n" +
                "<EF FD=\"cyclicrecord\" FileID=\"0x5F03\" NbrRec=\"10\" RecSize=\"184\" SFID=\"0x00\" filename=\"Cyclic record file\">\n" +
                "<content type=\"records\">\n" +
                "<record>31 34 34 39 38 38 33 36 38 30 35 33 32 3A 3A 3A 35 36 30 42 35 43 45 38 31 3A 3A 3A 36 34 37 32 38 33 37 30 3A 3A 3A 30 30 30 30 30 30 2D 31 34 30 2E 30 30 3A 3A 3A 30 30 30 30 30 30 2D 31 34 30 2E 30 30 3A 3A 3A 45 55 52 3A 3A 3A 30 3A 3A 3A 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 44 65 66 61 75 6C 74 3A 3A 3A 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 4D 6F 62 69 6C 65</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "</content>\n" +
                "</EF>\n" +
                "</ADF>\n" +
                "<ADF AID=\"5F 02 00 00 00 00 00 00 00 01\" FD=\"PxSE\" FileID=\"0x5F02\" NbrEF=\"0\" NbrSFID=\"0\" Type=\"0x00\" filename=\"PxSE Demo 1\"/>\n" +
                "<ADF AID=\"5F 02 00 00 00 00 00 00 00 01 01\" ART=\"FF FF\" FD=\"df_cipurse\" FileID=\"0x5F04\" NbrEF=\"10\" NbrK=\"1\" NbrSFID=\"5\" SMR=\"0x0000\" Type=\"0x63\" filename=\"ADF On PxSE\">\n" +
                "<KeySet>\n" +
                "<key KEY_ADDL_INFO=\"0x01\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"none\" keylegth=\"16\" keyvalue=\"73 73 73 73 73 73 73 73 73 73 73 73 73 73 73 73\" kvv=\"5F D6 7B\"/>\n" +
                "</KeySet>\n" +
                "<EF ART=\"FF FF\" FD=\"binary\" FileID=\"0x0002\" FileSize=\"10\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"New EF 1\">\n" +
                "<content type=\"binary\">00 00 00 00 00 00 00 00 00 00</content>\n" +
                "</EF>\n" +
                "<EF ART=\"FF FF\" FD=\"cyclicrecord\" FileID=\"0x0003\" NbrRec=\"10\" RecSize=\"10\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"New EF 2\">\n" +
                "<content type=\"records\">\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "</content>\n" +
                "</EF>\n" +
                "<EF ART=\"C1 C1\" FD=\"binary\" FileID=\"0x2FF7\" FileSize=\"40\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"EF.ID_INFO\">\n" +
                "<content type=\"binary\">02 02 05 07 00 00 00 00 05 37 70 29 55 05 10 61 C2 00 00 03 E9 00 00 00 02 00 00 00 00 00 00 00 00 84 01 01 00 43 32 54</content>\n" +
                "</EF>\n" +
                "<EF ART=\"C1 C1\" FD=\"binary\" FileID=\"0x2FF1\" FileSize=\"8\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"EF.FILELIST\">\n" +
                "<content type=\"binary\"><content>2F F7 00 01 2F F1 00 01</content></content>\n" +
                "</EF>\n" +
                "</ADF>\n" +
                "</MF>";

        MasterFile masterFile = XmlUtil.convertXmlToObject(applet, MasterFile.class);
        System.out.println(masterFile.getFilename());

        System.out.println(XmlUtil.convertObjectToXml(masterFile));


        String adf = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<ADF AID=\"D2 76 00 00 04 15 02 00 00 03 00 01 01\" ART=\"40 00 00 13\" FD=\"df_cipurse\" FileID=\"0x5F00\" NbrEF=\"1\" NbrK=\"3\" NbrSFID=\"1\" SMR=\"0x0006\" Type=\"0x08\" filename=\"Facility Access ADF\">\n" +
                "\t<KeySet>\n" +
                "\t\t<key KEY_ADDL_INFO=\"0x01\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"None\" keylegth=\"16\" keyvalue=\"73 73 73 73 73 73 73 73 73 73 73 73 73 73 73 73\" kvv=\"B8 82 91\"/>\n" +
                "\t\t<key KEY_ADDL_INFO=\"0x01\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"None\" keylegth=\"16\" keyvalue=\"73 73 73 73 73 73 73 73 73 73 73 73 73 73 73 73\" kvv=\"A5 6F D8\"/>\n" +
                "\t\t<key KEY_ADDL_INFO=\"0x01\" KEY_ALGO_ID=\"AES-128\" KEY_SEC_ATTRIB=\"0x02\" diversification=\"None\" keylegth=\"16\" keyvalue=\"73 73 73 73 73 73 73 73 73 73 73 73 73 73 73 73\" kvv=\"85 76 70\"/>\n" +
                "\t</KeySet>\n" +
                "\t<EF ART=\"C1 C1 C1 C1\" FD=\"binary\" FileID=\"0x2FF1\" FileSize=\"28\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"EF.FILELIST\">\n" +
                "\t\t<content type=\"binary\">2F F7 00 01 2F F1 00 01 5F 01 01 01 5F 02 02 12 5F 03 03 06 5F 04 00 1F 00 00 00 00</content>\n" +
                "\t</EF>\n" +
                "\t<EF ART=\"C1 C1 C1 C1\" FD=\"binary\" FileID=\"0x2FF7\" FileSize=\"40\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"EF.ID_INFO\">\n" +
                "\t\t<content type=\"binary\">02 00 01 07 00 00 00 00 05 02 69 98 00 14 00 18 00 3C 63 63 66 30 37 FF 00 00 00 00 00 00 00 00 00 00 00 00 04 43 32 54</content>\n" +
                "\t</EF>\n" +
                "\t<EF ART=\"00 00 01 C2\" FD=\"binary\" FileID=\"0x5F01\" FileSize=\"100\" SFID=\"0x01\" SMR=\"0x0000\" filename=\"Binary file\">\n" +
                "\t\t<content type=\"binary\">00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00</content>\n" +
                "\t</EF>\n" +
                "\t<EF ART=\"00 00 01 C2\" FD=\"linearrecord_tm\" FileID=\"0x5F02\" NbrRec=\"5\" RecSize=\"10\" SFID=\"0x02\" SMR=\"0x0000\" filename=\"Linear record file\">\n" +
                "\t\t<content type=\"records\">\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t</content>\n" +
                "\t</EF>\n" +
                "\t<EF ART=\"00 00 01 C2\" FD=\"cyclicrecord\" FileID=\"0x5F03\" NbrRec=\"4\" RecSize=\"5\" SFID=\"0x03\" SMR=\"0x0000\" filename=\"Cyclic record file\">\n" +
                "\t\t<content type=\"records\">\n" +
                "\t\t\t<record>01 00 00 00 00</record>\n" +
                "\t\t\t<record>02 00 00 00 00</record>\n" +
                "\t\t\t<record>03 00 00 00 00</record>\n" +
                "\t\t\t<record>04 00 00 00 00</record>\n" +
                "\t\t</content>\n" +
                "\t</EF>\n" +
                "\t<EF ART=\"00 00 05 DA\" FD=\"valuerecord_tm\" FileID=\"0x5F04\" NbrRec=\"3\" RecSize=\"12\" SFID=\"0x00\" SMR=\"0x0000\" filename=\"Value record file\">\n" +
                "\t\t<content type=\"records\">\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t\t<record>00 00 00 00 00 00 00 00 00 00 00 00</record>\n" +
                "\t\t</content>\n" +
                "\t</EF>\n" +
                "</ADF>";

        ADF adf1 = XmlUtil.convertXmlToObject(adf, ADF.class);
        String[] choices = CommsChannel.getPCSCTerminals();
        if (choices != null) {
            String readerName = (String) JOptionPane.showInputDialog(null,
                    "Select Reader for the operation", "Reader Selection",
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices.length > 1 ? choices[0] : "");
            if (readerName != null && !readerName.trim().equals("")) {
            }
            ICommsChannel commsChannel = new CommsChannel(readerName);
                try {
                        CardInstall cardInstall = new CardInstall(commsChannel);
                        cardInstall.installADF(adf1);
                } catch (CipurseException e) {
                        e.printStackTrace();
                }
        }
        System.out.println(XmlUtil.convertObjectToXml(adf1));
    }
}
