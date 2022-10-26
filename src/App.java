import java.util.Scanner;

import base.EmployeeList;
import base.Menu;

public class App {
    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        EmployeeList employees = new EmployeeList();

        while (true) {
            menu.printMenu();
            System.out.print("Escolha uma opção: ");
            int choise = Integer.parseInt(sc.next());

            if (choise == 0) {
                sc.close();
                break;
            }
            menu.menuChoice(choise, employees);
            System.out.println("Deseja Continuar?");
            System.out.print("[0] Sair; Se Deseja continuar, digite qualquer valor: ");

            int response = Integer.parseInt(sc.next());

            if (response == 0)
                break;

        }
        sc.close();
    }

}
