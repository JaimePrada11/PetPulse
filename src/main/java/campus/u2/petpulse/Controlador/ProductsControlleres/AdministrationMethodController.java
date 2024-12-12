
package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.AdministrationMethod;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdministrationMethodController {
    
    public static boolean registerAdministrationMethod(String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "INSERT INTO AdministrationMethods (Name) "
                + "VALUES ('" + name + "');";
        return CRUD.executeCommit(query);
    }

    public static boolean updateAdministrationMethod(int id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "UPDATE AdministrationMethods SET Name='" + name 
                + " WHERE ID_AdministrationMethod=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static boolean deleteAdministrationMethod(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM AdministrationMethods WHERE ID_AdministrationMethod=" + id + ";";
        return CRUD.executeCommit(query);
    }

    public static AdministrationMethod getAdministrationMethod(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM AdministrationMethods WHERE ID_AdministrationMethod=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        AdministrationMethod administrationMethod = new AdministrationMethod();
        try {
            if (rs.next()) {
                administrationMethod.setIdAdministrationMethod(rs.getInt("ID_AdministrationMethod"));
                administrationMethod.setName(rs.getString("Name"));
                
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return administrationMethod;
    }

    public static List<AdministrationMethod> listAdministrationMethod() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<AdministrationMethod> AdministrationMethodList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM AdministrationMethods";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                AdministrationMethod administrationMethod = new AdministrationMethod();
                administrationMethod.setIdAdministrationMethod(rs.getInt("ID_AdministrationMethod"));
                administrationMethod.setName(rs.getString("Name"));


                AdministrationMethodList.add(administrationMethod);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return AdministrationMethodList;
    }
    
    public static int getLastAdministrationMethodID() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "SELECT MAX(ID_AdministrationMethod) AS last_id FROM AdministrationMethods;";
        
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
