package ch.smartlink.javacard.model;

import ch.smartlink.javacard.model.adapter.HexStringShortAdapter;
import ch.smartlink.javacard.model.adapter.StringShortKeyAlgAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by huynhduychuong on 1/22/2016.
 */
public class Key {

    private Short keyAddlInfo;

    private Short keyAlgoId;

    private Short keySecAttrib;

    private String diversification;

    private int keyLegth;

    private String keyValue;

    private String kvv;

    private KeySet keySet;
    @XmlAttribute(name = "KEY_ADDL_INFO")
    @XmlJavaTypeAdapter(HexStringShortAdapter.class)
    public Short getKeyAddlInfo() {
        return keyAddlInfo;
    }

    public void setKeyAddlInfo(Short keyAddlInfo) {
        this.keyAddlInfo = keyAddlInfo;
    }
    @XmlAttribute(name = "KEY_ALGO_ID")
    @XmlJavaTypeAdapter(StringShortKeyAlgAdapter.class)
    public Short getKeyAlgoId() {
        return keyAlgoId;
    }

    public void setKeyAlgoId(Short keyAlgoId) {
        this.keyAlgoId = keyAlgoId;
    }
    @XmlAttribute(name = "KEY_SEC_ATTRIB")
    @XmlJavaTypeAdapter(HexStringShortAdapter.class)
    public Short getKeySecAttrib() {
        return keySecAttrib;
    }

    public void setKeySecAttrib(Short keySecAttrib) {
        this.keySecAttrib = keySecAttrib;
    }
    @XmlAttribute(name = "diversification")
    public String getDiversification() {
        return diversification;
    }

    public void setDiversification(String diversification) {
        this.diversification = diversification;
    }
    @XmlAttribute(name = "keylegth")
    public int getKeyLegth() {
        return keyLegth;
    }

    public void setKeyLegth(int keyLegth) {
        this.keyLegth = keyLegth;
    }
    @XmlAttribute(name = "keyvalue")
    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
    @XmlAttribute(name = "kvv")
    public String getKvv() {
        return kvv;
    }

    public void setKvv(String kvv) {
        this.kvv = kvv;
    }
    @XmlElement(name = "KeySet")
    public KeySet getKeySet() {
        return keySet;
    }

    public void setKeySet(KeySet keySet) {
        this.keySet = keySet;
    }
}
