package larvae.smooks;

import static org.junit.Assert.*;

import org.junit.Test;

public class XmlToXmlTest {

  private static final String INPUT      = "input-xml-to-xml.xml";

  private static final String EXPECTED_1 = "<aaa><bbb><ccc value=\"XXXXX\"></ccc></bbb></aaa>";
  private static final String EXPECTED_2 = "<aaa><bbb><ccc value=\"XXXXX\" /></bbb></aaa>";

  @Test
  public void transform_XSLT() throws Exception {
    String result = new XmlToXml().transformXslt(INPUT);
    System.out.println(result);
    assertXmlEquals(EXPECTED_1, result);
  }

  @Test
  public void transform_FreeMarker() throws Exception {
    String result = new XmlToXml().transformFreeMarker(INPUT);
    System.out.println(result);
    assertXmlEquals(EXPECTED_2, result);
  }

  @Test
  public void transform_Visitor() throws Exception {
    String result = new XmlToXml().transformVisitor(INPUT);
    System.out.println(result);
    assertXmlEquals(EXPECTED_1, result);
  }

  private static void assertXmlEquals(String expected, String result) {
    assertEquals(expected, result.replaceAll(">\\s+<", "><"));
  }

}
