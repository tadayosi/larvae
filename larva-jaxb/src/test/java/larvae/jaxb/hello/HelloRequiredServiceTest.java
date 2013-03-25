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

public class HelloRequiredServiceTest {
  private DocumentBuilder documentBuilder = null;
  private XPath           xPath           = null;

  @Before
  public void setUp() throws ParserConfigurationException {
    documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    xPath = XPathFactory.newInstance().newXPath();
  }

  @Test
  public void say() {
    HelloRequiredService target = new HelloRequiredService(true);
    String responseXml = target.say(ClassLoader.getSystemResourceAsStream("hello-required.xml"));
    assertThat(extract(responseXml, "/helloRequiredResponse/message/text()"), is("Hello, JAXB!"));
  }

  @Test
  public void say_null() {
    HelloRequiredService target = new HelloRequiredService(false);
    String responseXml = target.say(ClassLoader.getSystemResourceAsStream("hello-required-null.xml"));
    assertThat(extract(responseXml, "/helloRequiredResponse/message/text()"), is("Hello, null!"));
  }

  @Test(expected = RuntimeException.class)
  public void say_validateNull() {
    HelloRequiredService target = new HelloRequiredService(true);
    target.say(ClassLoader.getSystemResourceAsStream("hello-required-null.xml"));
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
