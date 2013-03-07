package larvae.aspectj.greeting;

public class GreetingService {

  public String hello(String name) {
    return "Hello, " + name + "!";
  }

  @Logging
  public String goodbye(String name) {
    return "Goodbye, " + name + "!";
  }

}
