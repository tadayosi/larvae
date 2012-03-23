package larvae.jbossws.services;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HelloServiceTest {
  @Test
  public void hello() {
    HelloService service = new HelloService();
    assertThat(service.hello("JBossWS"), is("Hello, JBossWS!"));
  }
}
