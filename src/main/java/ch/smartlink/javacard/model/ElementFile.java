package ch.smartlink.javacard.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by huynhduychuong on 1/22/2016.
 */
public class ElementFile {

    private String ART;

    private String fileID;


    private FileDefinition fileDefinition;

    private int fileSize;

    private String SFID;

    private String SMR;

    private String fileName;


    private FileContent fileContent;


    @XmlAttribute(name = "ART")
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
    @XmlAttribute(name = "FD")
    public FileDefinition getFileDefinition() {
        return fileDefinition;
    }

    public void setFileDefinition(FileDefinition fileDefinition) {
        this.fileDefinition = fileDefinition;
    }
    @XmlAttribute(name = "FileSize")
    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
    @XmlAttribute(name = "SFID")
    public String getSFID() {
        return SFID;
    }

    public void setSFID(String SFID) {
        this.SFID = SFID;
    }
    @XmlAttribute(name = "SMR")
    public String getSMR() {
        return SMR;
    }

    public void setSMR(String SMR) {
        this.SMR = SMR;
    }
    @XmlAttribute(name = "filename")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @XmlElement(name = "content")
    public FileContent getFileContent() {
        return fileContent;
    }

    public void setFileContent(FileContent fileContent) {
        this.fileContent = fileContent;
    }
}
