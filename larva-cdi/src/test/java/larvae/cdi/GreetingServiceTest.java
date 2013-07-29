package larvae.cdi;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

public class GreetingServiceTest {

  @Test
  public void hello_goodbye() {
    Weld weld = new Weld();
    try {
      WeldContainer container = weld.initialize();
      GreetingService service = container.instance().select(GreetingService.class).get();
      assertThat(service.hello(getClass().getSimpleName()), is(equalTo("Hello, GreetingServiceTest!")));
      assertThat(service.goodbye(getClass().getSimpleName()), is(equalTo("Goodbye, GreetingServiceTest!")));
    } finally {
      weld.shutdown();
    }
  }

}
