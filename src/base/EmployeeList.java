package base;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import entities.Employee;

public class EmployeeList {
  private List<Employee> employeesList = new ArrayList<>(Arrays.asList(
      new Employee("Maria", LocalDate.parse("2000-10-18"), BigDecimal.valueOf(2099.44), "Operador"),
      new Employee("João", LocalDate.parse("1990-05-12"), BigDecimal.valueOf(2284.38), "Operador"),
      new Employee("Caio", LocalDate.parse("1961-05-02"), BigDecimal.valueOf(9836.14), "Coordenador"),
      new Employee("Miguel", LocalDate.parse("1988-10-14"), BigDecimal.valueOf(19119.88), "Diretor"),
      new Employee("Alice", LocalDate.parse("1995-01-05"), BigDecimal.valueOf(2234.68), "Recepcionista"),
      new Employee("Heitor", LocalDate.parse("1999-11-19"), BigDecimal.valueOf(1582.72), "Operador"),
      new Employee("Arthur", LocalDate.parse("1993-03-31"), BigDecimal.valueOf(4071.84), "Contador"),
      new Employee("Laura", LocalDate.parse("1994-07-08"), BigDecimal.valueOf(3017.45), "Gerente"),
      new Employee("Heloísa", LocalDate.parse("2003-05-24"), BigDecimal.valueOf(1605.85), "Eletricista"),
      new Employee("Helena", LocalDate.parse("1999-09-02"), BigDecimal.valueOf(2799.93), "Gerente")));

  public void addEmploy(Employee employee) {
    employeesList.add(employee);
  }

  public void removeEmploy(Employee employee) {
    employeesList.remove(employee);
  }

  public void printEmployees() {
    Locale localUSD = new Locale("pt", "BR");
    NumberFormat formatNumber = NumberFormat.getInstance(localUSD);
    System.out.println("-----------------------------------------------------------------------------");
    System.out.printf("%10s\t %15s\t %10s\t %15s", "Nome", "Data de Nascimento", "Salário", "Função");
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------");
    for (Employee employee : employeesList) {
      System.out.format("%10s\t %15s\t %10s\t %15s",
          employee.getName(), employee.getBirthDate(), formatNumber.format(employee.getSalary()),
          employee.getOccupation());
      System.out.println();
    }
    System.out.println("-----------------------------------------------------------------------------");
  }
}
