
package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.PreOperatory;
import campus.u2.petpulse.Clases.Services.Procedure;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PreOperativeController {
    
    
    
    public static boolean registerPreOperatory(Integer idService, Procedure procedure, String analysis, LocalDate estimatedTime ) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        PreOperatory pre = new PreOperatory(idService, procedure, analysis, estimatedTime);
        String query = "INSERT INTO Preoperative (ID_Procedure, Analysis, EstimatedTime) "
                 + "VALUES (" + pre.getIdService() + ", '"  + pre.getAnalysis() + "', '" + pre.getEstimatedTime()+  "');";
        
        return CRUD.executeCommit(query);
    }

    public static boolean updatePreOperatory(int id, Procedure procedure, String analysis, LocalDate estimatedTime ) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        PreOperatory pre = new PreOperatory(id, procedure, analysis, estimatedTime);

        String query = "UPDATE Preoperative SET Analysis='" + pre.getAnalysis() +
               "', EstimatedTime = '" + pre.getEstimatedTime() + 
               "' WHERE ID_Procedure=" + pre.getIdService() + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deletePreOperatory(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Preoperative WHERE ID_Procedure=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static PreOperatory getPreOperatory(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Preoperative WHERE ID_Procedure=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        PreOperatory preOperative = new PreOperatory();
        try {
            if (rs.next()) {
                preOperative.setIdService(rs.getInt("ID_Procedure"));
                preOperative.setAnalysis(rs.getString("Analysis"));
                preOperative.setEstimatedTime(rs.getDate("EstimatedTime").toLocalDate());

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return preOperative;
    }

    public static List<PreOperatory> listPreOperatory() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<PreOperatory> PreOperatoryList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Preoperative";
            ResultSet rs = CRUD.queryDB(sql);
            while (rs.next()) {
                PreOperatory preOperative = new PreOperatory();
                preOperative.setIdService(rs.getInt("ID_Procedure"));
                preOperative.setAnalysis(rs.getString("Analysis"));
                preOperative.setEstimatedTime(rs.getDate("EstimatedTime").toLocalDate());
                
                PreOperatoryList.add(preOperative);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }
        return PreOperatoryList;
    }
}
