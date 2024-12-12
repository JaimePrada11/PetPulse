
package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.PetFood;
import campus.u2.petpulse.Clases.Products.SpecialFactory;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodController {

    public static boolean registerFood(Integer ID_Product, double weight, Integer calories, Boolean isOrganic) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        SpecialFactory factory = new SpecialFactory();

        PetFood food = factory.creatFood(ID_Product, weight, calories, isOrganic);

        int organicValue = isOrganic ? 1 : 0;

        String Query = "INSERT INTO PetFoods (ID_Product, weight, calories, isOrganic) "
                + "VALUES (" + food.getID_Product() + ", " + food.getWeight() + ", " + food.getCalories() + ", " + organicValue + ");";

        return CRUD.executeCommit(Query);
    }

    public static boolean updateFood(Integer ID_Product, double weight, Integer calories, Boolean isOrganic) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        SpecialFactory factory = new SpecialFactory();

        PetFood food = factory.creatFood(ID_Product, weight, calories, isOrganic);

        int organicValue = isOrganic ? 1 : 0;

        String query = "UPDATE PetFoods  SET " + "weight = " + food.getWeight() + ", " + "calories = " + food.getCalories() + ", "
                + "isOrganic = '" + organicValue + " WHERE ID_Product  = " + ID_Product + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteFood(int productId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM PetFoods  WHERE ID_Product=?";
        return CRUD.deleteFromDB(query, productId);
    }

    public static PetFood getFood(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM PetFoods WHERE ID_Product=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        PetFood food = new PetFood();
        try {
            if (rs.next()) {
                food.setID_Product(rs.getInt("ID_Product"));
                food.setWeight(rs.getDouble("weight"));
                food.setCalories(rs.getInt("calories"));
                food.setIsOrganic(rs.getBoolean("isOrganic"));

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return food;
    }

    public static List<PetFood> listFood() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<PetFood> foodList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PetFoods";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                PetFood food = new PetFood();
                
                food.setID_Product(rs.getInt("ID_Product"));
                food.setWeight(rs.getDouble("weight"));
                food.setCalories(rs.getInt("calories"));
                food.setIsOrganic(rs.getBoolean("isOrganic"));


                foodList.add(food);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return foodList;
    }
}
