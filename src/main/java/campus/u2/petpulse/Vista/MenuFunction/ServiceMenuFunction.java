package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Controlador.ServicesControlleres.ServiceController;
import java.sql.SQLException;
import campus.u2.petpulse.Clases.Services.*;
import campus.u2.petpulse.Controlador.ServicesControlleres.BathsController;
import campus.u2.petpulse.Controlador.ServicesControlleres.ServiceTypeController;
import campus.u2.petpulse.Controlador.ServicesControlleres.ConsultationController;
import campus.u2.petpulse.Controlador.ServicesControlleres.DayCareController;
import campus.u2.petpulse.Controlador.ServicesControlleres.TrainingController;
import campus.u2.petpulse.Controlador.ServicesControlleres.VaccinationController;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceMenuFunction {

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

    public static void addProducts() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        listServices();
        System.out.print("Enter the id of the service: ");
        Integer serviceId = scanner.nextInt();
        while (serviceId > ServiceController.listServices().size()) {
            System.out.print("Erro. Please enter a valid id: ");
            serviceId = scanner.nextInt();
        }

    }

    private static int showServicesTypes() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        List<ServiceType> serviceTypes = ServiceTypeController.listServiceTypes();

        System.out.println("\n--- SELECT SERVICE TYPE ---");
        for (int i = 0; i < serviceTypes.size(); i++) {
            System.out.println((i + 1) + ". " + serviceTypes.get(i).getName());
        }

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Enter the number corresponding to the desired service type: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= serviceTypes.size()) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please select a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        return serviceTypes.get(choice - 1).getIdServiceType();
    }

    private static void registerService() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTER NEW SERVICE ---");

        System.out.print("Enter the name of the service: ");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.print("Service name cannot be empty. Please enter a valid name: ");
            name = scanner.nextLine();
        }

        System.out.print("Enter a description of the service: ");
        String description = scanner.nextLine();
        while (description.isEmpty()) {
            System.out.print("Description cannot be empty. Please enter a valid description: ");
            description = scanner.nextLine();
        }

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Enter the price of the service: ");
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

        int points = 0;
        boolean validPoints = false;
        while (!validPoints) {
            System.out.print("Enter the points for the service: ");
            if (scanner.hasNextInt()) {
                points = scanner.nextInt();
                if (points > 0) {
                    validPoints = true;
                } else {
                    System.out.println("Points must be a positive number. Please enter again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the points.");
                scanner.nextLine();
            }
        }

        int serviceType = showServicesTypes();
        
        ServiceType s = ServiceTypeController.getServiceType(serviceType);

        scanner.nextLine();

        boolean result = ServiceController.registerService(name, description, price, points, s);
        if (result) {

//            switch (serviceType) {
//                case 1:
//                    createConsultation();
//                    break;
//                case 2:
//                    createProcedure();
//                    break;
//                case 3:
//                    createVaccination();
//                    break;
//                case 4:
//                    createBaths();
//                    break;
//                case 5:
//                    createTraining();
//                    break;
//                case 6:
//                    createDayCare();
//                    break;
//                case 7:
//                    System.out.println("Service type 7 selected.");
//                    break;
//                case 0:
//                    System.out.println("Exiting update menu...");
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
            System.out.println("Service registered successfully: " + name);

        } else {
            System.out.println("Error registering the service.");
        }
    }

    private static void createConsultation() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter reason for the service: ");
        String reason = scanner.nextLine();

        System.out.print("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter recommendations: ");
        String recommendations = scanner.nextLine();

        // Verificación de fecha (no puede ser futura)
        System.out.print("Enter consultation date (YYYY-MM-DD): ");
        LocalDate consultationDate = LocalDate.parse(scanner.nextLine());

        if (consultationDate.isAfter(LocalDate.now())) {
            System.out.println("Consultation date cannot be in the future.");
            return;
        }

        if (reason.isEmpty() || diagnosis.isEmpty() || recommendations.isEmpty()) {
            System.out.println("Reason, diagnosis, and recommendations cannot be empty.");
            return;
        }

        int id = ServiceController.getLastServiceID();

        ConsultationController.registerConsultation(id, reason, diagnosis, recommendations, consultationDate);
    }

    private static void createBaths() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        int idService = ServiceController.getLastServiceID();

        System.out.print("Enter the haircut style (e.g., short, medium, long): ");
        String haircutStyle = scanner.nextLine();
        while (haircutStyle.isEmpty()) {
            System.out.print("Haircut style cannot be empty. Please enter a valid style: ");
            haircutStyle = scanner.nextLine();
        }

        System.out.print("Does the service include nail trimming? (yes/no): ");
        String nailTrimmingInput = scanner.nextLine().toLowerCase();
        boolean nailTrimmingIncluded = false;

        while (!nailTrimmingInput.equals("yes") && !nailTrimmingInput.equals("no")) {
            System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            nailTrimmingInput = scanner.nextLine().toLowerCase();
        }

        if (nailTrimmingInput.equals("yes")) {
            nailTrimmingIncluded = true;
        }

        BathsController.registerBaths(idService, haircutStyle, nailTrimmingIncluded);
    }

    private static void createProcedure() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        int idService = ServiceController.getLastServiceID();
    }

    private static void createTraining() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        int idService = ServiceController.getLastServiceID();

        System.out.print("Enter the results of the training: ");
        String results = scanner.nextLine();
        while (results.isEmpty()) {
            System.out.print("Results cannot be empty. Please enter valid results: ");
            results = scanner.nextLine();
        }

        LocalTime durationSession = null;
        boolean validDuration = false;
        while (!validDuration) {
            System.out.print("Enter the duration of each session (HH:MM): ");
            String durationInput = scanner.nextLine();

            try {
                durationSession = LocalTime.parse(durationInput);
                validDuration = true;
            } catch (Exception e) {
                System.out.println("Invalid time format. Please enter the time in HH:MM format.");
            }
        }

        int totalSessions = 0;
        boolean validTotalSessions = false;
        while (!validTotalSessions) {
            System.out.print("Enter the total number of sessions: ");
            if (scanner.hasNextInt()) {
                totalSessions = scanner.nextInt();
                if (totalSessions > 0) {
                    validTotalSessions = true;
                } else {
                    System.out.println("The number of sessions must be greater than 0. Please enter again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the number of sessions.");
                scanner.nextLine();
            }
        }

        TrainingController.registerBaths(idService, results, durationSession, totalSessions);

    }

    private static void createDayCare() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        int idService = ServiceController.getLastServiceID();

        System.out.print("Enter the special conditions for the daycare: ");
        String specialConditions = scanner.nextLine();
        while (specialConditions.isEmpty()) {
            System.out.print("Special conditions cannot be empty. Please enter valid conditions: ");
            specialConditions = scanner.nextLine();
        }

        System.out.print("Enter the start date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter the end date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        if (endDate.isBefore(startDate)) {
            System.out.println("End date cannot be before start date.");
            return;
        }

        DayCareController.registerDayCare(idService, specialConditions, startDate, endDate);

    }

    private static void createVaccination() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        int idService = ServiceController.getLastServiceID();

        System.out.print("Enter the application date (YYYY-MM-DD): ");
        LocalDate applicationDate = LocalDate.parse(scanner.nextLine());

        if (applicationDate.isAfter(LocalDate.now())) {
            System.out.println("Application date cannot be in the future.");
            return;
        }

        System.out.print("Enter the next dose date (YYYY-MM-DD): ");
        LocalDate nextDoseDate = LocalDate.parse(scanner.nextLine());

        if (nextDoseDate.isBefore(applicationDate)) {
            System.out.println("Next dose date must be after the application date.");
            return;
        }

        VaccinationController.registerVaccination(idService, applicationDate, nextDoseDate);

    }

    private static void updateService() {
        Scanner scanner = new Scanner(System.in);
        String opcion = null;

        System.out.println("Updating a Service's information...");

        System.out.print("Enter the Service's ID to update: ");
        Integer serviceid = null;

        while (serviceid == null) {
            try {
                serviceid = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for the Service ID.");
                scanner.nextLine();
            }
        }

        do {
            System.out.println("\n--- UPDATE MENU ---");
            System.out.println("1. Update Name");
            System.out.println("2. Update Description");
            System.out.println("3. Update Price");
            System.out.println("4. Update Points");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    updateName(serviceid);
                case "2" ->
                    updateDescription(serviceid);
                case "3" ->
                    updatePrice(serviceid);
                case "4" ->
                    updatePoints(serviceid);
                case "0" ->
                    System.out.println("Exiting update menu...");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!"0".equals(opcion));
    }

    private static void updateName(Integer serviceid) {
        System.out.println("=== UPDATE NAME ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("New name ");
        String newinfo = scanner.nextLine();

        try {

            Service service = ServiceController.getService(serviceid);

            ServiceController.updateService(serviceid, newinfo, service.getDescription(), service.getPrice(), service.getPoints(), service.getServiceType());
            System.out.println("Info has been updated");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMenuFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void updateDescription(Integer serviceid) {
        System.out.println("=== UPDATE DESCRIPTION ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Description ");
        String newinfo = scanner.nextLine();

        try {

            Service service = ServiceController.getService(serviceid);

            ServiceController.updateService(serviceid, service.getName(), newinfo, service.getPrice(), service.getPoints(), service.getServiceType());
            System.out.println("Info has been updated");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMenuFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void updatePrice(Integer serviceid) {
        System.out.println("=== UPDATE DESCRIPTION ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Description ");
        Double newinfo = scanner.nextDouble();

        try {

            Service service = ServiceController.getService(serviceid);

            ServiceController.updateService(serviceid, service.getName(), service.getDescription(), newinfo, service.getPoints(), service.getServiceType());
            System.out.println("Info has been updated");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMenuFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void updatePoints(Integer serviceid) {
        System.out.println("=== UPDATE DESCRIPTION ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Description ");
        Integer newinfo = scanner.nextInt();

        try {

            Service service = ServiceController.getService(serviceid);

            ServiceController.updateService(serviceid, service.getName(), service.getDescription(), service.getPrice(),
                    newinfo, service.getServiceType());
            System.out.println("Info has been updated");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMenuFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void deleteService() throws SQLException {

        try {
            Scanner scanner = new Scanner(System.in);
            Integer id = null;

            System.out.print("Enter the ID of the service: ");

            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the service ID.");
                return;
            }

            boolean result = ServiceController.deleteService(id);

            if (result) {
                System.out.println("Service deleted successfully.");
            } else {
                System.out.println("Service with ID " + id + " not found or could not be deleted.");
            }

        } catch (SQLException e) {
            System.out.println("Database error occurred while attempting to delete the service: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }

    public static void listServices() {
        System.out.println("Listing all services...");

        try {
            List<Service> lista = ServiceController.listServices();
            lista.stream()
                    .forEach(System.out::println);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMenuFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void listServicesBelowPrice() {
        System.out.println("Listing all services below the specified price...");
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);
            Double price;

            System.out.print("Enter the price: ");
            try {
                price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("The price cannot be negative. Please try again.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid decimal number for the price.");
                return;
            }

            List<Service> services = ServiceController.listServices();
            if (services == null || services.isEmpty()) {
                System.out.println("No services available.");
                return;
            }

            List<Service> filteredServices = services.stream()
                    .filter(service -> service.getPrice() < price)
                    .toList();

            if (filteredServices.isEmpty()) {
                System.out.println("No services found below the specified price.");
            } else {
                filteredServices.forEach(System.out::println);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceMenuFunction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
