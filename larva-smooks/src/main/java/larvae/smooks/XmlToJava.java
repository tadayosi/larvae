package larvae.smooks;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import larvae.smooks.model.Aaa;

import org.milyn.Smooks;
import org.milyn.payload.JavaResult;

public class XmlToJava {

    public Aaa transform(String inputXml) throws Exception {
        Smooks smooks = new Smooks("smooks/xml-to-java.xml");
        try {
            Source source = new StreamSource(ClassLoader.getSystemResourceAsStream(inputXml));
            JavaResult result = new JavaResult();
            smooks.filterSource(source, result);
            return (Aaa) result.getBean("aaa");
        } finally {
            smooks.close();
        }
    }

}
