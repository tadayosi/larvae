package larvae.cxf.services;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HelloServiceTest {
    @Test
    public void hello() {
        IHelloService service = new HelloService();
        assertThat(service.hello("CXF"), is("Hello, CXF!"));
    }
}
