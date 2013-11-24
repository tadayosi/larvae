package larvae.jaxb.pojo.model;

import lombok.Data;

@Data
public class Name {

    private String family;
    private String first;
    private String middle;

    public Name() {}

    public Name(String family, String first, String middle) {
        this.family = family;
        this.first = first;
        this.middle = middle;
    }

}
