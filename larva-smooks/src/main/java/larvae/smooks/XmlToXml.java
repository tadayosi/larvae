package larvae.smooks;

import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.milyn.Smooks;
import org.milyn.payload.StringResult;
import org.xml.sax.SAXException;

public class XmlToXml {

  public String transformXslt(String inputXml) throws Exception {
    return transform("smooks/xml-to-xml-xsl.xml", inputXml);
  }

  public String transformFreeMarker(String inputXml) throws Exception {
    return transform("smooks/xml-to-xml-ftl.xml", inputXml);
  }

  private String transform(String config, String inputXml) throws IOException, SAXException {
    Smooks smooks = new Smooks(config);
    try {
      Source source = new StreamSource(ClassLoader.getSystemResourceAsStream(inputXml));
      StringResult result = new StringResult();
      smooks.filterSource(source, result);
      return result.getResult();
    } finally {
      smooks.close();
    }
  }

}
