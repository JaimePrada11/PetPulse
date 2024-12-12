
package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Clases.Services.*;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ConsultationController {

    public static boolean registerConsultation(Integer IDService, String reason, String diagnosis, String recommendations, LocalDate consultationDate) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Consultation consultation = new Consultation(IDService, reason, diagnosis, recommendations, consultationDate);
        
       String consultationQuery = "INSERT INTO Consultation (ID_Service, Reason, Diagnosis, Recommendations, consultationDate) " 
        + "VALUES (" + consultation.getIDService() + ", '" + consultation.getReason() + "', '" + consultation.getDiagnosis() 
               + "', '" + consultation.getRecommendations() + "', '" + consultation.getConsultationDate() + "')";

        return CRUD.executeCommit(consultationQuery);
    }

    public static boolean updateConsultation(int idService, String reason, String diagnosis, String recommendations, LocalDate consultationDate) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        
        Consultation consultation = new Consultation(idService, reason, diagnosis, recommendations, consultationDate);

        String query = "UPDATE Consultation SET Reason = '" + reason + "', Diagnosis = '" + diagnosis + "', Recommendations = '" + recommendations + "', consultationDate = '" + consultationDate + "' WHERE ID_Service = " + idService + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteConsultation(int serviceId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Consultation WHERE ID_Service=?";
        return CRUD.deleteFromDB(query, serviceId);
    }

    public static Consultation getConsultation(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Consultation WHERE ID_Service=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Consultation consultation = new Consultation();
        try {
            if (rs.next()) {
                consultation.setIDService(rs.getInt("ID_Service"));
                consultation.setReason(rs.getString("Reason"));
                consultation.setDiagnosis(rs.getString("Diagnosis"));
                consultation.setRecommendations(rs.getString("Recommendations"));
                consultation.setConsultationDate(rs.getDate("consultationDate").toLocalDate());

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return consultation;
    }

    public static List<Consultation> listConsultations() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Consultation> consultationsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Consultation";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Consultation consultation = new Consultation();
                consultation.setIDService(rs.getInt("ID_Service"));
                consultation.setReason(rs.getString("Reason"));
                consultation.setDiagnosis(rs.getString("Diagnosis"));
                consultation.setRecommendations(rs.getString("Recommendations"));
                consultation.setConsultationDate(rs.getDate("consultationDate").toLocalDate());

                consultationsList.add(consultation);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return consultationsList;
    }
}

