package larvae.smooks;

import javax.xml.transform.stream.StreamSource;

import larvae.smooks.model.Aaa;

import org.milyn.Smooks;
import org.milyn.payload.JavaResult;

public class XmlToJava {
  public static void main(String[] args) throws Exception {
    Smooks smooks = new Smooks("smooks-config-xml-to-java.xml");
    try {
      JavaResult result = new JavaResult();
      smooks.filterSource(new StreamSource(ClassLoader.getSystemResourceAsStream("input.xml")), result);
      Aaa aaa = Aaa.class.cast(result.getBean("aaa"));
      System.out.println(aaa);
    } finally {
      smooks.close();
    }
  }
}
