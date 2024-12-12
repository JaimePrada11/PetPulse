package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.Baths;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BathsController {

    public static boolean registerBaths(Integer idService, String haircutStyle, boolean nailTrimmingIncluded) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Baths bath = new Baths(idService, haircutStyle, nailTrimmingIncluded);

        int nail = bath.isNailTrimmingIncluded() ? 1 : 0;

        String consultationQuery = "INSERT INTO Baths (ID_Service, haircutStyle, nailTrimmingIncluded) "
                + "VALUES (" + bath.getIdService() + ", '" + bath.getHaircutStyle() + "', '" + nail + "')";

        return CRUD.executeCommit(consultationQuery);
    }

    public static boolean updateBaths(Integer idService, String haircutStyle, boolean nailTrimmingIncluded) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        Baths bath = new Baths(idService, haircutStyle, nailTrimmingIncluded);

        int nail = bath.isNailTrimmingIncluded() ? 1 : 0;
        
        String query = "UPDATE Baths SET haircutStyle = '" + bath.getHaircutStyle() + "', nailTrimmingIncluded = '" + nail + "' WHERE ID_Service = " + idService + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteBaths(int serviceId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Baths WHERE ID_Service=?";
        return CRUD.deleteFromDB(query, serviceId);
    }

    public static Baths getBaths(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM Baths WHERE ID_Service=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        Baths bath = new Baths();
        try {
            if (rs.next()) {
                bath.setIdService(rs.getInt("ID_Service"));
                bath.setHaircutStyle(rs.getString("haircutStyle"));
                bath.setNailTrimmingIncluded(rs.getBoolean("nailTrimmingIncluded"));

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return bath;
    }

    public static List<Baths> listTraining() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Baths> bathsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Baths";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                Baths bath = new Baths();
                bath.setIdService(rs.getInt("ID_Service"));
                bath.setHaircutStyle(rs.getString("haircutStyle"));
                bath.setNailTrimmingIncluded(rs.getBoolean("nailTrimmingIncluded"));

                bathsList.add(bath);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return bathsList;
    }
}
