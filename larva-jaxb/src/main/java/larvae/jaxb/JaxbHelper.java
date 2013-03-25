package larvae.jaxb;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class JaxbHelper {
  private JAXBContext  context;
  private Unmarshaller unmarshaller;
  private Marshaller   marshaller;

  public JaxbHelper(String contextPath, String schemaLocation) {
    this(contextPath, schemaLocation, true);
  }

  public JaxbHelper(String contextPath, String schemaLocation, boolean validate) {
    try {
      this.context = JAXBContext.newInstance(contextPath);
      this.unmarshaller = context.createUnmarshaller();
      this.marshaller = context.createMarshaller();
      if (validate) {
        Schema schema = readSchema(schemaLocation);
        unmarshaller.setSchema(schema);
        marshaller.setSchema(schema);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Schema readSchema(String schemaLocation) throws SAXException {
    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    return factory.newSchema(new StreamSource(ClassLoader.getSystemResourceAsStream(schemaLocation)));
  }

  public <T> T unmarshal(InputStream in) {
    try {
      @SuppressWarnings("unchecked")
      T obj = (T) unmarshaller.unmarshal(in);
      return obj;
    } catch (JAXBException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public String marshal(Object obj) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {
      marshaller.marshal(obj, out);
    } catch (JAXBException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return new String(out.toByteArray());
  }
}
