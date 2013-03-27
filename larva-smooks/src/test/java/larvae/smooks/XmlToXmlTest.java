package larvae.smooks;

import static org.custommonkey.xmlunit.XMLAssert.*;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;

public class XmlToXmlTest {

  private static final String INPUT    = "input-xml-to-xml.xml";
  private static final String EXPECTED = "<aaa><bbb><ccc value=\"XXXXX\"/></bbb></aaa>";

  @Before
  public void setUp() {
    XMLUnit.setIgnoreWhitespace(true);
  }

  @Test
  public void transform_XSLT() throws Exception {
    String result = new XmlToXml().transformXslt(INPUT);
    System.out.println(result);
    assertXMLEqual(EXPECTED, result);
  }

  @Test
  public void transform_FreeMarker() throws Exception {
    String result = new XmlToXml().transformFreeMarker(INPUT);
    System.out.println(result);
    assertXMLEqual(EXPECTED, result);
  }

  @Test
  public void transform_Visitor() throws Exception {
    String result = new XmlToXml().transformVisitor(INPUT);
    System.out.println(result);
    assertXMLEqual(EXPECTED, result);
  }

}
