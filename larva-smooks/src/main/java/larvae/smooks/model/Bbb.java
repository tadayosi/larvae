package larvae.smooks.model;

import java.util.Date;

import lombok.Data;

import com.google.common.base.Objects;

@Data
public class Bbb {
    private Date date;
    private Ccc ccc;

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("date", date).add("ccc", ccc).toString();
    }
}
