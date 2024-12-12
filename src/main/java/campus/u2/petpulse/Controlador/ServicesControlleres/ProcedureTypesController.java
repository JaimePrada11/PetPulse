
package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.TypeProcedure;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcedureTypesController {
    
    
    
    public static boolean registerServiceType(String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        TypeProcedure type = new TypeProcedure(name);
        String query = "INSERT INTO ProcedureTypes (Name) VALUES ('" + type.getName() + "');";
        
        return CRUD.executeCommit(query);
    }

    public static boolean updateServiceType(int id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        TypeProcedure type = new TypeProcedure(id, name);

        String query = "UPDATE ProcedureTypes SET Name='" + type.getName() + "' WHERE ID_ProcedureType=" + type.getId() + ";";
        return CRUD.executeCommit(query);
    }

    public static boolean deleteServiceType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM ProcedureTypes WHERE ID_ProcedureType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static TypeProcedure getServiceType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM ProcedureTypes WHERE ID_ServiceType=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        TypeProcedure procedureTypes = new TypeProcedure();
        try {
            if (rs.next()) {
                procedureTypes.setId(rs.getInt("ID_ServiceType"));
                procedureTypes.setName(rs.getString("Name"));
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return procedureTypes;
    }

    public static List<TypeProcedure> listServiceTypes() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<TypeProcedure> TypeProceduresList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ProcedureTypes";
            ResultSet rs = CRUD.queryDB(sql);
            while (rs.next()) {
                TypeProcedure procedureTypes = new TypeProcedure();
                procedureTypes.setId(rs.getInt("ID_ServiceType"));
                procedureTypes.setName(rs.getString("Name"));
                TypeProceduresList.add(procedureTypes);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }
        return TypeProceduresList;
    }
}
