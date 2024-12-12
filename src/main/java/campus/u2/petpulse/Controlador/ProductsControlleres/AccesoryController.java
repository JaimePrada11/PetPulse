
package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.Accesory;
import campus.u2.petpulse.Clases.Products.AccesoryType;
import campus.u2.petpulse.Clases.Products.MaterialType;
import campus.u2.petpulse.Clases.Products.SpecialFactory;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccesoryController {
    
    public static boolean registerAccessory(Integer idProduct, MaterialType materialType, String dimensions, AccesoryType accesoryType)  throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        SpecialFactory factory = new SpecialFactory();

        Accesory accesory = factory.createAccesory(idProduct, materialType, dimensions, accesoryType);


        String Query = "INSERT INTO Accessory (ID_Product, ID_MaterialType, dimensions, ID_AccessoryType) "
                + "VALUES (" + accesory.getIdProduct() + ", " + accesory.getMaterialType().getMaterialType() + ", '" 
                + accesory.getDimensions() + "', '"  + accesory.getAccesoryType().getIdAccesoryType() + "');";


        return CRUD.executeCommit(Query);
    }

    public static boolean updateAccessory(Integer idProduct, MaterialType materialType, String dimensions, AccesoryType accesoryType) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        SpecialFactory factory = new SpecialFactory();

        Accesory accesory = factory.createAccesory(idProduct, materialType, dimensions, accesoryType);


        String query = "UPDATE Accessory  SET " + "ID_MaterialType = " + accesory.getMaterialType().getMaterialType() + ", " + "dimensions = " + accesory.getDimensions() + ", "
                + "ID_AccessoryType = '" + accesory.getAccesoryType().getIdAccesoryType() + " WHERE ID_Product  = " + accesory.getIdProduct() + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteAccessory(int productId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Accessory  WHERE ID_Product=?";
        return CRUD.deleteFromDB(query, productId);
    }

    public static Accesory getAccessory(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Accessory WHERE ID_Product=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Accesory accesory = new Accesory();
        try {
            if (rs.next()) {
                accesory.setIdProduct(rs.getInt("ID_Product"));
                
                int type = rs.getInt("ID_MaterialType");
                MaterialType mt = new MaterialType(type);
                accesory.setMaterialType(mt);
                
                accesory.setDimensions(rs.getString("dimensions"));
                
                int accesorytype = rs.getInt("ID_AccessoryType");
                AccesoryType at = new AccesoryType(accesorytype);
                accesory.setAccesoryType(at);

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return accesory;
    }

    public static List<Accesory> listAccessory() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Accesory> AccesoryList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Accessory";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Accesory accesory = new Accesory();
                
                accesory.setIdProduct(rs.getInt("ID_Product"));
                
                int type = rs.getInt("ID_MaterialType");
                MaterialType mt = new MaterialType(type);
                accesory.setMaterialType(mt);
                
                accesory.setDimensions(rs.getString("dimensions"));
                
                int accesorytype = rs.getInt("ID_AccessoryType");
                AccesoryType at = new AccesoryType(accesorytype);
                accesory.setAccesoryType(at);


                AccesoryList.add(accesory);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return AccesoryList;
    }
}
