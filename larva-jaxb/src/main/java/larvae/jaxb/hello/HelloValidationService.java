package larvae.jaxb.hello;

import java.io.InputStream;

import larvae.jaxb.JaxbHelper;
import larvae.jaxb.hello.generated.HelloValidation;
import larvae.jaxb.hello.generated.HelloValidationResponse;
import larvae.jaxb.hello.generated.ObjectFactory;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloValidationService implements IHelloService {
  private static final Logger LOGGER        = LoggerFactory.getLogger(HelloValidationService.class);
  private JaxbHelper          jaxbHelper    = new JaxbHelper(ObjectFactory.class.getPackage().getName(),
                                                "xsd/hello/validation.xsd");
  private ObjectFactory       objectFactory = new ObjectFactory();

  public String say(InputStream helloXml) {
    HelloValidation hello = jaxbHelper.unmarshal(helloXml);
    LOGGER.info("Unmarshalled request:\n{}", ToStringBuilder.reflectionToString(hello, ToStringStyle.MULTI_LINE_STYLE));
    String message = String.format("Hello, %s!", hello.getName());
    HelloValidationResponse response = response(message);
    LOGGER.info("Raw response:\n{}", ToStringBuilder.reflectionToString(response, ToStringStyle.MULTI_LINE_STYLE));
    String responseXml = jaxbHelper.marshal(response);
    LOGGER.info("Marshalled response:\n{}", responseXml);
    return responseXml;
  }

  private HelloValidationResponse response(String message) {
    HelloValidationResponse response = objectFactory.createHelloValidationResponse();
    response.setMessage(message);
    return response;
  }
}
