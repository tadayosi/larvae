package larvae.jbossws.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloService {
  @WebMethod
  public String hello(String name) {
    return String.format("Hello, %s!", name);
  }
}
