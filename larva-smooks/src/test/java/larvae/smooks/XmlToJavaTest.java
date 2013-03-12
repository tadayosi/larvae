package larvae.smooks;

import static org.junit.Assert.*;
import larvae.smooks.model.Aaa;

import org.junit.Test;

public class XmlToJavaTest {

  @Test
  public void transform() throws Exception {
    Aaa result = new XmlToJava().transform("input.xml");
    System.out.println(result);
    assertEquals("XXXXX", result.getBbb().getCcc().getValue());
  }

}
