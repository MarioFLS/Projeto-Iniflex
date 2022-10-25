import base.EmployeeList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        EmployeeList employees = new EmployeeList();

        employees.printEmployees();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Removendo João");
        System.out.println();

        employees.removeEmploy("João");

        employees.printEmployees();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Aumentando Salário em 10%");
        System.out.println();

        employees.salaryIncrease(10.0);

        employees.printEmployees();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Função de cada funciário");
        System.out.println();
        employees.printOccupation();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Funcionarios Aniversáriantes do mês de Outubro (10) e de Dezembro(12)");
        System.out.println();

        employees.printBirthday();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Funcionarios Acima dos 18 anos");
        System.out.println();
        employees.printAdultEmployees();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Funcionarios por Ordem Alfabética");
        System.out.println();
        employees.printAlphabeticalOrder();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Soma dos salários; Lembrando que eles foram aumentando em 10%");
        System.out.println();
        employees.sumOfSalaries();

        System.out.println("=============================================================================");
        System.out.println();

        System.out.println("Quantos salários mínimos cada funcionário ganha; Sendo o salário Minimo R$1212.00");
        System.out.println();
        employees.minimumSalaries();
    }
}
