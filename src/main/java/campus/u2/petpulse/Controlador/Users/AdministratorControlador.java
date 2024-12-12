
package campus.u2.petpulse.Controlador.Users;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import campus.u2.petpulse.Clases.Users.*;
import static campus.u2.petpulse.Persistencia.CRUD.insertIntoDB;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

public class AdministratorControlador {
    
    
    
    public static boolean registerAdministrator(String name, String phoneNumber, String idCard, String address, String email, String username, String password, LocalDate hireDate, Boolean state, Integer idPosition) {
    String query = "INSERT INTO Employees(username, passwordU, Name, ID_Card, Address, Phone_Number, Email, HireDate, State, ID_Position) VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    
    Administrator administrator = new AdministratorBuilder()
        .setname(name)
        .setPhoneNumber(phoneNumber)
        .setIdCard(idCard)
        .setAddress(address)
        .setEmail(email)
        .setusername(username)
        .setPasswordU(password)
        .setHireDate(hireDate)
        .setState(state)
        .setIdPosition(idPosition)
        .build();

    try {
        CRUD.setConnection(ConexionDB.getConexion()); 
        if (CRUD.setAutoCommitDB(false)) { 
            boolean result = insertIntoDB(query, administrator.getUsername(), administrator.getPasswordU(), administrator.getName(),
                    administrator.getId_Card(), administrator.getAddress(), administrator.getPhone_Number(), administrator.getEmail(),
                    administrator.getHireDate(), administrator.getState(), administrator.getId_Position());
            if (result) {
                CRUD.commitDB(); 
            } else {
                CRUD.rollbackDB(); 
            }
            return result;
        }
    } catch (SQLException e) {
        System.out.println("Error in Insert Operation: " + e.getMessage());
        CRUD.rollbackDB(); 
    } finally {
        CRUD.closeConnection();
    }

    return false; 
}
public static boolean updateAdministrator(String name, String phoneNumber, String idCard, String address, String email, String username, String password, LocalDate hireDate, Boolean state, Integer idPosition, Integer idEmployee) throws SQLException {
    String query = "UPDATE Employees SET username = ?, passwordU = ?, Name = ?, ID_Card = ?, Address = ?, Phone_Number = ?, Email = ?, HireDate = ?, State = ?, ID_Position = ? WHERE ID_Employee = ?";
    
    
    Administrator administrator = new AdministratorBuilder()
        .setname(name)
        .setPhoneNumber(phoneNumber)
        .setIdCard(idCard)
        .setAddress(address)
        .setEmail(email)
        .setusername(username)
        .setPasswordU(password)
        .setHireDate(hireDate)
        .setState(state)
        .setIdPosition(idPosition)
        .build();

    try {
        
        CRUD.setConnection(ConexionDB.getConexion());
        
        if (CRUD.setAutoCommitDB(false)) { 
            
            boolean result = CRUD.updateInDB(query, administrator.getUsername(), administrator.getPasswordU(), administrator.getName(),
                    administrator.getId_Card(), administrator.getAddress(), administrator.getPhone_Number(), administrator.getEmail(),
                    administrator.getHireDate(), administrator.getState(), administrator.getId_Position(), idEmployee);
            if (result) {
                CRUD.commitDB(); 
            } else {
                CRUD.rollbackDB(); 
            }
            return result;
        }
    } catch (SQLException e) {
        System.out.println("Error in Update Operation: " + e.getMessage());
        CRUD.rollbackDB(); 
        throw e;
    } finally {
        CRUD.closeConnection(); 
    }

    return false; 
}

    public static boolean deleteAdministrator(Integer idEmployee) throws SQLException {
    String query = "DELETE FROM Employees WHERE ID_Employee = ?";
    
    try {
        
        CRUD.setConnection(ConexionDB.getConexion());

        if (CRUD.setAutoCommitDB(false)) { 
            boolean result = CRUD.deleteFromDB(query, idEmployee); 
            if (result) {
                CRUD.commitDB(); 
            } else {
                CRUD.rollbackDB(); 
            }
            return result;
        }
    } catch (SQLException e) {
        System.out.println("Error in Delete Operation: " + e.getMessage());
        CRUD.rollbackDB(); 
        throw e;
    } finally {
        CRUD.closeConnection(); 
    }

    return false; 
}
public static Administrator getAdministratorById(int idEmployee) throws SQLException {
    String query = "SELECT * FROM Employees WHERE ID_Employee = ?";
    
    try {
        
        CRUD.setConnection(ConexionDB.getConexion());

       
        ResultSet rs = CRUD.queryDB(query, idEmployee);

        if (rs.next()) {
            
            Administrator administrator = new AdministratorBuilder()
                    .setId(rs.getInt("ID_Employee"))
                    .setname(rs.getString("Name"))
                    .setIdCard(rs.getString("ID_Card"))
                    .setAddress(rs.getString("Address"))
                    .setPhoneNumber(rs.getString("Phone_Number"))
                    .setEmail(rs.getString("Email"))
                    .setusername(rs.getString("username"))
                    .setPasswordU(rs.getString("passwordU"))
                    .setHireDate(rs.getDate("HireDate").toLocalDate())
                    .setState(rs.getBoolean("State"))
                    .setIdPosition(rs.getInt("ID_Position"))
                    .build();
            rs.close();
            return administrator;
        }
    } catch (SQLException e) {
        System.out.println("Error getting administrator: " + e.getMessage());
        CRUD.rollbackDB();
        throw e;
    } finally {
        CRUD.closeConnection();
    }
    return null;
}


public static List<Administrator> listAdministrators() throws SQLException {
    String query = "SELECT * FROM Employees";
    List<Administrator> administratorsList = new ArrayList<>();
    
    try {
        
        CRUD.setConnection(ConexionDB.getConexion());

       
        ResultSet rs = CRUD.queryDB(query);

        while (rs.next()) {
            
            Administrator administrator = new AdministratorBuilder()
                    .setId(rs.getInt("ID_Employee"))
                    .setname(rs.getString("Name"))
                    .setIdCard(rs.getString("ID_Card"))
                    .setAddress(rs.getString("Address"))
                    .setPhoneNumber(rs.getString("Phone_Number"))
                    .setEmail(rs.getString("Email"))
                    .setusername(rs.getString("username"))
                    .setPasswordU(rs.getString("passwordU"))
                    .setHireDate(rs.getDate("HireDate").toLocalDate())
                    .setState(rs.getBoolean("State"))
                    .setIdPosition(rs.getInt("ID_Position"))
                    .build();
            administratorsList.add(administrator);
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error listing administrators: " + e.getMessage());
        CRUD.rollbackDB();
        throw e;
    } finally {
        CRUD.closeConnection();
    }
    return administratorsList;
}
}
