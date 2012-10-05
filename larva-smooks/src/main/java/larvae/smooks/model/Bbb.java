package larvae.smooks.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Bbb {
  private Ccc ccc;
  public Ccc getCcc() {
    return ccc;
  }
  public void setCcc(Ccc ccc) {
    this.ccc = ccc;
  }
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}
