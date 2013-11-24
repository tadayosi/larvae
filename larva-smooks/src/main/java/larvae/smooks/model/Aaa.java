package larvae.smooks.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Aaa {
    private Bbb bbb;
    public Bbb getBbb() {
        return bbb;
    }
    public void setBbb(Bbb bbb) {
        this.bbb = bbb;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
