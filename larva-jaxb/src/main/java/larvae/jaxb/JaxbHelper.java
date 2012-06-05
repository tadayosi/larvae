package larvae.jaxb;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbHelper {
  private JAXBContext  context;
  private Unmarshaller unmarshaller;
  private Marshaller   marshaller;

  public JaxbHelper(String contextPath) {
    try {
      this.context = JAXBContext.newInstance(contextPath);
      this.unmarshaller = context.createUnmarshaller();
      this.marshaller = context.createMarshaller();
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  public <T> T unmarshal(InputStream in) {
    try {
      @SuppressWarnings("unchecked")
      T obj = (T) unmarshaller.unmarshal(in);
      return obj;
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }

  public String marshal(Object obj) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {
      marshaller.marshal(obj, out);
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
    return new String(out.toByteArray());
  }
}
