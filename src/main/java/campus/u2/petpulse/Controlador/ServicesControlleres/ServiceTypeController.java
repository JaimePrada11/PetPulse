
package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Persistencia.CRUD;
import java.sql.SQLException;
import campus.u2.petpulse.Clases.Services.*;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ServiceTypeController {

    public static boolean registerServiceType(String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        ServiceType servicetype = new ServiceType(name);
        String query = "INSERT INTO serviceTypes (Name) VALUES ('" + servicetype.getName() + "');";
        return CRUD.executeCommit(query);
    }

    public static boolean updateServiceType(int id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        ServiceType servicetype = new ServiceType(id, name);
        String query = "UPDATE serviceTypes SET Name='" + servicetype.getName() + "' WHERE ID_ServiceType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static boolean deleteServiceType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM serviceTypes WHERE ID_ServiceType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static ServiceType getServiceType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM serviceTypes WHERE ID_ServiceType=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        ServiceType serviceType = new ServiceType();
        try {
            if (rs.next()) {
                serviceType.setIdServiceType(rs.getInt("ID_ServiceType"));
                serviceType.setName(rs.getString("Name"));
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return serviceType;
    }

    public static List<ServiceType> listServiceTypes() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM serviceTypes";
            ResultSet rs = CRUD.queryDB(sql);
            while (rs.next()) {
                ServiceType serviceType = new ServiceType();
                serviceType.setIdServiceType(rs.getInt("ID_ServiceType"));
                serviceType.setName(rs.getString("Name"));
                serviceTypeList.add(serviceType);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }
        return serviceTypeList;
    }
}
