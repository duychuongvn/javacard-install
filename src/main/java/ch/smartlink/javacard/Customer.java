package ch.smartlink.javacard;

/**
 * Created by huynhduychuong on 2/23/2016.
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private ContactInfo contactInfo;

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

}