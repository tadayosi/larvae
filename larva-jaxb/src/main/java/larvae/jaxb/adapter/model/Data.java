package larvae.jaxb.adapter.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import larvae.jaxb.adapter.IntegerToXSStringAdapter;
import larvae.jaxb.adapter.StringToXSIntAdapter;

@XmlRootElement
public class Data {

    private Integer i;
    private String s;

    public Data() {}

    public Data(Integer i, String s) {
        this.i = i;
        this.s = s;
    }

    @XmlJavaTypeAdapter(IntegerToXSStringAdapter.class)
    public Integer getI() {
        return i;
    }

    public void setI(Integer value) {
        this.i = value;
    }

    @XmlJavaTypeAdapter(StringToXSIntAdapter.class)
    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

}
