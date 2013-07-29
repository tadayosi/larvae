package larvae.cdi;

import javax.inject.Inject;

public class GreetingService {

  private static final String HELLO   = "Hello, %s!";
  private static final String GOODBYE = "Goodbye, %s!";

  @Inject
  private GreetingHelper      helper;

  public String hello(String name) {
    return helper.createMessage(HELLO, name);
  }

  public String goodbye(String name) {
    return helper.createMessage(GOODBYE, name);
  }

}
