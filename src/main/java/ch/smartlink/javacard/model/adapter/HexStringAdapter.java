package ch.smartlink.javacard.model.adapter;

import org.osptalliance.cipurse.commands.ByteArray;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by huynhduychuong on 2/25/2016.
 */
public class HexStringAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String v) throws Exception {
        if (v == null) {
            return null;
        }
        if (v.startsWith("0x")) {
            v = v.substring(2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < v.length()) {
            stringBuilder.append(v.substring(index, index + 2)).append(" ");
            index += 2;

        }
        return stringBuilder.toString();
    }

    @Override
    public String marshal(String v) throws Exception {
        return v;
    }
}
