
package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.MaterialType;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MaterialTypeController {

    // Register a new material type
    public static boolean registerMaterialType(String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "INSERT INTO MaterialTypes (Name) "
                + "VALUES ('" + name + ");";
        return CRUD.executeCommit(query);
    }

    // Update an existing material type
    public static boolean updateMaterialType(int id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "UPDATE MaterialTypes SET Name='" + name 
                + "' WHERE ID_MaterialType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Delete a material type by its ID
    public static boolean deleteMaterialType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM MaterialTypes WHERE ID_MaterialType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Get a material type by its ID
    public static MaterialType getMaterialType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM MaterialTypes WHERE ID_MaterialType=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        MaterialType mt1 = new MaterialType();
        try {
            if (rs.next()) {
                mt1.setMaterialType(rs.getInt("ID_MaterialType"));
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
    public static List<MaterialType> listMaterialTypes() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<MaterialType> materialTypeList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MaterialTypes";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                MaterialType p1 = new MaterialType();
                p1.setMaterialType(rs.getInt("ID_MaterialType"));
                p1.setName(rs.getString("Name"));
                materialTypeList.add(p1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return materialTypeList;
    }
}
