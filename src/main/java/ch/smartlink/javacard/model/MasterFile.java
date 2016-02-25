package ch.smartlink.javacard.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by huynhduychuong on 1/22/2016.
 */
@XmlRootElement(name = "MF")
@XmlType(propOrder = {"keySet","elementFiles", "adfs"})
public class MasterFile {

    private String ART;

    private String fileID;


    private int nbrK;

    private String SMR;

    private String filename;

    private KeySet keySet;
    private List<ElementFile> elementFiles = new ArrayList<ElementFile>();

    private List<ADF> adfs = new ArrayList<ADF>();



    @XmlAttribute(name = "ATR")
    public String getART() {
        return ART;
    }

    public void setART(String ART) {
        this.ART = ART;
    }
    @XmlAttribute(name = "FileID")
    public String getFileID() {
        return fileID;
    }

    public void setFileID(String fileID) {
        this.fileID = fileID;
    }
    @XmlAttribute(name = "NbrK")
    public int getNbrK() {
        return nbrK;
    }

    public void setNbrK(int nbrK) {
        this.nbrK = nbrK;
    }
    @XmlAttribute(name = "SMR")
    public String getSMR() {
        return SMR;
    }

    public void setSMR(String SMR) {
        this.SMR = SMR;
    }
    @XmlAttribute(name = "filename")
    public String getFilename() {
        return filename;
    }
    @XmlElement(name = "KeySet")
    public KeySet getKeySet() {
        return keySet;
    }

    public void setKeySet(KeySet keySet) {
        this.keySet = keySet;
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
    @XmlElement(name = "ADF")
    public List<ADF> getAdfs() {
        return adfs;
    }

    public void setAdfs(List<ADF> adfs) {
        this.adfs = adfs;
    }

}
