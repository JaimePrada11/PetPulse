/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Controlador.Users.*;
import campus.u2.petpulse.Clases.BillingProcess.*;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class SuppliersMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menuSuppliers() {
        
        try {
            while (true) {
            System.out.println("\n---- Suppliers Menu ----");
            System.out.println("1. Register Supplier");
            System.out.println("2. List Suppliers");
            System.out.println("3. Search Supplier by ID");
            System.out.println("4. Search Supplier by NIT");
            System.out.println("5. Update Supplier by NIT");
            System.out.println("6. Delete Supplier by ID");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerSupplier();
                    break;
                case 2:
                    listSuppliers();
                    break;
                case 3:
                    searchSupplierById();
                    break;
                case 4:
                    searchSupplierByNIT();
                    break;
                case 5:
                    updateSupplierByNIT();
                    break;
                case 6:
                    deleteSupplierById();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    public static void registerSupplier() {
        System.out.println("\n---- Register Supplier ----");
        System.out.print("Company Name: ");
        String companyName = scanner.nextLine();
        System.out.print("NIT: ");
        String nit = scanner.nextLine();
        System.out.print("Contact Name: ");
        String contactName = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        boolean result = SuppliersControlador.insertSupplier(companyName, nit, contactName, phoneNumber, email);
        if (result) {
            System.out.println("Supplier registered successfully.");
        } else {
            System.out.println("Error registering the supplier.");
        }
    }

    public static void listSuppliers() {
        try {
            List<Suppliers> suppliersList = SuppliersControlador.listSuppliers();
            if (suppliersList.isEmpty()) {
                System.out.println("No suppliers registered.");
            } else {
                for (Suppliers supplier : suppliersList) {
                    System.out.println(supplier);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error listing suppliers: " + e.getMessage());
        }
    }

    public static void searchSupplierById() {
        try {
            System.out.print("Enter Supplier ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Suppliers supplier = SuppliersControlador.getSupplierById(id);
            if (supplier != null) {
                System.out.println(supplier);
            } else {
                System.out.println("Supplier not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching supplier by ID: " + e.getMessage());
        }
    }

    public static void searchSupplierByNIT() {
        try {
            System.out.print("Enter Supplier NIT: ");
            String nit = scanner.nextLine();
            Suppliers supplier = SuppliersControlador.getSupplierByNIT(nit);
            if (supplier != null) {
                System.out.println(supplier);
            } else {
                System.out.println("Supplier not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching supplier by NIT: " + e.getMessage());
        }
    }

    public static void updateSupplierByNIT() {
        try {
            System.out.print("Enter Supplier NIT: ");
            String nit = scanner.nextLine();
            Suppliers supplier = SuppliersControlador.getSupplierByNIT(nit);
            if (supplier != null) {
                System.out.println("\nSelect attribute to update:");
                System.out.println("1. Company Name");
                System.out.println("2. Contact Name");
                System.out.println("3. Phone Number");
                System.out.println("4. Email");
                System.out.print("Option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("New Company Name: ");
                        String companyName = scanner.nextLine();
                        supplier.setCompany_Name(companyName);
                        break;
                    case 2:
                        System.out.print("New Contact Name: ");
                        String contactName = scanner.nextLine();
                        supplier.setContactName(contactName);
                        break;
                    case 3:
                        System.out.print("New Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        supplier.setPhone_Number(phoneNumber);
                        break;
                    case 4:
                        System.out.print("New Email: ");
                        String email = scanner.nextLine();
                        supplier.setEmail(email);
                        break;
                    default:
                        System.out.println("Invalid option.");
                        return;
                }

                boolean result = SuppliersControlador.updateSupplierByNIT(supplier.getNIT(), supplier.getCompany_Name(),
                        supplier.getContactName(), supplier.getPhone_Number(), supplier.getEmail());
                if (result) {
                    System.out.println("Supplier updated successfully.");
                } else {
                    System.out.println("Error updating the supplier.");
                }
            } else {
                System.out.println("Supplier not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating supplier: " + e.getMessage());
        }
    }

    public static void deleteSupplierById() {
        try {
            System.out.print("Enter Supplier ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            boolean result = SuppliersControlador.deleteSupplier(id);
            if (result) {
                System.out.println("Supplier deleted successfully.");
            } else {
                System.out.println("Error deleting the supplier.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting supplier: " + e.getMessage());
        }
    }

    public static boolean updateSupplierByNIT(String nit, String companyName, String contactName, String phoneNumber, String email) throws SQLException {
        String query = "UPDATE Suppliers SET Company_Name = ?, contactName = ?, Phone_Number = ?, Email = ? WHERE NIT = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, companyName, contactName, phoneNumber, email, nit);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de actualización: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }
}
