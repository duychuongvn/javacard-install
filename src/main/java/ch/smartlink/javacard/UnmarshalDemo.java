package ch.smartlink.javacard;

/**
 * Created by huynhduychuong on 2/23/2016.
 */

import ch.smartlink.javacard.util.XmlUtil;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class UnmarshalDemo {
    public static void main(String[] args) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("customer.xsd"));
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        unmarshaller.setEventHandler(new MyValidationEventHandler());
        Customer customer = (Customer) unmarshaller.unmarshal(new File("input.xml"));
//        System.out.println(customer.getName());
        System.out.println(XmlUtil.convertObjectToXml(customer));
    }
}