package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {
  private BigDecimal salary;
  private String occupation;

  public Employee(String name, LocalDate birthDate, BigDecimal salary, String occupation) {
    super(name, birthDate);
    this.salary = salary;
    this.occupation = occupation;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public void increaseSalary(Double increase) {
    double increaseValue = increase / 100;
    this.salary = this.salary.add(this.salary.multiply(BigDecimal.valueOf(increaseValue)));
  }

}
