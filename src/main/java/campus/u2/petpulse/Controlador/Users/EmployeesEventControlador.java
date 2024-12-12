package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesEventControlador {
// Metodo para insertar un nuevo registro en EmployeesEvent
    public static boolean insertEmployeesEvent(int idEvent, int idEmployee) {
        String query = "INSERT INTO EmployeesEvent(ID_Event, ID_Employee) VALUES(?, ?)";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, idEvent, idEmployee);
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

    // Metodo para actualizar un registro en EmployeesEvent
    public static boolean updateEmployeesEvent(int idEvent, int idEmployee) throws SQLException {
        String query = "UPDATE EmployeesEvent SET ID_Event = ?, ID_Employee = ? WHERE ID_Event = ? AND ID_Employee = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, idEvent, idEmployee, idEvent, idEmployee);
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

    // Metodo para eliminar un registro de EmployeesEvent
    public static boolean deleteEmployeesEvent(int idEvent, int idEmployee) throws SQLException {
        String query = "DELETE FROM EmployeesEvent WHERE ID_Event = ? AND ID_Employee = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idEvent, idEmployee);
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

    // Metodo para obtener un registro de EmployeesEvent por ID de evento y empleado
    public static boolean getEmployeesEvent(int idEvent, int idEmployee) throws SQLException {
        String query = "SELECT * FROM EmployeesEvent WHERE ID_Event = ? AND ID_Employee = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idEvent, idEmployee);

            if (rs.next()) {
                return true; // Se encuentra el registro
            }
        } catch (SQLException e) {
            System.out.println("Error getting EmployeesEvent: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return false; // No encontrado
    }

    // Metodo para listar todos los registros de EmployeesEvent
    public static void listEmployeesEvents() throws SQLException {
        String query = "SELECT * FROM EmployeesEvent";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                int idEvent = rs.getInt("ID_Event");
                int idEmployee = rs.getInt("ID_Employee");
                System.out.println("ID_Event: " + idEvent + ", ID_Employee: " + idEmployee);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error listing EmployeesEvent: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
    }
}
