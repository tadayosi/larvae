package larvae.jaxb.hello;

import java.io.InputStream;

import larvae.jaxb.JaxbHelper;
import larvae.jaxb.hello.generated.HelloRequired;
import larvae.jaxb.hello.generated.HelloRequiredResponse;
import larvae.jaxb.hello.generated.ObjectFactory;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloRequiredService implements IHelloService {
  private static final Logger LOGGER        = LoggerFactory.getLogger(HelloRequiredService.class);
  private JaxbHelper          jaxbHelper;
  private ObjectFactory       objectFactory = new ObjectFactory();

  public HelloRequiredService(boolean validate) {
    jaxbHelper = new JaxbHelper(ObjectFactory.class.getPackage().getName(), "xsd/hello-required.xsd", validate);
  }

  public String say(InputStream helloXml) {
    HelloRequired hello = jaxbHelper.unmarshal(helloXml);
    LOGGER.info("Unmarshalled request:\n{}", ToStringBuilder.reflectionToString(hello, ToStringStyle.MULTI_LINE_STYLE));
    String message = String.format("Hello, %s!", hello.getName());
    HelloRequiredResponse response = response(message);
    LOGGER.info("Raw response:\n{}", ToStringBuilder.reflectionToString(response, ToStringStyle.MULTI_LINE_STYLE));
    String responseXml = jaxbHelper.marshal(response);
    LOGGER.info("Marshalled response:\n{}", responseXml);
    return responseXml;
  }

  private HelloRequiredResponse response(String message) {
    HelloRequiredResponse response = objectFactory.createHelloRequiredResponse();
    response.setMessage(message);
    return response;
  }
}
