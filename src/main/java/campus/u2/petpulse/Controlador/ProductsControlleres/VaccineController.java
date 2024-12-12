package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.AdministrationMethod;
import campus.u2.petpulse.Clases.Products.MedicalFactory;
import campus.u2.petpulse.Clases.Products.Vaccine;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VaccineController {

    public static boolean registerVaccine(Integer ID_Product, Double storageTemperature, AdministrationMethod administrationMethod, Integer numberOfDoses, Integer period) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        MedicalFactory factory = new MedicalFactory();

        Vaccine vaccine = factory.createVaccine(ID_Product, storageTemperature, administrationMethod, numberOfDoses, period);

        String vaccineQuery = "INSERT INTO Vaccines (ID_Product , StorageTemperature, ID_AdministrationMethod, numberOfDoses, period) "
                + "VALUES (" + vaccine.getID_Product() + ", " + vaccine.getStorageTemperature() + ", " + vaccine.getAdministrationMethod().getIdAdministrationMethod() + ", "
                + vaccine.getNumberOfDoses() + ", " + vaccine.getPeriod() + ")";

        return CRUD.executeCommit(vaccineQuery);

    }

    public static boolean updateVaccine(int id, double storageTemperature, AdministrationMethod administrationMethod, int numberOfDoses, int period) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        MedicalFactory factory = new MedicalFactory();

        Vaccine vaccine = factory.createVaccine(id, storageTemperature, administrationMethod, numberOfDoses, period);

        String query = "UPDATE Vaccines SET StorageTemperature = " + vaccine.getStorageTemperature() + ", ID_AdministrationMethod = " + vaccine.getAdministrationMethod().getIdAdministrationMethod()
                + ", numberOfDoses = " + vaccine.getNumberOfDoses() + ", period = " + vaccine.getPeriod() + " WHERE ID_Product  = " + id + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteVaccine(int productId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Vaccines WHERE ID_Product =?";
        return CRUD.deleteFromDB(query, productId);
    }

    public static Vaccine getAdministrationMethod(int id) throws SQLException {

        CRUD.setConnection(ConexionDB.getConexion());

        String sql = "SELECT * FROM Vaccines WHERE ID_Product =" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Vaccine vaccine = new Vaccine();
        try {
            if (rs.next()) {

                vaccine.setID_Product(rs.getInt("ID_Product "));
                vaccine.setStorageTemperature(rs.getDouble("StorageTemperature"));
                int type = rs.getInt("ID_AdministrationMethod");
                AdministrationMethod med = new AdministrationMethod(type);
                vaccine.setAdministrationMethod(med);
                vaccine.setNumberOfDoses(rs.getInt("NumberOfDoses"));
                vaccine.setPeriod(rs.getInt("period"));

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return vaccine;
    }

    public static List<Vaccine> listVaccines() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Vaccine> VaccinesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Vaccines";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Vaccine vaccine = new Vaccine();

                vaccine.setID_Product(rs.getInt("ID_Product "));
                vaccine.setStorageTemperature(rs.getDouble("StorageTemperature"));
                int type = rs.getInt("ID_AdministrationMethod");
                AdministrationMethod med = new AdministrationMethod(type);
                vaccine.setAdministrationMethod(med);
                vaccine.setNumberOfDoses(rs.getInt("NumberOfDoses"));
                vaccine.setPeriod(rs.getInt("period"));

                VaccinesList.add(vaccine);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return VaccinesList;
    }

}
