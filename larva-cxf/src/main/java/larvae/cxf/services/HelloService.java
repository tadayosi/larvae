package larvae.cxf.services;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(endpointInterface = "larvae.cxf.services.IHelloService", serviceName = "HelloService")
public class HelloService implements IHelloService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

    public String hello(String name) {
        LOGGER.info("Called from {}", name);
        return String.format("Hello, %s!", name);
    }
}
