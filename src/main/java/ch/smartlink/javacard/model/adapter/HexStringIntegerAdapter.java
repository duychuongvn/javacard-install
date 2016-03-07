package ch.smartlink.javacard.model.adapter;

import ch.smartlink.javacard.util.MessageUtil;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by huynhduychuong on 2/25/2016.
 */
public class HexStringIntegerAdapter extends XmlAdapter<String, Integer> {
    @Override
    public Integer unmarshal(String v) throws Exception {
        if(v==null) {
            return null;
        }

        return Integer.decode(v);
    }

    @Override
    public String marshal(Integer v) throws Exception {
        if(v==null) {
            return null;
        }
        return MessageUtil.byteArrayToHexString(new byte[]{v.byteValue()});
    }
}