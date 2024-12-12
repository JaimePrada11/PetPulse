
package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.AccesoryType;
import campus.u2.petpulse.Clases.Products.MaterialType;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccesoryTypeController {
    
    // Register a new material type
    public static boolean registerAccessoryType(String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "INSERT INTO AccessoriesType (Name) "
                + "VALUES ('" + name + ");";
        return CRUD.executeCommit(query);
    }

    // Update an existing material type
    public static boolean updateAccessoryType(int id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "UPDATE AccessoriesType SET Name='" + name 
                + "' WHERE ID_AccessoryType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Delete a material type by its ID
    public static boolean deleteAccessoryType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM AccessoriesType WHERE ID_AccessoryType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Get a material type by its ID
    public static MaterialType getAccessoryType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM AccessoriesType WHERE ID_AccessoryType=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        MaterialType mt1 = new MaterialType();
        try {
            if (rs.next()) {
                mt1.setMaterialType(rs.getInt("ID_AccessoryType"));
                mt1.setName(rs.getString("Name"));
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return mt1;
    }

    // List all material types
    public static List<AccesoryType> listAccesoryTypes() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<AccesoryType> AccessoryTypeTypeList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AccessoriesType";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                AccesoryType a = new AccesoryType();
                a.setIdAccesoryType(rs.getInt("ID_AccessoryType"));
                a.setName(rs.getString("Name"));
                AccessoryTypeTypeList.add(a);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return AccessoryTypeTypeList;
    }
}
