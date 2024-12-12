package campus.u2.petpulse.Vista.MenuFunction;

import campus.u2.petpulse.Clases.Animals.*;
import campus.u2.petpulse.Clases.Users.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import campus.u2.petpulse.Controlador.Users.OwnerControlador;
import campus.u2.petpulse.Controlador.Users.PetControlador;
import  campus.u2.petpulse.Controlador.Users.*;
import campus.u2.petpulse.Controlador.Users.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuAnimals {

    public static void mostrarMenuMascotas() {

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- ANIMAL MENU ---");
            System.out.println("1. Register a new pet");
            System.out.println("2. Update pet information");
            System.out.println("3. List all pets");
            System.out.println("4. List pets per Owner");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    CompleteRegistration();
                    break;
                case 2:
                    updatePet();
                    break;
                case 3:
                    listarMascotas();
                    break;
                case 4:
                    OwnerControlador.lookForOwner();
                    break;
                case 0:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (opcion != 0);
    }

    
/////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////
    public static Animal createPet(int idOwner) {
        Animal newPet = null;
        Scanner scanner = new Scanner(System.in);

        try {
            int choice = 0;
            do {
                System.out.println("Choose the species:");
                System.out.println("1. Dog");
                System.out.println("2. Cat");
                System.out.println("3. Horse");
                System.out.println("4. Guinea Pig");
                System.out.println("5. Iguana");
                System.out.println("6. Snake");
                System.out.println("7. Guacamaya");
                System.out.println("8. Parrot");
                System.out.print("Enter your choice (1-8): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 8.");
                    scanner.next();
                }
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 8);
            scanner.nextLine();

            System.out.print("Enter the pet's name: ");
            String name = scanner.nextLine();

            LocalDate birthdate = null;
            while (birthdate == null) {
                System.out.print("Enter the pet's birthdate (yyyy-MM-dd): ");
                String birthdateInput = scanner.nextLine();
                try {
                    birthdate = LocalDate.parse(birthdateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                }
            }

            System.out.print("Enter the pet's age: ");
            int age = validateInteger(scanner, "Invalid age. Please enter a positive number: ", 0, Integer.MAX_VALUE);

            System.out.print("Enter the pet's sex (M/F): ");
            String sex;
            while (true) {
                sex = scanner.nextLine().toUpperCase();
                if (sex.equals("M") || sex.equals("F")) {
                    break;
                }
                System.out.println("Invalid input. Please enter 'M' for male or 'F' for female.");
            }

            System.out.print("Enter a photo URL or description: ");
            String photo = scanner.nextLine();

            System.out.print("Enter the pet's allergies (if any, otherwise type 'none'): ");
            String allergies = scanner.nextLine();

            System.out.print("Enter any pre-existing conditions (if any, otherwise type 'none'): ");
            String preExistingConditions = scanner.nextLine();

            System.out.print("Is the pet available for adoption? (true/false): ");
            boolean available = validateBoolean(scanner, "Invalid input. Please enter 'true' or 'false': ");

//            System.out.print("Enter the owner's ID: ");
//            int idOwner = validateInteger(scanner, "Invalid ID. Please enter a positive number: ", 0, Integer.MAX_VALUE);

            System.out.print("Enter the pet's weight: ");
            double weight = validateDouble(scanner, "Invalid weight. Please enter a positive number: ", 0, Double.MAX_VALUE);

            
            
          

            switch (choice) {
                case 1 ->
                    newPet = new Dog(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 1, weight);
                case 2 ->
                    newPet = new Cat(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 1, weight);
                case 3 ->
                    newPet = new Horses(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 1, weight);
                case 4 ->
                    newPet = new GuineaPig(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 1, weight);
                case 5 ->
                    newPet = new Iguana(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 2, weight);
                case 6 ->
                    newPet = new Snake(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 2, weight);
                case 7 ->
                    newPet = new Guacamaya(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 3, weight);
                case 8 ->
                    newPet = new Parrot(null, null, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, 3, weight);
            }

            if (newPet != null) {
                boolean success = PetControlador.registerPet(newPet);
                System.out.println(success ? "Registration successful." : "Failed to register the pet.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return newPet;
    }

    private static int validateInteger(Scanner scanner, String errorMessage, int min, int max) {
        int value;
        while (true) {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    scanner.nextLine();
                    return value;
                }
            }
            System.out.println(errorMessage);
            scanner.nextLine();
        }
    }

    private static double validateDouble(Scanner scanner, String errorMessage, double min, double max) {
        double value;
        while (true) {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= min && value <= max) {
                    scanner.nextLine();
                    return value;
                }
            }
            System.out.println(errorMessage);
            scanner.nextLine();
        }
    }

    private static boolean validateBoolean(Scanner scanner, String errorMessage) {
        while (true) {
            if (scanner.hasNextBoolean()) {
                return scanner.nextBoolean();
            }
            System.out.println(errorMessage);
            scanner.nextLine(); // Clear invalid input
        }
    }

    
    
    
    
 public static void CompleteRegistration() {
    Scanner scanner = new Scanner(System.in);

    try {
        // Buscar al dueño
        System.out.print("Enter owner's ID card: ");
        String idCard = scanner.nextLine();

        Owner newOwner = OwnerControlador.lookForOwner(idCard);

        if (newOwner == null) {
            System.out.println("Owner not found. Please register the owner first.");
           idCard = OwnerControlador.registerOwnermenu();
            newOwner = OwnerControlador.lookForOwner(idCard);
        }
        OwnerControlador.lookForOwner(idCard);

        // Crear la mascota
        Animal newAnimal = createPet(newOwner.getId());
        if (newAnimal == null) {
            System.out.println("Failed to create the pet. Please try again.");
            return;
        }

        System.out.println("Animal registered: " + newAnimal.getClass().getSimpleName());

       
       
        int idPet = PetControlador.getLastProductID();

       

        
        if (newAnimal instanceof Dog) {
           
            PetsAttributesControlador.insertPetAttribute(idPet, 1);
            PetsAttributesControlador.insertPetAttribute(idPet, 4);
        } else if (newAnimal instanceof Cat) {
            
            PetsAttributesControlador.insertPetAttribute(idPet, 1);
            PetsAttributesControlador.insertPetAttribute(idPet, 5);
        } else if (newAnimal instanceof Horses) {
            
            PetsAttributesControlador.insertPetAttribute(idPet, 1);
            PetsAttributesControlador.insertPetAttribute(idPet, 6);
        } else if (newAnimal instanceof GuineaPig) {
         
            PetsAttributesControlador.insertPetAttribute(idPet, 1);
            PetsAttributesControlador.insertPetAttribute(idPet, 7);
        } else if (newAnimal instanceof Iguana) {
           
            PetsAttributesControlador.insertPetAttribute(idPet, 3);
            PetsAttributesControlador.insertPetAttribute(idPet, 8);
        } else if (newAnimal instanceof Snake) {
            
            PetsAttributesControlador.insertPetAttribute(idPet, 3);
            PetsAttributesControlador.insertPetAttribute(idPet, 9);
        } else if (newAnimal instanceof Guacamaya) {
            
            PetsAttributesControlador.insertPetAttribute(idPet, 2);
            PetsAttributesControlador.insertPetAttribute(idPet, 10);
        } else if (newAnimal instanceof Parrot) {
           
            PetsAttributesControlador.insertPetAttribute(idPet, 2);
            PetsAttributesControlador.insertPetAttribute(idPet, 11);
        } else {
            
            PetsAttributesControlador.insertPetAttribute(idPet, 24);
            System.out.println("Animal type unknown. Assigned default attribute: Other.");
        }

        System.out.println("Registration completed successfully.");
    } catch (Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void updatePet() {
        Scanner scanner = new Scanner(System.in);
        String option = null;

        System.out.println("Updating a pet's information...");

        Integer petId = null;
        while (petId == null) {
            try {
                System.out.print("Enter the Pet's ID to update: ");
                petId = Integer.parseInt(scanner.nextLine()); // Convert input to integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid Pet ID.");
            }
        }

        do {
            System.out.println("\n--- UPDATE PET MENU ---");
            System.out.println("1. Update Name");
            System.out.println("2. Update Age");
            System.out.println("3. Update Birthdate");
            System.out.println("4. Update Sex");
            System.out.println("5. Update Photo");
            System.out.println("6. Update Allergies");
            System.out.println("7. Update Pre-Existing Conditions");
            System.out.println("8. Update Availability");
            System.out.println("9. Update Owner ID");
            System.out.println("10. Update Species ID");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextLine();

            try {
                switch (option) {
                    case "1" ->
                        PetControlador.updateName(petId);
                    case "2" ->
                        PetControlador.updateAge(petId);
                    case "3" ->
                        PetControlador.updateBirthdate(petId);
                    case "4" ->
                        PetControlador.updateSex(petId);
                    case "5" ->
                        PetControlador.updatePhoto(petId);
                    case "6" ->
                        PetControlador.updateAllergies(petId);
                    case "7" ->
                        PetControlador.updatePreExistingConditions(petId);
                    case "8" ->
                        PetControlador.updateAvailability(petId);
                    case "9" ->
                        PetControlador.updateOwnerId(petId);

                    case "0" ->
                        System.out.println("Exiting update menu...");
                    default ->
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input format. Please try again.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        } while (!"0".equals(option));
    }

    private static void eliminarMascota() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- DELETE A PET ---");
        System.out.print("Enter the ID of the pet to delete: ");
        int idMascota = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Here you can call the controller to delete the pet
        System.out.println("Pet successfully deleted with ID: " + idMascota);
    }

    public static void listarMascotas() {
        System.out.println("\n--- LIST ALL PETS ---");
        ArrayList<Animal> listapets = (ArrayList<Animal>) PetControlador.listPets();
        for (Animal i : listapets) {
            System.out.println(i.getIdPet());
            System.out.println(i.getName());
            System.out.println(i.getSex());
            System.out.println(i.getBirthdate());
            System.out.println(i.isAvailable());
        }

    }

}
