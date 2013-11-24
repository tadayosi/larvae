package larvae.jaxb.pojo.model;

import lombok.Data;

@Data
public class Person {

    private Name name;
    private int age;
    private Nationality nationality;

    public Person() {}

    public Person(Name name, int age, Nationality nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

}
