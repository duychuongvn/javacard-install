package ch.smartlink.javacard.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by huynhduychuong on 1/22/2016.
 */
public class Key {

    private String keyAddlInfo;

    private String keyAlgoId;

    private String keySecAttrIB;

    private String diversification;

    private int keyLegth;

    private String keyValue;

    private String kvv;

    private KeySet keySet;
    @XmlAttribute(name = "KEY_ADDL_INFO")
    public String getKeyAddlInfo() {
        return keyAddlInfo;
    }

    public void setKeyAddlInfo(String keyAddlInfo) {
        this.keyAddlInfo = keyAddlInfo;
    }
    @XmlAttribute(name = "KEY_ALGO_ID")
    public String getKeyAlgoId() {
        return keyAlgoId;
    }

    public void setKeyAlgoId(String keyAlgoId) {
        this.keyAlgoId = keyAlgoId;
    }
    @XmlAttribute(name = "KEY_SEC_ATTRIB")
    public String getKeySecAttrIB() {
        return keySecAttrIB;
    }

    public void setKeySecAttrIB(String keySecAttrIB) {
        this.keySecAttrIB = keySecAttrIB;
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
