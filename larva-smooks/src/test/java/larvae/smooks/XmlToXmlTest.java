package larvae.smooks;

import static org.junit.Assert.*;

import org.junit.Test;

public class XmlToXmlTest {

  //@formatter:off
  private static final String EXPECTED =
      "<aaa>\n"
    + "  <bbb>\n"
    + "    <ccc value=\"XXXXX\"></ccc>\n"
    + "  </bbb>\n"
    + "</aaa>";
  //@formatter:on

  @Test
  public void transform_XSLT() throws Exception {
    String result = new XmlToXml().transformXslt("input.xml");
    System.out.println(result);
    assertEquals(EXPECTED, result);
  }

  @Test
  public void transform_FreeMarker() throws Exception {
    String result = new XmlToXml().transformFreeMarker("input.xml");
    System.out.println(result);
    assertEquals(EXPECTED, result);
  }

}
