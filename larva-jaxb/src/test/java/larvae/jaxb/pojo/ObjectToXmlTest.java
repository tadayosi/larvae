package larvae.jaxb.pojo;

import static org.custommonkey.xmlunit.XMLAssert.*;
import larvae.jaxb.pojo.model.Name;
import larvae.jaxb.pojo.model.Nationality;
import larvae.jaxb.pojo.model.Person;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;

public class ObjectToXmlTest {

  @Before
  public void setUp() {
    XMLUnit.setIgnoreWhitespace(true);
  }

  @Test
  public void convert() throws Exception {
    //@formatter:off
    String expected =
          "<ns2:person xmlns:ns2=\"http://larvae/jaxb/pojo\">"
        + "  <name>"
        + "    <family>Fitzgerald</family>"
        + "    <first>Francis</first>"
        + "    <middle>Scott</middle>"
        + "  </name>"
        + "  <age>44</age>"
        + "  <nationality>USA</nationality>"
        + "</ns2:person>";
    //@formatter:on
    Person person = new Person(new Name("Fitzgerald", "Francis", "Scott"), 44, Nationality.USA);
    String xml = new ObjectToXml().convert(person);
    System.out.println(xml);
    assertXMLEqual(expected, xml);
  }

}
