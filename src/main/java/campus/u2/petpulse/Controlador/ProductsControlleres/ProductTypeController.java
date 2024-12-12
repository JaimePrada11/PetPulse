package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.ProductType;
import campus.u2.petpulse.Clases.Products.Category;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeController {

    // Register a new product type
    public static boolean registerProductType(Integer id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "INSERT INTO ProductsTypes (Name) "
                + "VALUES ('" + name + ");";
        return CRUD.executeCommit(query);
    }

    // Update an existing product type
    public static boolean updateProductType(int id, String name, int categoryId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "UPDATE ProductsTypes SET Name='" + name + " WHERE ID_Products_Types=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Delete a product type by its ID
    public static boolean deleteProductType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM ProductsTypes WHERE ID_ProductsTypes=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Get a product type by its ID
    public static ProductType getProductType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM ProductsTypes WHERE ID_ProductsTypes=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        ProductType productType = new ProductType();
        try {
            if (rs.next()) {
                productType.setIdProductType(rs.getInt("ID_ProductsTypes"));
                productType.setName(rs.getString("Name"));

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return productType;
    }

    // List all product types
    public static List<ProductType> listProductTypes() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<ProductType> productTypeList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ProductsTypes";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                ProductType productType = new ProductType();
                productType.setIdProductType(rs.getInt("ID_ProductsTypes"));
                productType.setName(rs.getString("Name"));

                productTypeList.add(productType);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return productTypeList;
    }
}
