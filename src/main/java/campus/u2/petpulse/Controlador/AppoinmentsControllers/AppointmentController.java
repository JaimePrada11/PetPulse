package campus.u2.petpulse.Controlador.AppoinmentsControllers;

import campus.u2.petpulse.Clases.Animals.Animal;
import campus.u2.petpulse.Clases.Animals.Dog;
import campus.u2.petpulse.Clases.Appointments.Appointment;
import campus.u2.petpulse.Clases.Appointments.State;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentController {

    public static boolean registerAppointment(Integer idAppointment, LocalDateTime dateAppointment, String reason, State state, Animal mascota) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Appointment appointment = new Appointment(dateAppointment, reason, state, mascota);

        String query = "INSERT INTO Appointments (DateAppointment, Reason, ID_Pet, ID_State) VALUES ('"
                + appointment.getDateAppointment() + "', '" + appointment.getReason() + "', " + appointment.getMascota().getIdPet() + ", "
                + appointment.getState().getIdState() + ");";

        return CRUD.executeCommit(query);
    }

    public static boolean updateAppointment(int id, LocalDateTime dateAppointment, String reason, State state, Animal mascota) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Appointment appointment = new Appointment(id, dateAppointment, reason, state, mascota);

        String query = "UPDATE Appointments SET DateAppointment='" + appointment.getDateAppointment() + "', Reason='"
                + appointment.getReason() + "', ID_Pet=" + appointment.getMascota().getIdPet() + ", ID_State=" + appointment.getState().getIdState()
                + " WHERE ID_Appointment=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static boolean deleteAppointment(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Appointments WHERE ID_Appointment=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Obtener una cita por su ID
    public static Appointment getAppointment(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Appointments WHERE ID_Appointment=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Appointment appointment = new Appointment();
        try {
            if (rs.next()) {
                appointment.setIdAppointment(rs.getInt("ID_Appointment"));
                appointment.setDateAppointment(rs.getTimestamp("DateAppointment").toLocalDateTime());
                appointment.setReason(rs.getString("Reason"));
                
                
                int s = rs.getInt("ID_State");
                State state = new State(s);
                appointment.setState(state);
                
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return appointment;
    }

    // Listar todas las citas
    public static List<Appointment> listAppointments() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Appointment> appointmentList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Appointments";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setIdAppointment(rs.getInt("ID_Appointment"));
                appointment.setDateAppointment(rs.getTimestamp("DateAppointment").toLocalDateTime());
                appointment.setReason(rs.getString("Reason"));
                
                
                int s = rs.getInt("ID_State");
                State state = new State(s);
                appointment.setState(state);
                appointmentList.add(appointment);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return appointmentList;
    }
}
