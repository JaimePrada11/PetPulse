package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.MedicalFactory;
import campus.u2.petpulse.Clases.Services.Procedure;
import campus.u2.petpulse.Clases.Services.PostOperatory;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostOperativeController {

    public static boolean registerPostOperatory(Integer idService, LocalDate nextControlAppointments, Procedure procedure, String recoveryStatus, String postOpCareInstructions) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        PostOperatory pos = new PostOperatory(idService, nextControlAppointments, procedure, recoveryStatus, postOpCareInstructions);
        String query = "INSERT INTO PostOperative (ID_Procedure, nextControlAppointments, Recovery"
                + "Status, postOpCareInstructions) "
                + "VALUES (" + pos.getIdService() + ", '" + pos.getNextControlAppointments() + "', '" + pos.getProcedure().getID_Service() + "', '"
                + pos.getRecoveryStatus() + "', '" + pos.getPostOpCareInstructions() + "');";

        return CRUD.executeCommit(query);
    }


    public static boolean updatePostOperatory(int id, LocalDate nextControlAppointments, Procedure procedure, String recoveryStatus, String postOpCareInstructions) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        PostOperatory pos = new PostOperatory(id, nextControlAppointments, procedure, recoveryStatus, postOpCareInstructions);

        String query = "UPDATE PostOperative SET nextControlAppointments='" + pos.getNextControlAppointments()
                + "', RecoveryStatus = '" + pos.getRecoveryStatus() + "', postOpCareInstructions = '" + pos.getPostOpCareInstructions()
                + "' WHERE ID_Procedure=" + pos.getIdService() + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deletePostOperatory(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM PostOperative WHERE ID_Procedure=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static PostOperatory getPostOperatory(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM PostOperative WHERE ID_Procedure=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        PostOperatory PostOperatory = new PostOperatory();
        try {
            if (rs.next()) {
                PostOperatory.setIdService(rs.getInt("ID_Procedure"));
                PostOperatory.setNextControlAppointments(rs.getDate("nextControlAppointments").toLocalDate());
                PostOperatory.setRecoveryStatus(rs.getString("RecoveryStatus"));
                PostOperatory.setPostOpCareInstructions(rs.getString("postOpCareInstructions"));
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return PostOperatory;
    }

    public static List<PostOperatory> listPostOperatory() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<PostOperatory> TypeProceduresList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PostOperative";
            ResultSet rs = CRUD.queryDB(sql);
            while (rs.next()) {
                PostOperatory PostOperatory = new PostOperatory();
                PostOperatory.setIdService(rs.getInt("ID_Procedure"));
                PostOperatory.setNextControlAppointments(rs.getDate("nextControlAppointments").toLocalDate());
                PostOperatory.setRecoveryStatus(rs.getString("RecoveryStatus"));
                PostOperatory.setPostOpCareInstructions(rs.getString("postOpCareInstructions"));
                TypeProceduresList.add(PostOperatory);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }
        return TypeProceduresList;
    }

}
