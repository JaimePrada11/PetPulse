
package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.Training;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class TrainingController {
    
    public static boolean registerBaths(Integer idService, String results, LocalTime durationSession, Integer totalSessions) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        
        
        Training training = new Training(idService, results, durationSession, 0);

       String consultationQuery = "INSERT INTO Training (ID_Service, Results, durationSession, totalSessions ) " 
        + "VALUES (" + training.getIdService() + ", '" + training.getResults()+ "', '" + training.getDurationSession() +   "', '" 
               + training.getTotalSessions() +"')";

        return CRUD.executeCommit(consultationQuery);
    }

    public static boolean updateTraining(Integer idService, String results, LocalTime durationSession, Integer totalSessions) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        Training training = new Training(idService, results, durationSession, 0);

        String query = "UPDATE Training SET Results = '" + training.getResults()+ "', durationSession = '" + training.getDurationSession() 
                + "', totalSessions = '" + training.getTotalSessions() + "' WHERE ID_Service = " + idService + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteTraining(int serviceId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Baths WHERE ID_Service=?";
        return CRUD.deleteFromDB(query, serviceId);
    }

    public static Training getTraining(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Training  WHERE ID_Service=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Training training = new Training();
        try {
            if (rs.next()) {
                training.setIdService(rs.getInt("ID_Service"));
                training.setResults(rs.getString("Results"));
                training.setDurationSession(rs.getTime("durationSession").toLocalTime());
                training.setTotalSessions(rs.getInt("totalSessions"));

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return training;
    }

    public static List<Training> listTraining() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Training> TrainingList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Training";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Training training = new Training();
                training.setIdService(rs.getInt("ID_Service"));
                training.setResults(rs.getString("Results"));
            training.setDurationSession(rs.getTime("durationSession").toLocalTime());
                training.setTotalSessions(rs.getInt("totalSessions"));

                TrainingList.add(training);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return TrainingList;
    }
}
