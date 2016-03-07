package ch.smartlink.javacard.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by huynhduychuong on 2/25/2016.
 */
public class StringShortKeyAlgAdapter extends XmlAdapter<String, Short> {
    private static final Map<String, Short> keyAlgMap = new HashMap<String, Short>();
    static {
        keyAlgMap.put("AES-128", (short)0x09);
    }
    @Override
    public Short unmarshal(String v) throws Exception {
        if(v ==null) {
            return null;
        }
        return keyAlgMap.get(v);
    }

    @Override
    public String marshal(Short v) throws Exception {
        if(v==null) {
            return null;
        }
        Iterator<Map.Entry<String, Short>> iterator = keyAlgMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Short> entry = iterator.next();
            if(entry.getValue().equals(v)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Cannot map Key Alg: " + v);
    }
}
