package ch.smartlink.javacard.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by huynhduychuong on 2/24/2016.
 */
@XmlRootElement(name = "record")
public class Record {

    private String record;

    @XmlValue
    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
