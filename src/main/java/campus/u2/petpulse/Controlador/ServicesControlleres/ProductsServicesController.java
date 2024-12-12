
package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Products.Product;
import campus.u2.petpulse.Clases.Services.Service;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductsServicesController {

    public static boolean registerProductService(int idProduct, int idService) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        
        String query = "INSERT INTO ProductService (ID_Product, ID_Service) "
                + "VALUES ('" + idProduct + "', '" + idService + ");";
        
        return CRUD.executeCommit(query);
    }

    public static boolean deleteProductService(int idProduct, int idService) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        
        String query = "DELETE FROM ProductsServices WHERE ID_Product = ? AND ID_Service = ?";
        
        return CRUD.executeCommit(query);
    }


    public static List<Service> getServicesByProduct(int idProduct) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        
        List<Service> serviceList = new ArrayList<>();
        
        String query = "SELECT s.* FROM Services s "
                     + "INNER JOIN ProductsServices ps ON s.ID_Service = ps.ID_Service "
                     + "WHERE ps.ID_Product = ?";
        
        try (ResultSet rs = CRUD.queryDB(query, idProduct)) {
            while (rs.next()) {
                Service service = new Service();
                service.setID_Service(rs.getInt("ID_Service"));
                service.setName(rs.getString("Name"));
                service.setDescription(rs.getString("Description"));
                service.setPrice(rs.getDouble("Price"));
                service.setPoints(rs.getInt("Points"));
                
                serviceList.add(service);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsServicesController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CRUD.closeConnection();
        }
        
        return serviceList;
    }

    public static List<Product> getProductsByService(int idService) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Product> productList = new ArrayList<>();
        
        String query = "SELECT p.* FROM Products p "
                     + "INNER JOIN ProductsServices ps ON p.ID_Product = ps.ID_Product "
                     + "WHERE ps.ID_Service = ?";
        
        try (ResultSet rs = CRUD.queryDB(query, idService)) {
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getInt("ID_Product"));
                product.setName(rs.getString("Name"));
                product.setSKU(rs.getString("SKU"));
                product.setBatch(rs.getString("SKU"));
                product.setEntryDate(rs.getDate("EntryDate").toLocalDate());
                product.setDueDate(rs.getDate("DueDate").toLocalDate());
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductsServicesController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CRUD.closeConnection();
        }
        
        return productList;
    }
}


