package larvae.jaxb.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IntegerToXSStringAdapter extends XmlAdapter<String, Integer> {

  @Override
  public String marshal(Integer i) throws Exception {
    return i.toString();
  }

  @Override
  public Integer unmarshal(String s) throws Exception {
    return Integer.valueOf(s);
  }

}
