package larvae.jaxb.hello;

import java.io.InputStream;

import larvae.jaxb.JaxbHelper;
import larvae.jaxb.hello.model.Hello;
import larvae.jaxb.hello.model.HelloResponse;
import larvae.jaxb.hello.model.ObjectFactory;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloService implements IHelloService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);
    private JaxbHelper jaxbHelper = new JaxbHelper(ObjectFactory.class.getPackage().getName(), "xsd/hello/hello.xsd");
    private ObjectFactory objectFactory = new ObjectFactory();

    public String say(InputStream helloXml) {
        Hello hello = jaxbHelper.unmarshal(helloXml);
        LOGGER.info("Unmarshalled request:\n{}",
                ToStringBuilder.reflectionToString(hello, ToStringStyle.MULTI_LINE_STYLE));
        String message = String.format("Hello, %s!", hello.getName());
        HelloResponse response = response(message);
        LOGGER.info("Raw response:\n{}", ToStringBuilder.reflectionToString(response, ToStringStyle.MULTI_LINE_STYLE));
        String responseXml = jaxbHelper.marshal(response);
        LOGGER.info("Marshalled response:\n{}", responseXml);
        return responseXml;
    }

    private HelloResponse response(String message) {
        HelloResponse response = objectFactory.createHelloResponse();
        response.setMessage(message);
        return response;
    }
}
