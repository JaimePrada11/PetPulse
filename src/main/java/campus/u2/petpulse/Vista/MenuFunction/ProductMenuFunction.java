
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Controlador.ProductsControlleres.ProductController;
import campus.u2.petpulse.Controlador.ServicesControlleres.ServiceController;
import static campus.u2.petpulse.Vista.MenuFunction.ServiceMenuFunction.addProducts;
import static campus.u2.petpulse.Vista.MenuFunction.ServiceMenuFunction.listServices;
import campus.u2.petpulse.Clases.Products.*;
import campus.u2.petpulse.Controlador.ProductsControlleres.AccesoryController;
import campus.u2.petpulse.Controlador.ProductsControlleres.AccesoryTypeController;
import campus.u2.petpulse.Controlador.ProductsControlleres.AdministrationMethodController;
import campus.u2.petpulse.Controlador.ProductsControlleres.FoodController;
import campus.u2.petpulse.Controlador.ProductsControlleres.MaterialTypeController;
import campus.u2.petpulse.Controlador.ProductsControlleres.MedicalMaterialsControllers;
import campus.u2.petpulse.Controlador.ProductsControlleres.MedicineController;
import campus.u2.petpulse.Controlador.ProductsControlleres.MedicineTypeController;
import campus.u2.petpulse.Controlador.ProductsControlleres.ProductTypeController;
import campus.u2.petpulse.Controlador.ProductsControlleres.VaccineController;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ProductMenuFunction {

    public static void showMenu() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            System.out.println("\n--- Product Menu ---");
            System.out.println("1. Register a new product");
            System.out.println("2. Update product information");
            System.out.println("3. Delete a product");
            System.out.println("4. List all available products");
            System.out.println("5. add suplier in products");
            System.out.println("6. show products close to dueDate");
            System.out.println("7. Change stock in products");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 ->
                    registerProduct();
                case 2 ->
                    updateProduct();
                case 3 ->
                    deleteProduct();
                case 4 ->
                    listProduct();
                case 5 ->
                    addSuplier();
                case 6 ->
                    duedateproduct();
                case 7 ->
                    updateproduct();
                case 0 ->
                    System.out.println("Exiting the system...");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    private static void registerProduct() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTER NEW PRODUCT ---");

        // Obtener el nombre del producto
        System.out.print("Enter the name of the product: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Product name cannot be empty. Please enter a valid name: ");
            name = scanner.nextLine().trim();
        }

        // Obtener el SKU del producto
        System.out.print("Enter a SKU of the product: ");
        String sku = scanner.nextLine().trim();
        while (sku.isEmpty()) {
            System.out.print("SKU cannot be empty. Please enter a valid SKU: ");
            sku = scanner.nextLine().trim();
        }

        // Obtener el lote del producto
        System.out.print("Enter the batch of the product: ");
        String batch = scanner.nextLine().trim();
        while (batch.isEmpty()) {
            System.out.print("Batch cannot be empty. Please enter a valid batch: ");
            batch = scanner.nextLine().trim();
        }

        // Obtener el fabricante del producto
        System.out.print("Enter the manufacturer of the product: ");
        String manufacturer = scanner.nextLine().trim();
        while (manufacturer.isEmpty()) {
            System.out.print("Manufacturer cannot be empty. Please enter a valid manufacturer: ");
            manufacturer = scanner.nextLine().trim();
        }

        LocalDate entryDate = null;
        boolean validEntryDate = false;
        while (!validEntryDate) {
            System.out.print("Enter the entry date (YYYY-MM-DD) of the product: ");
            String dateInput = scanner.nextLine().trim();
            try {
                entryDate = LocalDate.parse(dateInput);
                validEntryDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date (YYYY-MM-DD).");
            }
        }

        LocalDate dueDate = null;
        boolean validDueDate = false;
        while (!validDueDate) {
            System.out.print("Enter the due date (YYYY-MM-DD) of the product: ");
            String dateInput = scanner.nextLine().trim();
            try {
                dueDate = LocalDate.parse(dateInput);
                if (dueDate.isAfter(entryDate)) {
                    validDueDate = true;
                } else {
                    System.out.println("Due date must be after entry date. Please enter a valid due date.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter a valid date (YYYY-MM-DD).");
            }
        }

        int stock = 0;
        boolean validStock = false;
        while (!validStock) {
            System.out.print("Enter the stock amount of the product: ");
            if (scanner.hasNextInt()) {
                stock = scanner.nextInt();
                if (stock >= 0) {
                    validStock = true;
                } else {
                    System.out.println("Stock must be a non-negative integer. Please enter again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the stock.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Enter the price of the product: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price > 0) {
                    validPrice = true;
                } else {
                    System.out.println("Price must be a positive number. Please enter again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for the price.");
                scanner.nextLine();
            }
        }

        int productType = showproductsTypes();

        ProductType s = ProductTypeController.getProductType(productType);

        scanner.nextLine();

        boolean result = ProductController.registerProduct(sku, name, batch, manufacturer, entryDate, dueDate, stock, price, s);

        if (result) {

            switch (productType) {
                case 1:
                    createMedicines();
                    break;
                case 2:
                    createVaccines();
                    break;
                case 3:
                    createMedicalSupplier();
                    break;
                case 4:
                    createAccesories();
                    break;
                case 5:
                    createFood();
                    break;
                case 0:
                    System.out.println("Exiting update menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println("Product registered successfully.");
        } else {
            System.out.println("Failed to register the product. Please try again.");
        }
    }

    private static int showMedicinesTypes() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        List<MedicineType> medicineTypes = MedicineTypeController.listMedicineType();

        System.out.println("\n--- SELECT MEDICINE TYPE ---");
        for (int i = 0; i < medicineTypes.size(); i++) {
            System.out.println((i + 1) + ". " + medicineTypes.get(i).getName());
        }

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Enter the number corresponding to the desired medicine type: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= medicineTypes.size()) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        return medicineTypes.get(choice - 1).getIdMedicineType();
    }

    private static int showproductsTypes() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        List<ProductType> productTypes = ProductTypeController.listProductTypes();

        System.out.println("\n--- SELECT PRODUCT TYPE ---");
        for (int i = 0; i < productTypes.size(); i++) {
            System.out.println((i + 1) + ". " + productTypes.get(i).getName());
        }

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Enter the number corresponding to the desired product type: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= productTypes.size()) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        return productTypes.get(choice - 1).getIdProductType();
    }

    private static void updateProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void listProduct() {
        System.out.println("Listing all services...");

        try {
            List<Product> lista = ProductController.listProducts();
            lista.stream()
                    .forEach(System.out::println);

        } catch (SQLException ex) {
            Logger.getLogger(ProductMenuFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addSuplier() {
    }

    private static void duedateproduct() {

    }

    private static void updateproduct() {
    }

    private static void createMedicines() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTER NEW MEDICINE ---");

        System.out.print("Enter the dosage of the medicine: ");
        int dosage = scanner.nextInt();
        while (dosage <= 0) {
            System.out.print("Dosage must be a positive integer. Please enter again: ");
            dosage = scanner.nextInt();
        }

        System.out.print("Is a prescription required (true/false)? ");
        boolean prescriptionRequired = scanner.nextBoolean();
        while (!prescriptionRequired && prescriptionRequired) {
            System.out.print("Invalid input. Please enter true or false: ");
            prescriptionRequired = scanner.nextBoolean();
        }

        scanner.nextLine();

        System.out.print("Enter the unit of measure (e.g., mg, ml): ");
        String unitofMeasure = scanner.nextLine().trim();
        while (unitofMeasure.isEmpty()) {
            System.out.print("Unit of measure cannot be empty. Please enter again: ");
            unitofMeasure = scanner.nextLine().trim();
        }

        System.out.print("Enter the quantity per package: ");
        int quantityPerPackage = scanner.nextInt();
        while (quantityPerPackage <= 0) {
            System.out.print("Quantity per package must be a positive integer. Please enter again: ");
            quantityPerPackage = scanner.nextInt();
        }

        scanner.nextLine();
        System.out.print("Enter the dose interval (e.g., daily, every 12 hours): ");
        String doseInterval = scanner.nextLine().trim();
        while (doseInterval.isEmpty()) {
            System.out.print("Dose interval cannot be empty. Please enter again: ");
            doseInterval = scanner.nextLine().trim();
        }

        int medicineType = showMedicinesTypes();
        MedicineType mt = MedicineTypeController.getMedicineType(medicineType);

        int id = ProductController.getLastProductID();

        boolean result = MedicineController.registerMedicine(id, dosage, prescriptionRequired, unitofMeasure, quantityPerPackage, doseInterval, mt);

        if (result) {
            System.out.println("Medicine registered successfully.");
        } else {
            System.out.println("Failed to register the medicine. Please try again.");
        }
    }

    private static void createVaccines() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTER NEW VACCINE ---");

        Double storageTemperature;
        while (true) {
            System.out.print("Enter the storage temperature (in Celsius): ");
            if (scanner.hasNextDouble()) {
                storageTemperature = scanner.nextDouble();
                if (storageTemperature >= -80 && storageTemperature <= 50) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Storage temperature must be between -80°C and 50°C. Please enter again.");
        }

        // Input for number of doses
        int numberOfDoses;
        while (true) {
            System.out.print("Enter the number of doses required: ");
            if (scanner.hasNextInt()) {
                numberOfDoses = scanner.nextInt();
                if (numberOfDoses > 0) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Number of doses must be a positive integer. Please enter again.");
        }

        int period;
        while (true) {
            System.out.print("Enter the period between doses (in days): ");
            if (scanner.hasNextInt()) {
                period = scanner.nextInt();
                if (period > 0) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Period between doses must be a positive integer. Please enter again.");
        }

        System.out.println("Select an administration method:");
        List<AdministrationMethod> methods = AdministrationMethodController.listAdministrationMethod();

        if (methods.isEmpty()) {
            System.out.println("No administration methods available. Please register one before proceeding.");
            return;
        }

        for (int i = 0; i < methods.size(); i++) {
            System.out.println((i + 1) + ". " + methods.get(i).getName());
        }

        AdministrationMethod a;
        while (true) {
            System.out.print("Enter the number corresponding to the administration method: ");
            if (scanner.hasNextInt()) {
                int methodChoice = scanner.nextInt();
                if (methodChoice >= 1 && methodChoice <= methods.size()) {
                    a = AdministrationMethodController.getAdministrationMethod(methodChoice);
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid choice. Please select a valid method.");
        }

        int productID = ProductController.getLastProductID();

        boolean result = VaccineController.registerVaccine(productID, storageTemperature, a, numberOfDoses, period);

        if (result) {
            System.out.println("Vaccine registered successfully.");
        } else {
            System.out.println("Failed to register the vaccine. Please try again.");
        }
    }

    private static void createMedicalSupplier() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTER NEW MEDICAL MATERIAL ---");

        // Input for size
        int size;
        while (true) {
            System.out.print("Enter the size of the medical material: ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size > 0) {
                    break;
                }
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Size must be a positive integer. Please enter again.");
        }

        System.out.println("Select a material type:");
        List<MaterialType> materialTypes = MaterialTypeController.listMaterialTypes();

        if (materialTypes.isEmpty()) {
            System.out.println("No material types available. Please register one before proceeding.");
            return;
        }

        for (int i = 0; i < materialTypes.size(); i++) {
            System.out.println((i + 1) + ". " + materialTypes.get(i).getName());
        }

        MaterialType materialTypeID;
        while (true) {
            System.out.print("Enter the number corresponding to the material type: ");
            if (scanner.hasNextInt()) {
                int materialChoice = scanner.nextInt();
                if (materialChoice >= 1 && materialChoice <= materialTypes.size()) {
                    materialTypeID = MaterialTypeController.getMaterialType(materialChoice);
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid choice. Please select a valid material type.");
        }

        boolean reusable;
        while (true) {
            System.out.print("Is the medical material reusable (true/false)? ");
            if (scanner.hasNextBoolean()) {
                reusable = scanner.nextBoolean();
                break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Please enter true or false.");
        }

        int productID = ProductController.getLastProductID();

        boolean result = MedicalMaterialsControllers.registerMedicalMaterial(productID, size, materialTypeID, reusable);

        if (result) {
            System.out.println("Medical material registered successfully.");
        } else {
            System.out.println("Failed to register the medical material. Please try again.");
        }
    }

    private static void createAccesories() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTER NEW ACCESSORY ---");

        System.out.println("Select a material type:");
        List<MaterialType> materialTypes = MaterialTypeController.listMaterialTypes();

        if (materialTypes.isEmpty()) {
            System.out.println("No material types available. Please register one before proceeding.");
            return;
        }

        for (int i = 0; i < materialTypes.size(); i++) {
            System.out.println((i + 1) + ". " + materialTypes.get(i).getName());
        }

        MaterialType materialTypeID;
        while (true) {
            System.out.print("Enter the number corresponding to the material type: ");
            if (scanner.hasNextInt()) {
                int materialChoice = scanner.nextInt();
                if (materialChoice >= 1 && materialChoice <= materialTypes.size()) {
                    materialTypeID = MaterialTypeController.getMaterialType(materialChoice);
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid choice. Please select a valid material type.");
        }

        scanner.nextLine(); // Clear buffer

        String dimensions;
        while (true) {
            System.out.print("Enter the dimensions of the accessory (e.g., 10x15x20 cm): ");
            dimensions = scanner.nextLine().trim();
            if (!dimensions.isEmpty()) {
                break;
            }
            System.out.println("Dimensions cannot be empty. Please enter again.");
        }

        System.out.println("Select a accesory type:");

        List<AccesoryType> accesoryTypes = AccesoryTypeController.listAccesoryTypes();

        if (accesoryTypes.isEmpty()) {
            System.out.println("No accessory types available. Please register one before proceeding.");
            return;
        }

        for (int i = 0; i < accesoryTypes.size(); i++) {
            System.out.println((i + 1) + ". " + accesoryTypes.get(i).getName());
        }

        AccesoryType selectedAccesoryType;
        while (true) {
            System.out.print("Enter the number corresponding to the accessory type: ");
            if (scanner.hasNextInt()) {
                int accesoryChoice = scanner.nextInt();
                if (accesoryChoice >= 1 && accesoryChoice <= accesoryTypes.size()) {
                    selectedAccesoryType = accesoryTypes.get(accesoryChoice - 1);
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid choice. Please select a valid accessory type.");
        }

        int productID = ProductController.getLastProductID();

        boolean result = AccesoryController.registerAccessory(productID, materialTypeID, dimensions, selectedAccesoryType);

        if (result) {
            System.out.println("Accessory registered successfully.");
        } else {
            System.out.println("Failed to register the accessory. Please try again.");
        }

    }

    private static void createFood() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTER NEW FOOD ITEM ---");

        // Input for weight
        double weight;
        while (true) {
            System.out.print("Enter the weight of the food (in kilograms): ");
            if (scanner.hasNextDouble()) {
                weight = scanner.nextDouble();
                if (weight > 0) {
                    break;
                }
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Weight must be a positive number. Please enter again.");
        }

        // Input for calories
        int calories;
        while (true) {
            System.out.print("Enter the number of calories: ");
            if (scanner.hasNextInt()) {
                calories = scanner.nextInt();
                if (calories > 0) {
                    break;
                }
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Calories must be a positive integer. Please enter again.");
        }

        // Input for isOrganic
        boolean isOrganic;
        while (true) {
            System.out.print("Is the food organic (true/false)? ");
            if (scanner.hasNextBoolean()) {
                isOrganic = scanner.nextBoolean();
                break;
            } else {
                scanner.next(); // Clear invalid input
            }
            System.out.println("Invalid input. Please enter true or false.");
        }

        // Get the last product ID
        int productID = ProductController.getLastProductID();

        // Register the food item
        boolean result = FoodController.registerFood(productID, weight, calories, isOrganic);

        if (result) {
            System.out.println("Food item registered successfully.");
        } else {
            System.out.println("Failed to register the food item. Please try again.");
        }

    }

    private static void deleteProduct() throws SQLException {
        try {
            Scanner scanner = new Scanner(System.in);
            Integer id = null;

            System.out.print("Enter the ID of the product: ");
            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the product ID.");
                return;
            }

            Product product = ProductController.getProductId(id);
            if (product == null) {
                System.out.println("Product with ID " + id + " not found.");
                return;
            }

            deleteProductDependencies(id);

            boolean result = ProductController.deleteProduct(id);
            if (result) {
                System.out.println("Product and associated data deleted successfully.");
            } else {
                System.out.println("Failed to delete product with ID " + id + ".");
            }

        } catch (SQLException e) {
            System.out.println("Database error occurred while attempting to delete the product: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void deleteProductDependencies(Integer id) throws SQLException {
        Product product = ProductController.getProductId(id);
        if (product == null) {
            throw new SQLException("Product not found for ID: " + id);
        }

        switch (product.getProductType().getIdProductType()) {
            case 1:
                MedicineController.deleteMedicine(id);
                break;
            case 2:
                VaccineController.deleteVaccine(id);
                break;
            case 3:
                MedicalMaterialsControllers.deleteMedicalMaterial(id);
                break;
            case 4:
                AccesoryController.deleteAccessory(id);
                break;
            case 5:
                FoodController.deleteFood(id);
                break;
            default:
                throw new SQLException("Unknown product type for ID: " + id);
        }
    }

}
