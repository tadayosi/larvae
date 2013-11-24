package larvae.cxf.services;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IHelloService {
    String hello(@WebParam(name = "name") String name);
}
