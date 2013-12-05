package larvae.smooks.model;

import lombok.Data;

import com.google.common.base.Objects;

@Data
public class Ccc {
    private Type type;
    private String value;

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("type", type).add("value", value).toString();
    }
}
