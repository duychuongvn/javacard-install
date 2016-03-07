package ch.smartlink.javacard.util;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by huynhduychuong on 1/22/2016.
 */
public class XmlUtil {
    public static String convertObjectToXml(Object objectValue) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(objectValue.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            jaxbMarshaller.marshal(objectValue, stringWriter);
            return stringWriter.toString();
        } catch (JAXBException e) {
            throw new InvalidXMLFormatException(e);
        }
    }

    /**
     *
     * @param processResult
     * @param className
     * @param <T>
     * @return
     * @throws JAXBException
     */
    public static <T> T convertXmlToObject(String processResult, Class<T> className) throws JAXBException {
        return JAXB.unmarshal(new StringReader(processResult), className);
    }

    public static class InvalidXMLFormatException extends RuntimeException {
        public InvalidXMLFormatException(Throwable throwable) {
            super(throwable);
        }
    }
}