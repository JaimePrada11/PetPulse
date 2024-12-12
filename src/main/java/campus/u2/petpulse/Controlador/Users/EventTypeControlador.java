
package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EventTypeControlador {
    
    // Metodo para insertar un nuevo tipo de evento
    public static boolean insertEventType(String name) {
        String query = "INSERT INTO EventTypes (Name) VALUES (?)";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            boolean result = CRUD.insertIntoDB(query, name);
            return result;
        } catch (SQLException e) {
            System.out.println("Error al insertar tipo de evento: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Metodo para actualizar el nombre de un tipo de evento
    public static boolean updateEventType(int idEventType, String newName) {
        String query = "UPDATE EventTypes SET Name = ? WHERE ID_EventType = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            boolean result = CRUD.updateInDB(query, newName, idEventType);
            return result;
        } catch (SQLException e) {
            System.out.println("Error al actualizar tipo de evento: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Metodo para eliminar un tipo de evento
    public static boolean deleteEventType(int idEventType) {
        String query = "DELETE FROM EventTypes WHERE ID_EventType = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            boolean result = CRUD.deleteFromDB(query, idEventType);
            return result;
        } catch (SQLException e) {
            System.out.println("Error al eliminar tipo de evento: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Metodo para obtener un tipo de evento por su ID
    public static String getEventTypeById(int idEventType) {
        String query = "SELECT Name FROM EventTypes WHERE ID_EventType = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idEventType);
            if (rs.next()) {
                return rs.getString("Name");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener tipo de evento: " + e.getMessage());
        } finally {
            CRUD.rollbackDB();
        }
        return null;
    }

    // Metodo para listar todos los tipos de eventos
    public static List<String> listAllEventTypes() {
        String query = "SELECT Name FROM EventTypes";
        List<String> eventTypes = new ArrayList<>();
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);
            while (rs.next()) {
                eventTypes.add(rs.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar tipos de eventos: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }
        return eventTypes;
    }
    
    
}
