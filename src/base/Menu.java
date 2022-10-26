package base;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Employee;

public class Menu {
  private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  Scanner input = new Scanner(System.in);

  public void printMenu() {
    System.out.println("============================================================");
    System.out.println("1. Listar Funcionários");
    System.out.println("2. Adicionar Funcionário");
    System.out.println("3. Deletar Funcinário");
    System.out.println("4. List Employee");
    System.out.println("0. Exit");
    System.out.println("============================================================");
  }

  public Employee newEmployee() {
    System.out.print("Digite o nome: ");
    String nameInput = input.next().trim();
    String name = nameInput.substring(0, 1).toUpperCase() + nameInput.substring(1);

    System.out.print("Digite o aniversário(dd/MM/yyyy): ");
    LocalDate birthDate = LocalDate.parse(input.next().trim(), fmt);

    System.out.print("Digite o salário: ");
    double salary = input.nextDouble();

    System.out.print("Digite a ocupação: ");
    String occupation = input.next().trim();

    return new Employee(name, birthDate, BigDecimal.valueOf(salary), occupation);
  }

  public void menuChoice(Integer choise, EmployeeList employees) {
    switch (choise) {
      case 1:
        employees.printEmployees();
        break;
      case 2:
        System.out.println("Usuário Criado");
        employees.addEmploy(newEmployee());
        break;
      case 3:
        System.out.print("Digite o nome do usuário: ");
        String name = input.next().trim();
        employees.removeEmploy(name);
        break;
      default:
        break;
    }
  }
}
