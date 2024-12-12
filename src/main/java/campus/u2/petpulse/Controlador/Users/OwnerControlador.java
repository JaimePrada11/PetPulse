package campus.u2.petpulse.Controlador.Users;

import java.sql.SQLException;
import campus.u2.petpulse.Clases.Animals.*;
import campus.u2.petpulse.Clases.Users.*;
import static campus.u2.petpulse.Controlador.Users.PetControlador.getPetsByOwnerId;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import campus.u2.petpulse.Vista.MenuFunction.MenuFunctions;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OwnerControlador {

    
    public static boolean registerOwner(String name, String idCard, String address, String phoneNumber, String email) {
        String query = "INSERT INTO Owners(Name, ID_Card, Address, Phone_Number, Email ) VALUES(?,?,?,?,?)";

        Owner owner = new OwnerBuilder()
                .setname(name)
                .setPhoneNumber(phoneNumber)
                .setIdCard(idCard)
                .setAddress(address)
                .setEmail(email)
                .build();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, owner.getName(), owner.getId_Card(), owner.getAddress(),
                        owner.getPhone_Number(), owner.getEmail());

                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de inserción: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    public static boolean updateOwner(String name, String phoneNumber, String idCard, String address, String email, Integer idEmergencyContact, Integer idOwner) throws SQLException {
        String query = "UPDATE Owners SET Name = ?, ID_Card = ?, Address = ?, Phone_Number = ?, Email = ?, ID_Emergency_Contact = ? WHERE ID_Owner = ?";

        Owner owner = new OwnerBuilder()
                .setname(name)
                .setPhoneNumber(phoneNumber)
                .setIdCard(idCard)
                .setAddress(address)
                .setEmail(email)
                .build();

        try {
            CRUD.setConnection(ConexionDB.getConexion());

            if (CRUD.setAutoCommitDB(false)) {

                boolean result = CRUD.updateInDB(query, owner.getName(), owner.getId_Card(), owner.getAddress(),
                        owner.getPhone_Number(), owner.getEmail(), idEmergencyContact, idOwner);

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

    public static boolean deleteOwner(Integer idOwner) throws SQLException {
        String query = "DELETE FROM Owners WHERE ID_Owner = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());

            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idOwner);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de eliminación: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    public static Owner getOwnerById(int idOwner) throws SQLException {
        String query = "SELECT * FROM Owners WHERE ID_Owner = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());

            ResultSet rs = CRUD.queryDB(query, idOwner);

            if (rs.next()) {
                Owner owner = new OwnerBuilder()
                        .setId(rs.getInt("ID_Owner"))
                        .setname(rs.getString("Name"))
                        .setIdCard(rs.getString("ID_Card"))
                        .setAddress(rs.getString("Address"))
                        .setPhoneNumber(rs.getString("Phone_Number"))
                        .setEmail(rs.getString("Email"))
                        .build();

                rs.close();
               owner.setPetsList((ArrayList<Animal>) getPetsByOwnerId(idOwner));
                return owner;
            }
            
           
            
            
            
            
            
        } catch (SQLException e) {
            System.out.println("Error al obtener el propietario: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    public static String getSubscriptionTypeById(int idSubscription) throws SQLException {
        String query = "SELECT Subscription_Type FROM Subscriptions WHERE ID_Subscription = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());

            ResultSet rs = CRUD.queryDB(query, idSubscription);

            if (rs != null && rs.next()) {
                String subscriptionType = rs.getString("Subscription_Type");
                rs.close();
                return subscriptionType;
            } else {
                System.out.println("No se encontró una suscripción con el ID: " + idSubscription);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el tipo de suscripción: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    public static boolean updateSubscriptionByIdCard(String idCard, int newSubscriptionId) {
        String query = "UPDATE Owners SET Subscription_ID = ? WHERE ID_Card = ?";

        try {

            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, newSubscriptionId, idCard);
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

    public static Owner getOwnerByIdCard(String idCard) throws SQLException {
        String query = "SELECT * FROM Owners WHERE ID_Card = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());

            ResultSet rs = CRUD.queryDB(query, idCard);

            if (rs.next()) {
                Owner owner = new OwnerBuilder()
                        .setId(rs.getInt("ID_Owner"))
                        .setname(rs.getString("Name"))
                        .setIdCard(rs.getString("ID_Card"))
                        .setAddress(rs.getString("Address"))
                        .setPhoneNumber(rs.getString("Phone_Number"))
                        .setEmail(rs.getString("Email"))
                        .build();

                rs.close();
                return owner;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el propietario por ID_Card: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    public static List<Owner> listOwners() throws SQLException {
        String query = "SELECT * FROM Owners";
        List<Owner> ownersList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());

            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {

                Owner owner = new OwnerBuilder()
                        .setId(rs.getInt("ID_Owner"))
                        .setname(rs.getString("Name"))
                        .setIdCard(rs.getString("ID_Card"))
                        .setAddress(rs.getString("Address"))
                        .setPhoneNumber(rs.getString("Phone_Number"))
                        .setEmail(rs.getString("Email"))
                        .build();

                ownersList.add(owner);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar propietarios: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return ownersList;
    }
    
    public static Owner lookForOwner() {
    System.out.println("=== LOOK FOR OWNER BY ID ===");
    System.out.println("ENTER THE ID CARD:");

    Scanner scanner = new Scanner(System.in); 
    String idCard = scanner.nextLine().trim(); 

    if (idCard.isEmpty()) {
        System.out.println("ID Card cannot be empty. Please try again.");
        return null; 
    }

    try {
        Owner owner = OwnerControlador.getOwnerByIdCard(idCard);
        if (owner != null) {
            owner.setPetsList((ArrayList<Animal>) getPetsByOwnerId(owner.getId()));
            System.out.println("Owner found: " + owner);
            owner.getPetsList().forEach(System.out::println);
            return owner;
            
        } else {
            System.out.println("No owner found with the provided ID Card.");
            return null;
        }
    } catch (SQLException ex) {
        System.err.println("An error occurred while searching for the owner. Please try again.");
        Logger.getLogger(MenuFunctions.class.getName()).log(Level.SEVERE, null, ex);
        return null; 
    }
}
    
    
    public static Owner lookForOwner(String idCard ) {
    System.out.println("=== LOOK FOR OWNER BY ID ===");
   

    try {
        Owner owner = OwnerControlador.getOwnerByIdCard(idCard);
        if (owner != null) {
            owner.setPetsList((ArrayList<Animal>) getPetsByOwnerId(owner.getId()));
            System.out.println("Owner found: " + owner);
            owner.getPetsList().forEach(System.out::println);
            return owner;
            
        } else {
            System.out.println("No owner found with the provided ID Card.");
            return null;
        }
    } catch (SQLException ex) {
        System.err.println("An error occurred while searching for the owner. Please try again.");
        Logger.getLogger(MenuFunctions.class.getName()).log(Level.SEVERE, null, ex);
        return null; 
    }
}

    public static boolean updateSubscriptionId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
     /// UPDATE NAME ////

    public static void updateName(Integer ownerId) {
        System.out.println("=== UPDATE NAME ===");
        Scanner scanner = new Scanner(System.in);
        System.out.println("New name ");
        String neewinfo = scanner.nextLine();

        try {
            String idcnverted = String.valueOf(ownerId);       
            
            Owner owner = OwnerControlador.getOwnerByIdCard(idcnverted);
            System.out.println(owner);

            OwnerControlador.updateOwner(neewinfo, owner.getPhone_Number(), owner.getId_Card(),
                    owner.getAddress(), owner.getEmail(), owner.getEmergencyContacts(), owner.getId());
            System.out.println("Info has been updated");

        } catch (SQLException ex) {
            Logger.getLogger(MenuFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
/// UPDATE Phone number ////////
    /// UPDATE Phone number ////////

public static void updatePhoneNumber(Integer ownerId) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("=== UPDATE PHONE NUMBER ===");
    System.out.println("Enter the new phone number");
    String neewinfo = scanner.nextLine();

    try {
        String idConverted = String.valueOf(ownerId);       

        Owner owner = OwnerControlador.getOwnerByIdCard(idConverted);
        System.out.println(owner);

        OwnerControlador.updateOwner(owner.getName(), neewinfo, owner.getId_Card(),
                owner.getAddress(), owner.getEmail(), owner.getEmergencyContacts(), owner.getId());
        System.out.println("Info has been updated");

    } catch (SQLException ex) {
        Logger.getLogger(MenuFunctions.class.getName()).log(Level.SEVERE, null, ex);
    }
}
//////// UPDATE ADDRESS ////////////////////

public static void updateAddress(Integer ownerId) {
    System.out.println("=== UPDATE ADDRESS ===");

    Scanner scanner = new Scanner(System.in);
    System.out.println("New Address ");
    String neewinfo = scanner.nextLine();

    try {
        String idConverted = String.valueOf(ownerId);       

        Owner owner = OwnerControlador.getOwnerByIdCard(idConverted);
        System.out.println(owner);

        OwnerControlador.updateOwner(owner.getName(), owner.getPhone_Number(), owner.getId_Card(),
                neewinfo, owner.getEmail(), owner.getEmergencyContacts(), owner.getId());
        System.out.println("Info has been updated");

    } catch (SQLException ex) {
        Logger.getLogger(MenuFunctions.class.getName()).log(Level.SEVERE, null, ex);
    }
}
/////////// UPDATE Email 

public static void updateEmail(Integer ownerId) {
    System.out.println("=== UPDATE EMAIL ===");
    Scanner scanner = new Scanner(System.in);
    System.out.println("New Email ");
    String neewinfo = scanner.nextLine();

    try {
        String idConverted = String.valueOf(ownerId);       

        Owner owner = OwnerControlador.getOwnerByIdCard(idConverted);
        System.out.println(owner);

        OwnerControlador.updateOwner(owner.getName(), owner.getPhone_Number(), owner.getId_Card(),
                owner.getAddress(), neewinfo, owner.getEmergencyContacts(), owner.getId());
        System.out.println("Info has been updated");

    } catch (SQLException ex) {
        Logger.getLogger(MenuFunctions.class.getName()).log(Level.SEVERE, null, ex);
    }
}

/////////////// UPDATE updateSubscriptionId

public static void updateSubscriptionId(Integer ownerId) {
    System.out.println("=== UPDATE SUBSCRIPTION ID ===");
    Scanner scanner = new Scanner(System.in);
    String idConverted = String.valueOf(ownerId);

    System.out.println("Select the new subscription level:");
    System.out.println("1. Basic");
    System.out.println("2. Premium");
    System.out.println("3. VIP");

    try {
        int option = scanner.nextInt();

        if (option >= 1 && option <= 3) {
            OwnerControlador.updateSubscriptionByIdCard(idConverted, option);
            System.out.println("Subscription successfully updated.");
        } else {
            System.out.println("Invalid option. Please select a number between 1 and 3.");
        }
    } catch (Exception e) {
        System.out.println("Invalid input. Please enter a valid number.");
    } finally {
       
    }
}
    
       public static String registerOwnermenu() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Registering a new owner...");

            // Request information from the user
            System.out.print("Enter owner's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter owner's phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter owner's ID card: ");
            String idCard = scanner.nextLine();

            System.out.print("Enter owner's address: ");
            String address = scanner.nextLine();

            System.out.print("Enter owner's email: ");
            String email = scanner.nextLine();

            boolean success = OwnerControlador.registerOwner(name, idCard, address, phoneNumber, email);
           

            // Verify the result of the operation
            if (success) {
                System.out.println("The owner was registered successfully.");
            } else {
                System.out.println("Failed to register the owner. Please try again.");
            }
        return idCard;
        }
    
}
