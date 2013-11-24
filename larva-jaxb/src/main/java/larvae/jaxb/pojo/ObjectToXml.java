package larvae.jaxb.pojo;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import larvae.jaxb.pojo.model.Person;

public class ObjectToXml {

    private static final QName NS_PERSON = new QName("http://larvae/jaxb/pojo", "person");

    private Marshaller marshaller;

    public ObjectToXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    public String convert(Person person) throws JAXBException {
        ByteArrayOutputStream xml = new ByteArrayOutputStream();
        marshaller.marshal(new JAXBElement<Person>(NS_PERSON, Person.class, person), xml);
        return xml.toString();
    }

}
