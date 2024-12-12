package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.MedicalFactory;
import campus.u2.petpulse.Clases.Products.Medicine;
import campus.u2.petpulse.Clases.Products.MedicineType;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineController {

    public static boolean registerMedicine(Integer ID_Product, Integer dosage, boolean prescriptionRequired, String unitofMeasure, Integer quantityPerPackage, String doseInterval, MedicineType medicineType) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        MedicalFactory factory = new MedicalFactory();

        Medicine medicine = factory.createMedicine(ID_Product, dosage, prescriptionRequired, unitofMeasure, quantityPerPackage, doseInterval, medicineType);

        int prescriptionValue = prescriptionRequired ? 1 : 0;

        String medicineQuery = "INSERT INTO Medicines (ID_Product , Dosage, PrescriptionRequired, unitOfMeasure, quantityPerPackage, doseInterval, ID_MedicineType) "
                + "VALUES (" + medicine.getID_Product() + ", " + medicine.getDosage() + ", " + prescriptionValue + ", '" + medicine.getUnitofMeasure() + "', "
                + medicine.getQuantityPerPackage() + ", '" + medicine.getDoseInterval() + "', " + medicine.getMedicineType().getIdMedicineType() + ");";

        return CRUD.executeCommit(medicineQuery);
    }

    public static boolean updateMedicine(Integer ID_Product, Integer dosage, boolean prescriptionRequired, String unitofMeasure, Integer quantityPerPackage, String doseInterval, MedicineType medicineType) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());
        MedicalFactory factory = new MedicalFactory();

        Medicine medicine = factory.createMedicine(ID_Product, dosage, prescriptionRequired, unitofMeasure, quantityPerPackage, doseInterval, medicineType);

        int prescriptionValue = prescriptionRequired ? 1 : 0;

        String query = "UPDATE Medicines SET " + "Dosage = " + medicine.getDosage() + ", " + "PrescriptionRequired = " + prescriptionValue + ", "
                + "unitOfMeasure = '" + medicine.getUnitofMeasure() + "', " + "quantityPerPackage = " + medicine.getQuantityPerPackage() + ", "
                + "doseInterval = '" + medicine.getDoseInterval() + "', " + "ID_MedicineType = " + medicine.getMedicineType().getIdMedicineType() + ", "
                + " WHERE ID_Product  = " + ID_Product + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteMedicine(int productId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Medicines WHERE ID_Product =?";
        return CRUD.deleteFromDB(query, productId);
    }

    public static Medicine getMedicine(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Medicines WHERE ID_Product =" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Medicine medicine = new Medicine();
        try {
            if (rs.next()) {
                medicine.setID_Product(rs.getInt("ID_Product"));
                medicine.setDosage(rs.getInt("Dosage"));
                medicine.setPrescriptionRequired(rs.getBoolean("PrescriptionRequired"));
                medicine.setUnitofMeasure(rs.getString("unitofMeasure"));
                medicine.setQuantityPerPackage(rs.getInt("quantityPerPackage"));
                medicine.setDoseInterval(rs.getString("doseInterval"));
//                medicine.setMedicineType(rs.getInt("ID_MedicineType"));
//                
                int type = rs.getInt("ID_ProcedureType");
                MedicineType med = new MedicineType(type);
                medicine.setMedicineType(med);

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return medicine;
    }

    public static List<Medicine> listMedicines() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Medicine> MedicineList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Medicines";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setID_Product(rs.getInt("ID_Product"));
                medicine.setDosage(rs.getInt("Dosage"));
                medicine.setPrescriptionRequired(rs.getBoolean("PrescriptionRequired"));
                medicine.setUnitofMeasure(rs.getString("unitofMeasure"));
                medicine.setQuantityPerPackage(rs.getInt("quantityPerPackage"));
                medicine.setDoseInterval(rs.getString("doseInterval"));
//                medicine.setMedicineType(rs.getInt("ID_MedicineType"));

                MedicineList.add(medicine);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return MedicineList;
    }

}
