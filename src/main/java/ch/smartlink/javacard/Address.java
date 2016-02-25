package ch.smartlink.javacard;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

/**
 * Created by huynhduychuong on 2/23/2016.
 */
@XmlRootElement(name = "address")
public class Address extends ContactInfo {


    private String type = "address";
    private String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlAttribute(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
