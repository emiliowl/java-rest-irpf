package fit.exemplo.models;

public class PersonVm {
  private String name = "Spring Post";
  private double salary;
  private int dependents;
  private int year;

  public PersonVm() {
    super();
  }

  public PersonVm(double salary, int dependents, int year) {
    super();
    this.salary = salary;
    this.dependents = dependents;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public int getDependents() {
    return dependents;
  }

  public void setDependents(int dependents) {
    this.dependents = dependents;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
