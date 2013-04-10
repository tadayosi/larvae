package larvae.jaxb.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringToXSIntAdapter extends XmlAdapter<Integer, String> {

  @Override
  public Integer marshal(String s) throws Exception {
    return Integer.valueOf(s);
  }

  @Override
  public String unmarshal(Integer i) throws Exception {
    return i.toString();
  }

}
