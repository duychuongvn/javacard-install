package ch.smartlink.javacard.model;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;

/**
 * Created by huynhduychuong on 2/23/2016.
 */
//@XmlRootElement
@XmlRootElement(name = "content")
//@XmlSeeAlso(FileRecord.class)
public  class ContentCondition extends ArrayList{

    private String value = "ada";

    @XmlAnyElement
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
