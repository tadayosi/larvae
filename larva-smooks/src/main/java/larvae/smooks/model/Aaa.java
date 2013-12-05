package larvae.smooks.model;

import lombok.Data;

import com.google.common.base.Objects;

@Data
public class Aaa {
    private Bbb bbb;

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("bbb", bbb).toString();
    }
}
