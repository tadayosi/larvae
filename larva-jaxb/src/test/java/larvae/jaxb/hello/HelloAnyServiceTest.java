package larvae.jaxb.hello;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

public class HelloAnyServiceTest {
  private DocumentBuilder documentBuilder = null;
  private XPath           xPath           = null;

  @Before
  public void setUp() throws ParserConfigurationException {
    documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    xPath = XPathFactory.newInstance().newXPath();
  }

  @Test
  public void say() {
    HelloAnyService target = new HelloAnyService();
    String responseXml = target.say(ClassLoader.getSystemResourceAsStream("hello-any.xml"));
    assertThat(extract(responseXml, "/helloAnyResponse/message/text()"), is("Hello, JAXB!"));
  }

  private String extract(String responseXml, String expression) {
    try {
      Document responseDoc = documentBuilder.parse(new ByteArrayInputStream(responseXml.getBytes("UTF-8")));
      return xPath.compile(expression).evaluate(responseDoc);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
