package larvae.jaxb.adapter;

import static org.custommonkey.xmlunit.XMLAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import larvae.jaxb.JaxbHelper;
import larvae.jaxb.adapter.model.Data;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;

public class AdaptersTest {

  //@formatter:off
  private static final String XML =
        "<ns:data xmlns:ns='http://larvae/jaxb/adapter'>"
      +   "<i>1</i>"
      +   "<s>1</s>"
      + "</ns:data>";
  //@formatter:on

  private JaxbHelper          helper;

  @Before
  public void setUp() {
    XMLUnit.setIgnoreWhitespace(true);
    helper = new JaxbHelper(new Class<?>[] { Data.class }, "schema1.xsd");
  }

  @Test
  public void marshal() throws Exception {
    assertThat(new IntegerToXSStringAdapter().marshal(1), is("1"));
    assertThat(new StringToXSIntAdapter().marshal("1"), is(1));

    System.out.println(helper.marshal(new Data(1, "1")));
    assertXMLEqual(XML, helper.marshal(new Data(1, "1")));
  }

  @Test
  public void unmarshal() throws Exception {
    assertThat(new IntegerToXSStringAdapter().unmarshal("1"), is(1));
    assertThat(new StringToXSIntAdapter().unmarshal(1), is("1"));

    Data data = helper.unmarshal(new ByteArrayInputStream(XML.getBytes()));
    assertThat(data.getI(), is(1));
    assertThat(data.getS(), is("1"));
  }

}
