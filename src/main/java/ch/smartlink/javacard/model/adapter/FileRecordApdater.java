package ch.smartlink.javacard.model.adapter;

import ch.smartlink.javacard.model.ContentType;
import ch.smartlink.javacard.model.FileContent;
import ch.smartlink.javacard.model.FileRecord;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by huynhduychuong on 2/24/2016.
 */
public class FileRecordApdater extends XmlAdapter<FileRecord, FileContent> {
    @Override
    public FileContent unmarshal(FileRecord v) throws Exception {
        return v;
    }

    @Override
    public FileRecord marshal(FileContent v) throws Exception {
        if (v == null) {
            return null;
        }
        FileRecord fileRecord;
        if (v.getType() == ContentType.records) {
            fileRecord = (FileRecord) v;
            fileRecord.setValue(null);
        } else {
            fileRecord = new FileRecord();
            fileRecord.setType(v.getType());
            fileRecord.setValue(v.getValue());
        }
        return fileRecord;
    }
}
