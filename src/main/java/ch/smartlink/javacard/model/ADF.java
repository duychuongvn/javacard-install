package ch.smartlink.javacard.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huynhduychuong on 1/22/2016.
 *  data: ADF AID="DF 00 00 00 00 00 11 11" FD="df_cipurse" FileID="0x5F01" NbrEF="5" NbrSFID="5" Type="0x40" filename="ADF 5F01"
 */
@XmlRootElement(name = "ADF")
public class ADF {

    private String AID;

    private ADFDefinition fileDefinition;

    private String fileID;

    private int nbrEF;

    private int nbrSFID;

    private String type;

    private String filename;


    private List<ElementFile> elementFiles = new ArrayList<ElementFile>();

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
    public String getFileID() {
        return fileID;
    }

    public void setFileID(String fileID) {
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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @XmlAttribute(name = "filename")
    public String getFilename() {
        return filename;
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
}
