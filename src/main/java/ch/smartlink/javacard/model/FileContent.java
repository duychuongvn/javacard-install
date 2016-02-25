package ch.smartlink.javacard.model;

import ch.smartlink.javacard.model.adapter.FileRecordApdater;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by huynhduychuong on 1/22/2016.
 */

@XmlJavaTypeAdapter(FileRecordApdater.class)
public abstract class FileContent {

    private ContentType type;
    private String value;

    @XmlAttribute(name = "type")
    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }

    @XmlValue()
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
