package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Controlador.Users.Emergency_ContactsControlator;
import campus.u2.petpulse.Clases.Users.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuEmergencyContact {

    public static void MenuEmergency() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== Emergency Contacts Menu ===");
            System.out.println("1. Register Emergency Contact");
            System.out.println("2. Get Emergency Contact by ID");
            System.out.println("3. Get Emergency Contact by ID Card");
            System.out.println("4. List All Emergency Contacts");
            System.out.println("5. Update Emergency Contact");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerEmergencyContact(scanner);
                    break;
                case 2:
                    getEmergencyContactById(scanner);
                    break;
                case 3:
                    getEmergencyContactByIdCard(scanner);
                    break;
                case 4:
                    listAllEmergencyContacts();
                    break;
                case 5:
                    updateEmergencyContact(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 6);
    }

    private static void registerEmergencyContact(Scanner scanner) {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter ID Card: ");
            String idCard = scanner.nextLine();

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            boolean result = Emergency_ContactsControlator.registrar(name, phoneNumber, idCard, address, email);
            if (result) {
                System.out.println("Emergency Contact registered successfully.");
            } else {
                System.out.println("Failed to register Emergency Contact.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getEmergencyContactById(Scanner scanner) {
        try {
            System.out.print("Enter Emergency Contact ID: ");
            int id = scanner.nextInt();
            EmergencyContacts contact = Emergency_ContactsControlator.obtenerEmergencyContact(id);
            if (contact != null) {
                System.out.println(contact);
            } else {
                System.out.println("Emergency Contact not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getEmergencyContactByIdCard(Scanner scanner) {
        try {
            System.out.print("Enter Emergency Contact ID Card: ");
            String idCard = scanner.nextLine();
            List<EmergencyContacts> contacts = Emergency_ContactsControlator.listarEmergencyContacts();
            boolean found = false;
            for (EmergencyContacts contact : contacts) {
                if (contact.getId_Card().equals(idCard)) {
                    System.out.println(contact);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Emergency Contact with the given ID Card not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listAllEmergencyContacts() {
        try {
            List<EmergencyContacts> contacts = Emergency_ContactsControlator.listarEmergencyContacts();
            if (!contacts.isEmpty()) {
                for (EmergencyContacts contact : contacts) {
                    System.out.println(contact);
                }
            } else {
                System.out.println("No Emergency Contacts found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateEmergencyContact(Scanner scanner) {
        try {
            System.out.print("Enter Emergency Contact ID Card to update: ");
            String idCard = scanner.nextLine();

            EmergencyContacts contactToUpdate = null;
            List<EmergencyContacts> contacts = Emergency_ContactsControlator.listarEmergencyContacts();
            for (EmergencyContacts contact : contacts) {
                if (contact.getId_Card().equals(idCard)) {
                    contactToUpdate = contact;
                    break;
                }
            }

            if (contactToUpdate == null) {
                System.out.println("Emergency Contact with the given ID Card not found.");
                return;
            }

            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter New Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter New ID Card: ");
            String newIdCard = scanner.nextLine();

            System.out.print("Enter New Address: ");
            String address = scanner.nextLine();

            System.out.print("Enter New Email: ");
            String email = scanner.nextLine();

            boolean result = Emergency_ContactsControlator.actualizarAguacate(name, phoneNumber, newIdCard, address, email, contactToUpdate.getId());
            if (result) {
                System.out.println("Emergency Contact updated successfully.");
            } else {
                System.out.println("Failed to update Emergency Contact.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
