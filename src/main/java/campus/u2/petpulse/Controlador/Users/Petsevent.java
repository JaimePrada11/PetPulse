package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Petsevent {

    // Método para insertar un nuevo registro en PetsEvent
    public static boolean insertPetsEvent(int idEvent, int idPet) {
        String query = "INSERT INTO PetsEvent(ID_Event, ID_Pet) VALUES(?, ?)";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, idEvent, idPet);
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

    // Método para actualizar un registro en PetsEvent
    public static boolean updatePetsEvent(int idEvent, int idPet, int newIdEvent, int newIdPet) throws SQLException {
        String query = "UPDATE PetsEvent SET ID_Event = ?, ID_Pet = ? WHERE ID_Event = ? AND ID_Pet = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, newIdEvent, newIdPet, idEvent, idPet);
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

    // Método para eliminar un registro de PetsEvent
    public static boolean deletePetsEvent(int idEvent, int idPet) throws SQLException {
        String query = "DELETE FROM PetsEvent WHERE ID_Event = ? AND ID_Pet = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idEvent, idPet);
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

    // Método para obtener un registro de PetsEvent por ID_Event y ID_Pet
    public static boolean getPetsEvent(int idEvent, int idPet) throws SQLException {
        String query = "SELECT * FROM PetsEvent WHERE ID_Event = ? AND ID_Pet = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idEvent, idPet);

            if (rs.next()) {
                return true; // Registro encontrado
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener PetsEvent: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return false; // No encontrado
    }

    // Método para listar todos los registros de PetsEvent
    public static void listPetsEvents() throws SQLException {
        String query = "SELECT * FROM PetsEvent";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                int idEvent = rs.getInt("ID_Event");
                int idPet = rs.getInt("ID_Pet");
                System.out.println("ID_Event: " + idEvent + ", ID_Pet: " + idPet);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar PetsEvent: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

    }
}
