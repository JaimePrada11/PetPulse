package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Persistencia.CRUD;
import java.sql.SQLException;
import campus.u2.petpulse.Clases.Services.*;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServiceController {

    public static boolean registerService(String name, String description, Double price, Integer points, ServiceType serviceType) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        Service service = new Service(name, description, price, points, serviceType);
        String query = "INSERT INTO Services (Name, Description, Price, Points, ID_ServiceType) "
                + "VALUES ('" + service.getName() + "', '" + service.getDescription() + "', " + service.getPrice() + ", " + service.getPoints() + ", " + service.getServiceType().getIdServiceType() + ");";

        return CRUD.executeCommit(query);
    }

    public static boolean updateService(int id, String name, String description, double price, int points, ServiceType serviceTypeId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        Service service = new Service(id, name, description, price, points, serviceTypeId);
        String query = "UPDATE Services SET Name='" + service.getName() + "', Description='" + service.getDescription() + "', Price=" + service.getPrice()
                + ", Points=" + service.getPoints() + ", ID_ServiceType=" + service.getServiceType().getIdServiceType() + " WHERE ID_Service=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static boolean deleteService(Integer id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Services WHERE ID_Service=" + id + ";";
        
        return CRUD.executeCommit(query);
    }

    public static Service getService(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Services WHERE ID_Service = ?;";
        ResultSet rs = CRUD.queryDB(sql, id);
        Service service = new Service();
        try {
            if (rs.next()) {
                service.setID_Service(rs.getInt("ID_Service"));
                service.setName(rs.getString("Name"));
                service.setDescription(rs.getString("Description"));
                service.setPrice(rs.getDouble("Price"));
                service.setPoints(rs.getInt("Points"));
                
                int serviceTypeId = rs.getInt("ID_ServiceType");
                ServiceType serviceType = new ServiceType(serviceTypeId);
                service.setServiceType(serviceType);
                
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return service;
    }

    public static List<Service> listServices() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT s.*, st.Name as ServiceTypeName FROM Services s " +
                     "JOIN serviceTypes st ON s.ID_ServiceType = st.ID_ServiceType";
        ResultSet rs = CRUD.queryDB(sql);
        List<Service> serviceList = new ArrayList<>();

        while (rs.next()) {
            Service service = new Service();
            service.setID_Service(rs.getInt("ID_Service"));
            service.setName(rs.getString("Name"));
            service.setDescription(rs.getString("Description"));
            service.setPrice(rs.getDouble("Price"));
            service.setPoints(rs.getInt("Points"));

            ServiceType serviceType = new ServiceType();
            serviceType.setIdServiceType(rs.getInt("ID_ServiceType"));
            serviceType.setName(rs.getString("ServiceTypeName"));
            service.setServiceType(serviceType);

            serviceList.add(service);
        }
        CRUD.closeConnection();
        return serviceList;
    }
    
    public static int getLastServiceID() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "SELECT MAX(ID_Service) AS last_id FROM Services;";
        
        ResultSet rs = CRUD.queryDB(query);
        int lastId = -1;
        
        try {
            if (rs.next()) {
                lastId = rs.getInt("last_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            CRUD.closeConnection();
        }
        
        return lastId;
    }
}
