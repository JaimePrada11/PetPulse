


package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Clases.Events.VaccinationEvent;
import campus.u2.petpulse.Clases.Events.VaccinationEventBuilder;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

public class EventControlator {

    // Método para registrar un evento
    public static boolean registerEvent(String name, LocalDate startDate, LocalDate endDate, String location, Integer idEventType) {
        String query = "INSERT INTO Events(Name, StartDate, EndDate, Location, ID_EventType) VALUES(?,?,?,?,?)";
        
        // Crear el evento usando el builder
        VaccinationEvent event = new VaccinationEventBuilder()
            .setName(name)
            .setStarDate(startDate)
            .setEndDate(endDate)
            .setLocation(location)
            .setIdEventType(idEventType)
            .build();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                // Insertar el evento en la base de datos
                boolean result = CRUD.insertIntoDB(query, event.getName(), event.getStarDate(), event.getEndDate(), event.getLocation(), event.getID_EventType());
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

    // Método para actualizar un evento
    public static boolean updateEvent(Integer idEvent, String name, LocalDate startDate, LocalDate endDate, String location, Integer idEventType) throws SQLException {
        String query = "UPDATE Events SET Name = ?, StartDate = ?, EndDate = ?, Location = ?, ID_EventType = ? WHERE ID_Event = ?";
        
        // Crear el evento con el builder
        VaccinationEvent event = new VaccinationEventBuilder()
            .setId(idEvent)
            .setName(name)
            .setStarDate(startDate)
            .setEndDate(endDate)
            .setLocation(location)
            .setIdEventType(idEventType)
            .build();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, event.getName(), event.getStarDate(), event.getEndDate(), event.getLocation(), event.getID_EventType(), event.getId());
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

    // Método para eliminar un evento
    public static boolean deleteEvent(Integer idEvent) throws SQLException {
        String query = "DELETE FROM Events WHERE ID_Event = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idEvent);
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

    // Método para obtener un evento por su ID
    public static VaccinationEvent getEventById(int idEvent) throws SQLException {
        String query = "SELECT * FROM Events WHERE ID_Event = ?";
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idEvent);

            if (rs.next()) {
                VaccinationEvent event = new VaccinationEventBuilder()
                        .setId(rs.getInt("ID_Event"))
                        .setName(rs.getString("Name"))
                        .setStarDate(rs.getDate("StartDate").toLocalDate())
                        .setEndDate(rs.getDate("EndDate").toLocalDate())
                        .setLocation(rs.getString("Location"))
                        .setIdEventType(rs.getInt("ID_EventType"))
                        .build();
                rs.close();
                return event;
            }
        } catch (SQLException e) {
            System.out.println("Error getting event: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    // Método para listar todos los eventos
    public static List<VaccinationEvent> listEvents() throws SQLException {
        String query = "SELECT * FROM Events";
        List<VaccinationEvent> eventsList = new ArrayList<>();
        
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                VaccinationEvent event = new VaccinationEventBuilder()
                        .setId(rs.getInt("ID_Event"))
                        .setName(rs.getString("Name"))
                        .setStarDate(rs.getDate("StartDate").toLocalDate())
                        .setEndDate(rs.getDate("EndDate").toLocalDate())
                        .setLocation(rs.getString("Location"))
                        .setIdEventType(rs.getInt("ID_EventType"))
                        .build();
                eventsList.add(event);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error listing events: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return eventsList;
    }
}
