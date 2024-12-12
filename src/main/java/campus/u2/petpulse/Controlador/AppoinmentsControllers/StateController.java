package campus.u2.petpulse.Controlador.AppoinmentsControllers;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import campus.u2.petpulse.Clases.Appointments.State;
import java.sql.SQLException;
import java.util.List;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StateController {

    // Register a new state
    public static boolean registerState(String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "INSERT INTO States (Name) VALUES ('" + name + "');";
        return CRUD.executeCommit(query);
    }

    // Update an existing state
    public static boolean updateState(int id, String name) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "UPDATE States SET Name='" + name + "' WHERE ID_State=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Delete a state by its ID
    public static boolean deleteState(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM States WHERE ID_State=" + id + ";";
        return CRUD.executeCommit(query);
    }

    // Get a state by its ID
    public static State getState(int id) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String sql = "SELECT * FROM States WHERE ID_State=" + id + ";";
        ResultSet rs = CRUD.queryDB(sql);
        State state = new State();
        try {
            if (rs.next()) {
                state.setIdState(rs.getInt("ID_State"));
                state.setName(rs.getString("Name"));
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return state;
    }

    // List all states
    public static List<State> listStates() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<State> stateList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM States";
            ResultSet rs = CRUD.queryDB(sql);

            while (rs.next()) {
                State state = new State();
                state.setIdState(rs.getInt("ID_State"));
                state.setName(rs.getString("Name"));
                stateList.add(state);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return stateList;
    }
}


