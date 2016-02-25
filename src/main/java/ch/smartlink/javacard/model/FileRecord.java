package ch.smartlink.javacard.model;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huynhduychuong on 1/22/2016.
 */
@XmlRootElement()
public class FileRecord  extends FileContent{

    public FileRecord() {
       setType(ContentType.records);
    }

    private String [] records = new String[0];
    @XmlElement(name = "record")
    public String[] getRecords() {
        return records;
    }

    public void setRecords(String[] records) {
        this.records = records;
    }

}
