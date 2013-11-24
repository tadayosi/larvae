package larvae.aspectj.greeting;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import larvae.aspectj.greeting.GreetingService;

import org.junit.Test;

public class GreetingServiceTest {

    @Test
    public void hello() {
        GreetingService target = new GreetingService();
        String response = target.hello("AspectJ");
        assertThat(response, is("Hello, AspectJ!"));
    }

    @Test
    public void goodbye() {
        GreetingService target = new GreetingService();
        String response = target.goodbye("AspectJ");
        assertThat(response, is("Goodbye, AspectJ!"));
    }

}
