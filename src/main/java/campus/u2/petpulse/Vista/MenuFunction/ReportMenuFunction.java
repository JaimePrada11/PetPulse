/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Vista.MenuFunction;

import static campus.u2.petpulse.Vista.MenuFunction.ServiceMenuFunction.addProducts;
import static campus.u2.petpulse.Vista.MenuFunction.ServiceMenuFunction.listServicesBelowPrice;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class ReportMenuFunction {
    public static void showMenu() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            System.out.println("\n--- Services Menu ---");
            System.out.println("1. Register a new service");
            System.out.println("2. Update service information");
            System.out.println("3. Delete a service");
            System.out.println("4. List all available services");
            System.out.println("5. add Producst in service");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 ->
                    registerService();
                case 2 ->
                    updateService();
                case 3 ->
                    deleteService();
                case 4 ->
                    listServicesBelowPrice();
                case 5 ->
                    addProducts();
                case 0 ->
                    System.out.println("Exiting the system...");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    private static void registerService() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void updateService() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void deleteService() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
