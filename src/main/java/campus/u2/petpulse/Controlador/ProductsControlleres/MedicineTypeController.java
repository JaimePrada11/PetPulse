package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Clases.Products.MedicineType;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicineTypeController {

    // Register a new category
    public static boolean registerMedicineType(String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "INSERT INTO MedicinesType (Name) "
                + "VALUES ('" + name + "');";

        return CRUD.executeCommit(query);
    }

    // Update an existing category
    public static boolean updateMedicineType(int id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "UPDATE MedicinesType SET Name='" + name + "' WHERE ID_MedicineType=" + id + ";";

        return CRUD.executeCommit(query);
    }

    // Delete a category by its ID
    public static boolean deleteMedicineType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM MedicinesType WHERE ID_MedicineType=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Get a category by its ID
    public static MedicineType getMedicineType(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM MedicinesType WHERE ID_MedicineType=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        MedicineType medicineType = new MedicineType();
        try {
            if (rs.next()) {
                medicineType.setIdMedicineType(rs.getInt("ID_MedicineType"));
                medicineType.setName(rs.getString("Name"));
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return medicineType;
    }

    // List all categories
    public static List<MedicineType> listMedicineType() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<MedicineType> medicineTypeList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM MedicinesType";

            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                MedicineType medicineType = new MedicineType();
                medicineType.setIdMedicineType(rs.getInt("ID_MedicineType"));
                medicineType.setName(rs.getString("Name"));

                medicineTypeList.add(medicineType);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return medicineTypeList;
    }
}
