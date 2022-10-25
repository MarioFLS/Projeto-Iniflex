package base;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
      new Employee("Helena", LocalDate.parse("02/09/1996", fmt), BigDecimal.valueOf(2799.93), "Gerente"),
      new Employee("Vanessa", LocalDate.parse("10/12/2008", fmt), BigDecimal.valueOf(2799.93), "Coordenador"),
      new Employee("Mario", LocalDate.parse("18/04/2002", fmt), BigDecimal.valueOf(4000.00), "Desenvolvedor Java")));

  public void addEmploy(Employee employee) {
    employeesList.add(employee);
  }

  public void removeEmploy(String name) {
    employeesList.removeIf(employee -> Objects.equals(employee.getName().toLowerCase(), name.toLowerCase()));
  }

  public void salaryIncrease(Double increase) {
    for (Employee employee : employeesList) {
      employee.increaseSalary(increase);
    }
  }

  public void printEmployees() {
    Locale localUSD = new Locale("pt", "BR");
    NumberFormat formatNumber = NumberFormat.getInstance(localUSD);
    System.out.println("-----------------------------------------------------------------------------");
    System.out.printf("%10s\t %15s\t %10s\t %15s", "Nome", "Data de Nascimento", "Salário", "Função");
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------");
    for (Employee employee : employeesList) {
      System.out.format("%10s\t %15s\t R$ %10s\t %15s",
          employee.getName(), employee.getBirthDate().format(fmt), formatNumber.format(employee.getSalary()),
          employee.getOccupation());
      System.out.println();
    }
    System.out.println("-----------------------------------------------------------------------------");
  }

  public void printOccupation() {
    Map<String, List<Employee>> occupation = new HashMap<>();
    for (Employee employee : employeesList) {
      occupation.put(employee.getOccupation(), employeesList.stream()
          .filter(e -> Objects.equals(e.getOccupation(), employee.getOccupation())).collect(Collectors.toList()));
    }

    for (Map.Entry<String, List<Employee>> employee : occupation.entrySet()) {
      System.out.print(employee.getKey() + ": ");
      employee.getValue().forEach(e -> System.out.print(e.getName() + ", "));
      System.out.println();
    }
  }

  public void printBirthday() {
    List<Employee> employees = employeesList.stream()
        .filter(e -> e.getBirthDate().getMonthValue() == 10 || e.getBirthDate().getMonthValue() == 12)
        .collect(Collectors.toList());

    for (Employee employee : employees) {
      System.out.println(employee.toString());
    }
  }

  public void printAdultEmployees() {
    Integer currentYear = LocalDate.now().getYear();
    List<Employee> employees = employeesList.stream()
        .filter(e -> (currentYear - e.getBirthDate().getYear()) >= 18)
        .collect(Collectors.toList());

    for (Employee employee : employees) {
      System.out
          .println("Nome: " + employee.getName() + ", Idade: " + (currentYear - employee.getBirthDate().getYear()));
    }
  }
}
