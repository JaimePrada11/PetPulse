package campus.u2.petpulse.Controlador.ServicesControlleres;

import campus.u2.petpulse.Clases.Services.DayCare;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayCareController {

    public static boolean registerDayCare(Integer idService, String specialConditions, LocalDate startDate, LocalDate endDate) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        DayCare daycare = new DayCare(idService, specialConditions, startDate, endDate);

        String consultationQuery = "INSERT INTO DayCare (ID_Service, specialConditions, startDate, endDate) "
                + "VALUES (" + daycare.getIdService() + ", '" + daycare.getSpecialConditions() + "', '"
                + daycare.getStartDate() + "', '" + daycare.getEndDate() + "')";

        return CRUD.executeCommit(consultationQuery);
    }
    

    public static boolean updateDayCare(Integer idService, String specialConditions, LocalDate startDate, LocalDate endDate) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        
        DayCare daycare = new DayCare(idService, specialConditions, startDate, endDate);


        String query = "UPDATE DayCare SET specialConditions = '" + daycare.getIdService() + "', startDate = '" + daycare.getStartDate() + 
                "', endDate = '" + daycare.getEndDate() + "' WHERE ID_Service = " + idService + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean deleteDayCare(int serviceId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM DayCare WHERE ID_Service=?";
        return CRUD.deleteFromDB(query, serviceId);
    }

    public static DayCare getDayCare(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM DayCare WHERE ID_Service=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        DayCare daycare = new DayCare();
        try {
            if (rs.next()) {
                daycare.setIdService(rs.getInt("ID_Service"));
                daycare.setSpecialConditions(rs.getString("specialConditions"));
                daycare.setStartDate(rs.getDate("startDate").toLocalDate());
                daycare.setEndDate(rs.getDate("endDate").toLocalDate());

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return daycare;
    }

    public static List<DayCare> listDayCare() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<DayCare> DayCareList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DayCare";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                DayCare daycare = new DayCare();
                daycare.setIdService(rs.getInt("ID_Service"));
                daycare.setSpecialConditions(rs.getString("specialConditions"));
                daycare.setStartDate(rs.getDate("startDate").toLocalDate());
                daycare.setEndDate(rs.getDate("endDate").toLocalDate());

                DayCareList.add(daycare);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return DayCareList;
    }
}
