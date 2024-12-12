package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Controlador.Users.OwnerControlador;
import campus.u2.petpulse.Controlador.Users.PetControlador;
import static campus.u2.petpulse.Controlador.Users.PetControlador.getPetsByOwnerId;
import campus.u2.petpulse.Clases.Users.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuFunctions {

//////////////////////////////////////// OWNER MENU ///////////////////////////////////////////
    public static void mostrarMenuOwner() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            try {
                System.out.println("\n--- OWNER MENU ---");
                System.out.println("1. Register a new owner");
                System.out.println("2. Update an owner's information");
                System.out.println("3. List all owners");
                System.out.println("4. Find owner by ID");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        OwnerControlador.registerOwnermenu();
                        break;
                    case 2:
                        updateOwner();
                        break;
                    case 3:
                        listOwners();
                        break;
                    case 4:
                        OwnerControlador.lookForOwner();
                        break;
                    case 0:
                        System.out.println("Exiting the system...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please enter a valid option.");
                scanner.nextLine();
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////
    public static void listOwners() {
        System.out.println("Listing all owners...");

        try {
            List<Owner> lista = OwnerControlador.listOwners();
            for (Owner i : lista) {
                System.out.println(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ////////////////OWNER SUB MENU UPDATE ???//////////////////////
    public static void updateOwner() {
        Scanner scanner = new Scanner(System.in);
        String opcion = null;

        System.out.println("Updating an owner's information...");
        System.out.print("Enter the Owner's ID_Card to update: ");
        Integer ownerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        do {
            System.out.println("\n--- UPDATE MENU ---");
            System.out.println("1. Update Name");
            System.out.println("2. Update Phone Number");
            System.out.println("3. Update Address");
            System.out.println("4. Update Email");

            System.out.println("5. Update Subscription ID");

            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            opcion = scanner.nextLine();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case "1" ->
                    OwnerControlador.updateName(ownerId);
                case "2" ->
                    OwnerControlador.updatePhoneNumber(ownerId);
                case "3" ->
                    OwnerControlador.updateAddress(ownerId);
                case "4" ->
                    OwnerControlador.updateEmail(ownerId);
                case "5" ->
                    OwnerControlador.updateSubscriptionId(ownerId);

                case "0" ->
                    System.out.println("Exiting update menu...");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!"0".equals(opcion));
    }

}
