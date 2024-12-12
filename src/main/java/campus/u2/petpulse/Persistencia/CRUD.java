package campus.u2.petpulse.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CRUD {

    public static Connection con; 
    public static Statement stmt = null;
    public static ResultSet rs = null; 

    public static Connection setConnection(Connection connection) throws SQLException {
        if (connection == null) {
            throw new IllegalArgumentException("The provided connection is null.");
        }
        if (!connection.isValid(2)) {
            throw new IllegalArgumentException("The provided connection is not valid.");
        }
        CRUD.con = connection;
        return connection;
    }

    public static Connection getConnection() {
        return con;
    }

    private static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     public static ResultSet queryDB(String query, Object... params) {

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error in SELECT query", e);
            return null;

        }
    }

    // Similar to the above, but for INSERT statement
    public static boolean insertIntoDB(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error in INSERT query", ex);
            return false;
        }
    }

    // For DELETE statement
    public static boolean deleteFromDB(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error in DELETE query", ex);
            return false;
        }

    }

    // For UPDATE statement 
    public static boolean updateInDB(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error in UPDATE query", ex);
            return false;
        }
    }

    public static boolean setAutoCommitDB(boolean param) {
        try {
            if (con != null) {
                con.setAutoCommit(param);
            } else {
                throw new SQLException("Connection not initialized.");
            }
            return true;
        } catch (SQLException sqlex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error setting autoCommit", sqlex);
            return false;
        }
    }

    public static boolean commitDB() {
        try {
            if (con != null) {
                con.commit();
                return true;
            } else {
                throw new SQLException("Connection not initialized.");
            }
        } catch (SQLException sqlex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error committing", sqlex);
            return false;
        }
    }

    public static boolean rollbackDB() {
        try {
            if (con != null) {
                con.rollback();
                return true;
            } else {
                throw new SQLException("Connection not initialized.");
            }
        } catch (SQLException sqlex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error rolling back", sqlex);
            return false;
        }
    }

    public static void closeConnection() {
        closeConnection(con);
    }
    
    public static boolean executeCommit(String statement) {
        if (setAutoCommitDB(false)) { // Disable autoCommit
            if (deleteFromDB(statement) || insertIntoDB(statement) || updateInDB(statement)) {
                commitDB(); // Commit if successful
                closeConnection();
                return true;
            } else {
                rollbackDB(); // Rollback if something goes wrong
                closeConnection();
                return false;
            } // Rollback in case of exception during transaction
        } else {
            closeConnection(); // Close connection if autoCommit can't be disabled
            return false;
        }
    }


    }
