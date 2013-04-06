package larvae.jaxb.pojo.model;

public class Person {

  private Name        name;
  private int         age;
  private Nationality nationality;

  public Person() {}

  public Person(Name name, int age, Nationality nationality) {
    this.name = name;
    this.age = age;
    this.nationality = nationality;
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Nationality getNationality() {
    return nationality;
  }

  public void setNationality(Nationality nationality) {
    this.nationality = nationality;
  }

}
