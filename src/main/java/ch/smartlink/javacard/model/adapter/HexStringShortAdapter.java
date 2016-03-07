package ch.smartlink.javacard.model.adapter;

import ch.smartlink.javacard.util.MessageUtil;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by huynhduychuong on 2/25/2016.
 */
public class HexStringShortAdapter extends XmlAdapter<String, Short> {
    @Override
    public Short unmarshal(String v) throws Exception {
        if(v==null) {
            return null;
        }

        return Short.decode(v);
    }

    @Override
    public String marshal(Short v) throws Exception {
        if(v==null) {
            return null;
        }
        return MessageUtil.byteArrayToHexString(new byte[]{v.byteValue()});
    }
}
