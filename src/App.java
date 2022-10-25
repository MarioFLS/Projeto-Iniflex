import base.EmployeeList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        EmployeeList b = new EmployeeList();

        b.printEmployees();

        System.out.println("Removendo João");

        b.removeEmploy("João");

        System.out.println("Aumentando Salário em 10%");

        b.salaryIncrease(10.0);

        System.out.println();

        b.printEmployees();
    }
}
