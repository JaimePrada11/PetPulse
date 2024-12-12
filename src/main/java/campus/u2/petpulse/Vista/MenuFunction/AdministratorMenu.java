/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Controlador.Users.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class AdministratorMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menuAdministrator() {
        while (true) {
            System.out.println("\n---- Administrator Menu ----");
            System.out.println("1. Manage Orders");
            System.out.println("2. Back to General Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    manageOrders();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageOrders() {
        while (true) {
            System.out.println("\n---- Manage Orders ----");
            System.out.println("1. Create Purshase");
            System.out.println("1. Create Order");
            System.out.println("2. List Orders");
            System.out.println("3. Search Order by ID");
            System.out.println("4. Update Order");
            System.out.println("5. Delete Order");
            System.out.println("0. Back to Administrator Menu");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

//            switch (option) {
//                case 1:
//                    createPurshase();
//                    break;
//                case 2:
//                    createOrder();
//                    break;
//                case 3:
//                    listOrders();
//                    break;
//                case 4:
//                    searchOrderById();
//                    break;
//                case 5:
//                    updateOrder();
//                    break;
//                case 6:
//                    deleteOrder();
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
    }

//    public static void createPurshase() {
//        System.out.println("\n---- Create Purchase ----");
//        System.out.print("Enter Supplier ID: ");
//        int supplierId = scanner.nextInt();
//        System.out.print("Enter Purchase Date (YYYY-MM-DD): ");
//        String dateStr = scanner.next();
//        LocalDate date = LocalDate.parse(dateStr);
//        scanner.nextLine();
//        boolean result = PurchasesControlador.insertPurchase(date, supplierId);
//        if (result) {
//            System.out.println("Purchase created successfully.");
//            System.out.print("Do you want to add items to this purchase? (yes/no): ");
//            String addItems = scanner.nextLine();
//            if (addItems.equalsIgnoreCase("yes")) {
//                while (true) {
//                    for(int i = 0 ; ProductController. )
//                    System.out.print("Enter Product ID: ");
//                    int productId = scanner.nextInt();
//                    System.out.print("Enter Quantity: ");
//                    int quantity = scanner.nextInt();
//                   
//                    boolean itemResult = PurchaseDetailsControlador.insertPurchaseDetail(productId, supplierId, quantity, 0.0);
//                    if (itemResult) {
//                        System.out.println("Item added to purchase.");
//                    } else {
//                        System.out.println("Error adding item to purchase.");
//                    }
//                    System.out.print("Do you want to add another item? (yes/no): ");
//                    String anotherItem = scanner.nextLine();
//                    if (!anotherItem.equalsIgnoreCase("yes")) {
//                        break;
//                    }
//                }
//            }
//        } else {
//            System.out.println("Error creating the purchase.");
//        }
//    }
//
//    public static void createOrder() {
//        System.out.println("\n---- Create Order ----");
//        System.out.print("Product ID: ");
//        int productId = scanner.nextInt();
//        System.out.print("Purchase ID: ");
//        int purchaseId = scanner.nextInt();
//        System.out.print("Quantity: ");
//        int quantity = scanner.nextInt();
//        System.out.print("Subtotal: ");
//        double subtotal = scanner.nextDouble();
//        scanner.nextLine();
//
//        boolean result = PurchaseDetailsControlador.insertPurchaseDetail(productId, purchaseId, quantity, subtotal);
//        if (result) {
//            System.out.println("Order created successfully.");
//        } else {
//            System.out.println("Error creating the order.");
//        }
//    }
//
//    public static void listOrders() {
//        try {
//            List<PurchaseDetails> orders = PurchaseDetailsControlador.listPurchaseDetails();
//            if (orders.isEmpty()) {
//                System.out.println("No orders found.");
//            } else {
//                for (PurchaseDetails order : orders) {
//                    System.out.println(order);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error listing orders: " + e.getMessage());
//        }
//    }
//
//    public static void searchOrderById() {
//        try {
//            System.out.print("Enter Purchase ID: ");
//            int purchaseId = scanner.nextInt();
//            scanner.nextLine();
//            List<PurchaseDetails> orders = PurchaseDetailsControlador.getPurchaseDetailsByPurchaseId(purchaseId);
//            if (orders.isEmpty()) {
//                System.out.println("No orders found for the given ID.");
//            } else {
//                for (PurchaseDetails order : orders) {
//                    System.out.println(order);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error searching order by ID: " + e.getMessage());
//        }
//    }
//
//    public static void updateOrder() {
//        System.out.println("\n---- Update Order ----");
//        System.out.print("Product ID: ");
//        int productId = scanner.nextInt();
//        System.out.print("Purchase ID: ");
//        int purchaseId = scanner.nextInt();
//        System.out.print("New Quantity: ");
//        int quantity = scanner.nextInt();
//        System.out.print("New Subtotal: ");
//        double subtotal = scanner.nextDouble();
//        scanner.nextLine();
//
//        boolean result = PurchaseDetailsControlador.updatePurchaseDetail(productId, purchaseId, quantity, subtotal);
//        if (result) {
//            System.out.println("Order updated successfully.");
//        } else {
//            System.out.println("Error updating the order.");
//        }
//    }
//
//    public static void deleteOrder() {
//        System.out.println("\n---- Delete Order ----");
//        System.out.print("Product ID: ");
//        int productId = scanner.nextInt();
//        System.out.print("Purchase ID: ");
//        int purchaseId = scanner.nextInt();
//        scanner.nextLine();
//
//        boolean result = PurchaseDetailsControlador.deletePurchaseDetail(productId, purchaseId);
//        if (result) {
//            System.out.println("Order deleted successfully.");
//        } else {
//            System.out.println("Error deleting the order.");
//        }
//    }
}
