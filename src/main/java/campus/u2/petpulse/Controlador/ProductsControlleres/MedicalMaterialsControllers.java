package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.MaterialType;
import campus.u2.petpulse.Clases.Products.MedicalFactory;
import campus.u2.petpulse.Clases.Products.MedicalMaterial;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalMaterialsControllers {

    public static boolean registerMedicalMaterial(Integer ID_Product, Integer size, MaterialType materialType, boolean reusable) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        MedicalFactory factory = new MedicalFactory();

        MedicalMaterial medicalmaterial = factory.createMedicalMaterial(ID_Product, size, materialType, reusable);

        int reusableValue = reusable ? 1 : 0;

        String medicineQuery = "INSERT INTO MedicalMaterials (ID_Product, Size, ID_MaterialType, reusable) "
                + "VALUES (" + medicalmaterial.getID_Product() + ", " + medicalmaterial.getSize() + ", "
                + medicalmaterial.getMaterialType().getMaterialType() + ", '" + reusableValue + "');";

        return CRUD.executeCommit(medicineQuery);
    }

    public static boolean updateMedicalMaterial(Integer ID_Product, Integer size, MaterialType materialType, boolean reusable) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        MedicalFactory factory = new MedicalFactory();

        MedicalMaterial medicalmaterial = factory.createMedicalMaterial(ID_Product, size, materialType, reusable);

        int resuableValue = reusable ? 1 : 0;

        String query = "UPDATE MedicalMaterials  SET " + "Size = " + medicalmaterial.getSize() + ", " + "ID_MaterialType = " + medicalmaterial.getMaterialType().getMaterialType() + ", "
                + "reusable = '" + resuableValue + " WHERE ID_Product  = " + ID_Product + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteMedicalMaterial(int productId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM MedicalMaterials  WHERE ID_Product=?";
        return CRUD.deleteFromDB(query, productId);
    }

    public static MedicalMaterial getMedicalMaterial(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM MedicalMaterials WHERE ID_Product=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        MedicalMaterial material = new MedicalMaterial();
        try {
            if (rs.next()) {
                material.setID_Product(rs.getInt("ID_Product"));
                material.setSize(rs.getInt("Size"));
                int type = rs.getInt("ID_MaterialType");
                MaterialType mt = new MaterialType(type);
                material.setMaterialType(mt);

                material.setReusable(rs.getBoolean("Reusable"));

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return material;
    }

    public static List<MedicalMaterial> listMedicalMaterial() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<MedicalMaterial> MedicalMaterialList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Medicines";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                MedicalMaterial material = new MedicalMaterial();
                material.setID_Product(rs.getInt("ID_Product"));
                material.setSize(rs.getInt("Size"));
                int type = rs.getInt("ID_MaterialType");
                MaterialType mt = new MaterialType(type);
                material.setMaterialType(mt);

                material.setReusable(rs.getBoolean("Reusable"));

                MedicalMaterialList.add(material);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return MedicalMaterialList;
    }
}
