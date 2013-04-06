package larvae.jaxb.pojo.model;

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

  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getMiddle() {
    return middle;
  }

  public void setMiddle(String middle) {
    this.middle = middle;
  }

}
