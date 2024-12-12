package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.TypeProcedure;
import campus.u2.petpulse.Clases.Services.Procedure;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcedureController {

    public static boolean registerProcedure(Integer Id_Service, TypeProcedure procedureTypes, String recoveryTime) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Procedure procedure = new Procedure(Id_Service, procedureTypes, recoveryTime);

        String consultationQuery = "INSERT INTO Procedures (ID_Procedure, RecoveryTime , ID_ProcedureType ) "
                + "VALUES (" + procedure.getID_Service() + ", '" + procedure.getProcedureTypes() + "', '" + procedure.getRecoveryTime() + "')";

        return CRUD.executeCommit(consultationQuery);
    }

    public static boolean updateProcedure(int idService, TypeProcedure procedureTypes, String recoveryTime) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        Procedure procedure = new Procedure(idService, procedureTypes, recoveryTime);

        String query = "UPDATE Procedures SET RecoveryTime = '" + procedure.getRecoveryTime() + "', ID_ProcedureType = '" + procedure.getProcedureTypes() + "' WHERE ID_Procedure = " + idService + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteProcedure(int serviceId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Procedures WHERE ID_Procedure=?";
        return CRUD.deleteFromDB(query, serviceId);
    }

    public static Procedure getProcedure(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Procedures  WHERE ID_Procedure=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Procedure procedure = new Procedure();
        try {
            if (rs.next()) {
                procedure.setID_Service(rs.getInt("ID_Procedure"));
                procedure.setRecoveryTime(rs.getString("RecoveryTime"));

                int type = rs.getInt("ID_ProcedureType");
                TypeProcedure proceduretype = new TypeProcedure(type);
                procedure.setProcedureTypes(proceduretype);
                
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return procedure;
    }

    public static List<Procedure> listProcedure() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Procedure> ProceduresList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Procedures  ";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Procedure procedure = new Procedure();
                procedure.setID_Service(rs.getInt("ID_Procedure"));
                procedure.setRecoveryTime(rs.getString("RecoveryTime"));

                int type = rs.getInt("ID_ProcedureType");
                TypeProcedure proceduretype = new TypeProcedure(type);
                procedure.setProcedureTypes(proceduretype);

                ProceduresList.add(procedure);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return ProceduresList;
    }

}
