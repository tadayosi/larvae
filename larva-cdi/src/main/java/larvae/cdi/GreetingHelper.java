package larvae.cdi;

public class GreetingHelper {

  public String createMessage(String template, Object... params) {
    return String.format(template, params);
  }

}
