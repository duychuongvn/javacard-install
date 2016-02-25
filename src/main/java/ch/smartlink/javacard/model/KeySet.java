package ch.smartlink.javacard.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huynhduychuong on 1/22/2016.
 */
public class KeySet {
    @XmlElement(name = "key")
    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    private List<Key> keys = new ArrayList<Key>();
}
