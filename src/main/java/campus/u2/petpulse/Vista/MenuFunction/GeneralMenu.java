/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Vista.MenuFunction;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class GeneralMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---- General Veterinary Clinic Menu ----");
            System.out.println("1. Administrator");
            System.out.println("2. Employee");
            System.out.println("3. Pet Owner");
            System.out.println("4. Exit");
            System.out.print("Select your role: ");

            int role = scanner.nextInt();
            scanner.nextLine();

            switch (role) {
                case 1:
                    AdministratorMenu.menuAdministrator();
                    break;
                case 2:
                   // EmployeeMenu.menuEmployee();
                    break;
                case 3:
                  //  PetOwnerMenu.menuPetOwner();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
