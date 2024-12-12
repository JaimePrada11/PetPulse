package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import campus.u2.petpulse.Clases.Users.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianControlador {

    
    // Insert a Veterinarian (Employee)
    public static boolean insertVeterinarian(Veterinarian veterinarian) {
        String query = "INSERT INTO Employees(Name, ID_Card, Address, Phone_Number, Email, HireDate, State, ID_Position, username, password) " +
                       "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, veterinarian.getName(), veterinarian.getId_Card(), veterinarian.getAddress(),
                        veterinarian.getPhone_Number(), veterinarian.getEmail(), veterinarian.getHireDate(), veterinarian.getState(),
                        veterinarian.getId_Position(), veterinarian.getUsername(), veterinarian.getPasswordU());
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

    // Update a Veterinarian (Employee)
    public static boolean updateVeterinarian(Veterinarian veterinarian) throws SQLException {
        String query = "UPDATE Employees SET Name = ?, ID_Card = ?, Address = ?, Phone_Number = ?, Email = ?, HireDate = ?, State = ?, ID_Position = ?, username = ?, password = ? " +
                       "WHERE ID_Employee = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, veterinarian.getName(), veterinarian.getId_Card(), veterinarian.getAddress(),
                        veterinarian.getPhone_Number(), veterinarian.getEmail(), veterinarian.getHireDate(), veterinarian.getState(),
                        veterinarian.getId_Position(), veterinarian.getUsername(), veterinarian.getPasswordU(), veterinarian.getId());
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

    // Delete a Veterinarian (Employee)
    public static boolean deleteVeterinarian(int idEmployee) throws SQLException {
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
            System.out.println("Error en la operación de eliminación: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Get a Veterinarian (Employee) by ID
    public static Veterinarian getVeterinarianById(int idEmployee) throws SQLException {
        String query = "SELECT * FROM Employees WHERE ID_Employee = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idEmployee);

            if (rs.next()) {
                Veterinarian veterinarian = new Veterinarian(
                        rs.getInt("ID_Employee"),
                        rs.getString("Name"),
                        rs.getString("ID_Card"),
                        rs.getString("Address"),
                        rs.getString("Phone_Number"),
                        rs.getString("Email"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                veterinarian.setHireDate(rs.getDate("HireDate").toLocalDate());
                veterinarian.setState(rs.getBoolean("State"));
                veterinarian.setIdPosition(rs.getInt("ID_Position"));
                rs.close();
                return veterinarian;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el veterinario: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return null;
    }

    // List all Veterinarians (Employees)
    public static List<Veterinarian> listVeterinarians() throws SQLException {
        String query = "SELECT * FROM Employees";
        List<Veterinarian> veterinariansList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                Veterinarian veterinarian = new Veterinarian(
                        rs.getInt("ID_Employee"),
                        rs.getString("Name"),
                        rs.getString("ID_Card"),
                        rs.getString("Address"),
                        rs.getString("Phone_Number"),
                        rs.getString("Email"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                veterinarian.setHireDate(rs.getDate("HireDate").toLocalDate());
                veterinarian.setState(rs.getBoolean("State"));
                veterinarian.setIdPosition(rs.getInt("ID_Position"));
                veterinariansList.add(veterinarian);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los veterinarios: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return veterinariansList;
    }
    
    
    public static Veterinarian getVeterinarianByIdCard(String idCard) throws SQLException {
    String query = "SELECT * FROM Employees WHERE ID_Card = ?";

    try {
        CRUD.setConnection(ConexionDB.getConexion());
        ResultSet rs = CRUD.queryDB(query, idCard);

        if (rs.next()) {
            Veterinarian veterinarian = new Veterinarian(
                    rs.getInt("ID_Employee"),
                    rs.getString("Name"),
                    rs.getString("ID_Card"),
                    rs.getString("Address"),
                    rs.getString("Phone_Number"),
                    rs.getString("Email"),
                    rs.getString("username"),
                    rs.getString("password")
            );
            veterinarian.setHireDate(rs.getDate("HireDate").toLocalDate());
            veterinarian.setState(rs.getBoolean("State"));
            veterinarian.setIdPosition(rs.getInt("ID_Position"));
            rs.close();
            return veterinarian;
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el veterinario por ID Card: " + e.getMessage());
        CRUD.rollbackDB();
        throw e;
    } finally {
        CRUD.closeConnection();
    }

    return null;
}
}
