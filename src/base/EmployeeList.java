package base;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import entities.Employee;

public class EmployeeList {
  private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private List<Employee> employeesList = new ArrayList<>(Arrays.asList(
      new Employee("Maria", LocalDate.parse("18/10/2000", fmt), BigDecimal.valueOf(2099.44), "Operador"),
      new Employee("João", LocalDate.parse("12/05/1990", fmt), BigDecimal.valueOf(2284.38), "Operador"),
      new Employee("Caio", LocalDate.parse("02/05/1961", fmt), BigDecimal.valueOf(9836.14), "Coordenador"),
      new Employee("Miguel", LocalDate.parse("14/10/1988", fmt), BigDecimal.valueOf(19119.88), "Diretor"),
      new Employee("Alice", LocalDate.parse("05/01/1995", fmt), BigDecimal.valueOf(2234.68), "Recepcionista"),
      new Employee("Heitor", LocalDate.parse("19/11/1999", fmt), BigDecimal.valueOf(1582.72), "Operador"),
      new Employee("Arthur", LocalDate.parse("31/03/1993", fmt), BigDecimal.valueOf(4071.84), "Contador"),
      new Employee("Laura", LocalDate.parse("08/07/1994", fmt), BigDecimal.valueOf(3017.45), "Gerente"),
      new Employee("Heloísa", LocalDate.parse("24/05/2003", fmt), BigDecimal.valueOf(1605.85), "Eletricista"),
      new Employee("Helena", LocalDate.parse("02/09/1996", fmt), BigDecimal.valueOf(2799.93), "Gerente")));

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
          employee.getName(), employee.getBirthDate().format(fmt), formatNumber.format(employee.getSalary()),
          employee.getOccupation());
      System.out.println();
    }
    System.out.println("-----------------------------------------------------------------------------");
  }
}
