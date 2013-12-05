package larvae.smooks;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import larvae.smooks.model.Aaa;
import larvae.smooks.model.Type;

import org.junit.Test;

public class XmlToJavaTest {

    private static final String INPUT = "input-xml-to-java.xml";

    @Test
    public void transform() throws Exception {
        Aaa result = new XmlToJava().transform(INPUT);
        System.out.println(result);

        assertThat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(result.getBbb().getDate()),
                is(equalTo("2013/12/01 12:00:00")));
        assertThat(result.getBbb().getCcc().getType(), is(equalTo(Type.X)));
        assertThat(result.getBbb().getCcc().getValue(), is(equalTo("XXXXX")));
    }

}
