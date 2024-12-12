
package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.Vaccination;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class VaccinationController {
    
    
    public static boolean registerVaccination(int idService, LocalDate ApplicationDate, LocalDate NextDoseDate) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        
        Vaccination vaccination = new Vaccination(idService,ApplicationDate, NextDoseDate);
       String consultationQuery = "INSERT INTO Vaccination (ID_Service, ApplicationDate, NextDoseDate) " 
        + "VALUES (" + vaccination.getIdService() + ", '" + vaccination.getApplicationDate() + "', '" + vaccination.getNextDoseDate() + "')";

        return CRUD.executeCommit(consultationQuery);
    }

    public static boolean updateVaccination(int idService, LocalDate ApplicationDate, LocalDate NextDoseDate) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        Vaccination vaccination = new Vaccination(idService,ApplicationDate, NextDoseDate);

        String query = "UPDATE Vaccination SET ApplicationDate = '" + vaccination.getApplicationDate() 
                + "', NextDoseDate = '" + vaccination.getNextDoseDate()  + "' WHERE ID_Service = " + idService + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteVaccination(int serviceId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Vaccination WHERE ID_Service=?";
        return CRUD.deleteFromDB(query, serviceId);
    }

    public static Vaccination getVaccination(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Vaccination WHERE ID_Service=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Vaccination vaccination = new Vaccination();
        try {
            if (rs.next()) {
                vaccination.setIdService(rs.getInt("ID_Service"));
                vaccination.setApplicationDate(rs.getDate("ApplicationDate").toLocalDate());
                vaccination.setNextDoseDate(rs.getDate("NextDoseDate").toLocalDate());

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return vaccination;
    }

    public static List<Vaccination> listVaccination() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Vaccination> VaccinationsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Vaccination";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Vaccination vaccination = new Vaccination();
                vaccination.setIdService(rs.getInt("ID_Service"));
                vaccination.setApplicationDate(rs.getDate("ApplicationDate").toLocalDate());
                vaccination.setNextDoseDate(rs.getDate("NextDoseDate").toLocalDate());

                VaccinationsList.add(vaccination);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return VaccinationsList;
    }
    
}
