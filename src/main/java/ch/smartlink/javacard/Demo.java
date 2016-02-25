package ch.smartlink.javacard;

/**
 * Created by huynhduychuong on 2/23/2016.
 */
import ch.smartlink.javacard.util.XmlUtil;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringReader;

public class Demo {

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        Address address = new Address();
        address.setStreet("1 A Street");
        customer.setContactInfo(address);
/*
        JAXBContext jc = JAXBContext.newInstance(Customer.class, Address.class, PhoneNumber.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);*/
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("schema.xsd"));
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        unmarshaller.setEventHandler(new MyValidationEventHandler());
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<customer>\n" +
                "    <contactInfo>\n" +
                "        <street>1 A Street</street>\n" +
                "    </contactInfo>\n" +
                "</customer>";

        Customer customer1 = (Customer)unmarshaller.unmarshal(new StringReader(data));

        System.out.println(XmlUtil.convertObjectToXml(customer1));
    }

}