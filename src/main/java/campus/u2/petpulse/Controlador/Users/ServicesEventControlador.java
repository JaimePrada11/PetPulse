package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicesEventControlador {


    // Método para insertar un nuevo registro en ServicesEvent
    public static boolean insertServicesEvent(int idEvent, int idService) {
        String query = "INSERT INTO ServicesEvent(ID_Event, ID_Service) VALUES(?, ?)";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, idEvent, idService);
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

    // Método para actualizar un registro en ServicesEvent
    public static boolean updateServicesEvent(int idEvent, int idService, int newIdEvent, int newIdService) throws SQLException {
        String query = "UPDATE ServicesEvent SET ID_Event = ?, ID_Service = ? WHERE ID_Event = ? AND ID_Service = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, newIdEvent, newIdService, idEvent, idService);
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

    // Método para eliminar un registro de ServicesEvent
    public static boolean deleteServicesEvent(int idEvent, int idService) throws SQLException {
        String query = "DELETE FROM ServicesEvent WHERE ID_Event = ? AND ID_Service = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idEvent, idService);
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

    // Método para obtener un registro de ServicesEvent por ID_Event y ID_Service
    public static boolean getServicesEvent(int idEvent, int idService) throws SQLException {
        String query = "SELECT * FROM ServicesEvent WHERE ID_Event = ? AND ID_Service = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idEvent, idService);

            if (rs.next()) {
                return true; // Registro encontrado
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener ServicesEvent: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return false; // No encontrado
    }

    // Método para listar todos los registros de ServicesEvent
    public static void listServicesEvents() throws SQLException {
        String query = "SELECT * FROM ServicesEvent";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                int idEvent = rs.getInt("ID_Event");
                int idService = rs.getInt("ID_Service");
                System.out.println("ID_Event: " + idEvent + ", ID_Service: " + idService);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar ServicesEvent: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
    }    

}
