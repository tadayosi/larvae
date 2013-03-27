package larvae.smooks;

import static org.junit.Assert.*;
import larvae.smooks.model.Aaa;
import larvae.smooks.model.Type;

import org.junit.Test;

public class XmlToJavaTest {

  private static final String INPUT = "input-xml-to-java.xml";

  @Test
  public void transform() throws Exception {
    Aaa result = new XmlToJava().transform(INPUT);
    System.out.println(result);
    assertEquals(Type.X, result.getBbb().getCcc().getType());
    assertEquals("XXXXX", result.getBbb().getCcc().getValue());
  }

}
