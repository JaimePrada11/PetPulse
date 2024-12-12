/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Clases.Animals.*;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetControlador {

    
    
    // Registrar una nueva mascota
    public static boolean registerPet(String name, LocalDate birthdate, int age, String sex, String photo,
            String allergies, String preExistingConditions, boolean available,
            Integer idOwner, Integer idSpecies,  double weight) {
        String query = "INSERT INTO Pets (Name, Birthdate, Age, Sex, Photo, Allergies, PreExistingConditions, Available, ID_Owner, ID_Species) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, idSpecies,weight);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar mascota: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////
    public static boolean registerPet(Animal pet) {
   
    String query = "INSERT INTO Pets (Name, Birthdate, Age, Sex, Photo, Allergies, PreExistingConditions, Available, ID_Owner, ID_Species, Weight) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        CRUD.setConnection(ConexionDB.getConexion());
        
        
        if (CRUD.setAutoCommitDB(false)) {
            
           
            boolean result = CRUD.insertIntoDB(query, 
                pet.getName(), 
                pet.getBirthdate(), 
                pet.getAge(), 
                pet.getSex(), 
                pet.getPhoto(), 
                pet.getAllergies(), 
                pet.getPreExistingConditions(), 
                pet.isAvailable(), 
                pet.getOwner(), 
                pet.getID_Species(), 
                pet.getWeight()
            );
            
          
            if (result) {
                CRUD.commitDB();
            } else {
                CRUD.rollbackDB();
            }
            return result;
        }
    } catch (SQLException e) {
        System.out.println("Error al registrar mascota: " + e.getMessage());
        CRUD.rollbackDB();
    } finally {
      
        CRUD.closeConnection();
    }
    return false;
}


    
    
    
    
    // Actualizar información de una mascota
    public static boolean updatePet(int idPet, String name, LocalDate birthdate, int age, String sex, String photo,
            String allergies, String preExistingConditions, boolean available,
            Integer idOwner, Integer idSpecies, Double weight) {
        String query = "UPDATE Pets SET Name = ?, Birthdate = ?, Age = ?, Sex = ?, Photo = ?, Allergies = ?, PreExistingConditions = ?, Available = ?, ID_Owner = ?, ID_Species = ?, weight + ? WHERE ID_Pet = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, idOwner, idSpecies, idPet, weight);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar mascota: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Eliminar una mascota por ID
    public static boolean deletePet(int idPet) {
        String query = "DELETE FROM Pets WHERE ID_Pet = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idPet);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar mascota: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Obtener una mascota por ID
    public static Animal getPetById(int idPet) {
        String query = "SELECT * FROM Pets WHERE ID_Pet = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idPet);
            if (rs.next()) {
                Animal pet = new Dog(
                        rs.getInt("ID_Pet"),
                        rs.getString("Name"),
                        rs.getDate("Birthdate").toLocalDate(),
                        rs.getInt("Age"),
                        rs.getString("Sex"),
                        rs.getString("Photo"),
                        rs.getString("Allergies"),
                        rs.getString("PreExistingConditions"),
                        rs.getBoolean("Available"),
                        rs.getInt("ID_Owner"),
                        rs.getInt("ID_Species"),
                        rs.getDouble("weight")
                        
                );
                rs.close();
                return pet;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener mascota: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    public static List<Animal> getPetsByOwnerId(int idOwner) {
        String query = "SELECT * FROM Pets WHERE ID_Owner = ?";
        List<Animal> pets = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idOwner);

            while (rs.next()) {
                Animal pet = new Dog(
                        rs.getInt("ID_Pet"),
                        rs.getString("Name"),
                        rs.getDate("Birthdate").toLocalDate(),
                        rs.getInt("Age"),
                        rs.getString("Sex"),
                        rs.getString("Photo"),
                        rs.getString("Allergies"),
                        rs.getString("PreExistingConditions"),
                        rs.getBoolean("Available"),
                        rs.getInt("ID_Owner"),
                        rs.getInt("ID_Species"),
                        rs.getDouble("weight")
                        
                );
                pets.add(pet);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener mascotas: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return pets;
    }

    // Listar todas las mascotas
    public static List<Animal> listPets() {
        String query = "SELECT * FROM Pets";
        List<Animal> petsList = new ArrayList<>();
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);
            while (rs.next()) {
                Animal pet = new Dog(
                          rs.getInt("ID_Pet"),
                        rs.getString("Name"),
                        rs.getDate("Birthdate").toLocalDate(),
                        rs.getInt("Age"),
                        rs.getString("Sex"),
                        rs.getString("Photo"),
                        rs.getString("Allergies"),
                        rs.getString("PreExistingConditions"),
                        rs.getBoolean("Available"),
                        rs.getInt("ID_Owner"),
                        rs.getInt("ID_Species"),
                        rs.getDouble("weight")
                );
                petsList.add(pet);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar mascotas: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return petsList;
    }

    public static void updateName(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE NAME ====");
        System.out.print("Please enter the new Name: ");

        String newInfo = null;
        while (newInfo == null || newInfo.trim().isEmpty()) {
            try {
                newInfo = scanner.nextLine();
                if (newInfo.trim().isEmpty()) {
                    System.out.println("Name cannot be empty. Please try again.");
                    newInfo = null;
                }
            } catch (Exception e) {
                System.out.println("An error occurred while reading the input: " + e.getMessage());
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

        Boolean resultado = updatePet(idPet, newInfo, pet.getBirthdate(), pet.getAge(), pet.getSex(), pet.getPhoto(),
                pet.getAllergies(), pet.getPreExistingConditions(), pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's name.");
        }

    }

    public static void updateAge(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE AGE ====");
        System.out.print("Please enter the new Age: ");

        Integer newAge = null;
        while (newAge == null) {
            try {
                String input = scanner.nextLine();
                newAge = Integer.parseInt(input);
                if (newAge < 0) {
                    System.out.println("Age cannot be negative. Please try again.");
                    newAge = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), newAge, pet.getSex(), pet.getPhoto(),
                pet.getAllergies(), pet.getPreExistingConditions(), pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's age.");
        }
    }

    public static void updateBirthdate(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE BIRTHDATE ====");
        System.out.print("Please enter the new Birthdate (yyyy-MM-dd): ");

        LocalDate newDate = null;
        while (newDate == null) {
            try {
                String input = scanner.nextLine();
                newDate = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), newDate, pet.getAge(), pet.getSex(), pet.getPhoto(),
                pet.getAllergies(), pet.getPreExistingConditions(), pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's birthdate.");
        }
    }

    public static void updateSex(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE SEX ====");
        System.out.print("Please enter the new Sex (Male/Female): ");

        String newSex = null;
        while (newSex == null || (!newSex.equalsIgnoreCase("Male") && !newSex.equalsIgnoreCase("Female"))) {
            try {
                newSex = scanner.nextLine().trim();
                if (!newSex.equalsIgnoreCase("Male") && !newSex.equalsIgnoreCase("Female")) {
                    System.out.println("Invalid input. Please enter 'Male' or 'Female'.");
                    newSex = null;
                }
            } catch (Exception e) {
                System.out.println("An error occurred while reading the input: " + e.getMessage());
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), pet.getAge(), newSex, pet.getPhoto(),
                pet.getAllergies(), pet.getPreExistingConditions(), pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's sex.");
        }
    }

    public static void updatePhoto(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE SEX ====");
        System.out.print("Please enter the new Phot Path ..");

        String newSex = null;
        while (newSex == null || (!newSex.equalsIgnoreCase("Male") && !newSex.equalsIgnoreCase("Female"))) {
            try {
                newSex = scanner.nextLine().trim();
                if (!newSex.equalsIgnoreCase("Male") && !newSex.equalsIgnoreCase("Female")) {
                    System.out.println("Invalid input. Please enter 'Male' or 'Female'.");
                    newSex = null;
                }
            } catch (Exception e) {
                System.out.println("An error occurred while reading the input: " + e.getMessage());
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), pet.getAge(), pet.getSex(), newSex,
                pet.getAllergies(), pet.getPreExistingConditions(), pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's sex.");
        }
    }

    public static void updateAllergies(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE ALLERGIES ====");
        System.out.print("Please enter the new Allergies: ");

        String newAllergies = scanner.nextLine().trim();

        Animal pet = getPetById(idPet);
        if (pet == null) {
            System.out.println("Pet with ID " + idPet + " not found.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), pet.getAge(), pet.getSex(), pet.getPhoto(),
                newAllergies, pet.getPreExistingConditions(), pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's allergies.");
        }
    }

    public static void updatePreExistingConditions(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE PRE-EXISTING CONDITIONS ====");
        System.out.print("Please enter the new Pre-Existing Conditions: ");

        String newConditions = scanner.nextLine().trim();

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), pet.getAge(), pet.getSex(), pet.getPhoto(),
                pet.getAllergies(), newConditions, pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's pre-existing conditions.");
        }
    }

    public static void updateAvailability(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE AVAILABILITY ====");
        System.out.print("Is the pet available? (true/false): ");

        boolean newAvailability = false;
        boolean validInput = false;
        while (!validInput) {
            try {
                newAvailability = Boolean.parseBoolean(scanner.nextLine().trim());
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null) {
            System.out.println("Pet with ID " + idPet + " not found.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), pet.getAge(), pet.getSex(), pet.getPhoto(),
                pet.getAllergies(), pet.getPreExistingConditions(), newAvailability,
                pet.getOwner(), pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's availability.");
        }
    }

    public static void updateOwnerId(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE OWNER ID ====");
        System.out.print("Please enter the new Owner ID: ");

        int newOwnerId = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                newOwnerId = Integer.parseInt(scanner.nextLine().trim());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for the Owner ID.");
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

        Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), pet.getAge(), pet.getSex(), pet.getPhoto(),
                pet.getAllergies(), pet.getPreExistingConditions(), pet.isAvailable(),
                newOwnerId, pet.getID_Species(), pet.getWeight());

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's owner ID.");
        }
    }
    
    public static void updateWeight(int idPet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== UPDATE OWNER ID ====");
        System.out.print("Please enter the new Owner ID: ");

        Double newPeso = -1.8;
        boolean validInput = false;
        while (!validInput) {
            try {
                newPeso = Double.parseDouble(scanner.nextLine().trim());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for the Owner ID.");
            }
        }

        Animal pet = getPetById(idPet);
        if (pet == null || pet.getOwner() == null) {
            System.out.println("Pet with ID " + idPet + "  not found. or pet with owner first you have to asing the owner to continue.");
            return;
        }

       Boolean resultado = updatePet(idPet, pet.getName(), pet.getBirthdate(), pet.getAge(), pet.getSex(), pet.getPhoto(),
                pet.getAllergies(), pet.getPreExistingConditions(), pet.isAvailable(),
                pet.getOwner(), pet.getID_Species(), newPeso);

        if (resultado) {
            System.out.println("Update successfully done.");
        } else {
            System.out.println("Failed to update the pet's owner ID.");
        }
    }
    
    
    public static int getLastProductID() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "SELECT MAX(ID_Pet) AS last_id FROM Pets ;";

        ResultSet rs = CRUD.queryDB(query);
        int lastId = -1;

        try {
            if (rs.next()) {
                lastId = rs.getInt("last_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            CRUD.closeConnection();
        }

        return lastId;
    }
}
