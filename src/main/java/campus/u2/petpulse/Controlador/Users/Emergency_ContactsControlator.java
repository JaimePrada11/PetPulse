package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.SQLException;
import campus.u2.petpulse.Clases.Users.*;
import static campus.u2.petpulse.Persistencia.CRUD.*;
import java.sql.ResultSet;
import java.util.*;

public class Emergency_ContactsControlator {

   // Insert
    public static boolean registrar(String name, String Phone_Number, String ID_Card, String Address, String Email) {
        String sentencia = "INSERT INTO Emergency_Contacts(name, Phone_Number, ID_Card, Address,Email) VALUES(?,?,?,?,?)";
        EmergencyContacts aObject = new EmergencyContacts(name, Phone_Number, ID_Card, Address, Email);
        try {
            CRUD.setConnection(ConexionDB.getConexion()); // Establecer conexión
            if (CRUD.setAutoCommitDB(false)) { // Desactivar auto-commit para transacciones
                boolean resultado = insertIntoDB(sentencia, aObject.getName(), aObject.getPhone_Number(), aObject.getId_Card(), aObject.getAddress(), aObject.getEmail());
                if (resultado) {
                    CRUD.commitDB(); // Confirmar la transacción si todo salió bien
                } else {
                    CRUD.rollbackDB(); // Revertir si ocurrió algún problema
                }
                return resultado;
            }
        } catch (SQLException e) {
            System.out.println("Error en la Operacion Insert: " + e.getMessage());
            CRUD.rollbackDB(); // Intentar revertir en caso de error
        }
        CRUD.closeConnection(); // Asegurar el cierre de la conexión

        return false; // Retornar false si algo falló
    }

    // UPDATE 
    public static boolean actualizarAguacate(String name, String Phone_Number, String ID_Card, String Address, String Email, Integer ID_Emergency_Contact) throws SQLException {
        String sentencia = "UPDATE Emergency_Contacts SET name = ?, Phone_Number = ?, ID_Card = ?, Address = ?, Email = ? WHERE ID_Emergency_Contact = ?";
        EmergencyContacts aObject = new EmergencyContacts(ID_Emergency_Contact, name, ID_Card, Address, Phone_Number, Email);
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean resultado = CRUD.updateInDB(sentencia, aObject.getName(), aObject.getPhone_Number(), aObject.getId_Card(), aObject.getAddress(), aObject.getEmail(), aObject.getId());
                if (resultado) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return resultado;
            }

        } catch (SQLException e) {
            System.out.println("Error en la Operacion actualizar: " + e.getMessage());
            CRUD.rollbackDB(); // Intentar revertir en caso de error
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;

    }
    
    

    // Eliminar 
    public static boolean borrarAguacate(Integer ID_Emergency_Contact) throws SQLException {
        String sentencia = "DELETE FROM Emergency_Contacts WHERE ID_Emergency_Contact = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean resultado = CRUD.deleteFromDB(sentencia, ID_Emergency_Contact);
                if (resultado) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return resultado;
            }
        } catch (SQLException e) {
            System.out.println("Error en la Operacion borrar: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Obtener un aguacate por ID
    public static EmergencyContacts obtenerEmergencyContact(int idEmergencyContact) throws SQLException {
        String sentencia = "SELECT * FROM Emergency_Contacts WHERE ID_Emergency_Contact = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());

            ResultSet rs = CRUD.queryDB(sentencia, idEmergencyContact);

            if (rs.next()) {
                EmergencyContacts emergencyContact = new EmergencyContactsBuilder()
                        .setId(rs.getInt("ID_Emergency_Contact"))
                        .setName(rs.getString("Name"))
                        .setIdCard(rs.getString("ID_Card"))
                        .setAddress(rs.getString("Address"))
                        .setPhoneNumber(rs.getString("Phone_Number"))
                        .setEmail(rs.getString("Email"))
                        .build();

                rs.close();
                return emergencyContact;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el contacto de emergencia: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    public static List<EmergencyContacts> listarEmergencyContacts() throws SQLException {
        String sentencia = "SELECT * FROM Emergency_Contacts";
        List<EmergencyContacts> listaEmergencyContacts = new ArrayList<>();
        try {
            CRUD.setConnection(ConexionDB.getConexion());

            ResultSet rs = CRUD.queryDB(sentencia);

            while (rs.next()) {
                EmergencyContacts emergencyContact = new EmergencyContactsBuilder()
                        .setId(rs.getInt("ID_Emergency_Contact"))
                        .setName(rs.getString("Name"))
                        .setIdCard(rs.getString("ID_Card"))
                        .setAddress(rs.getString("Address"))
                        .setPhoneNumber(rs.getString("Phone_Number"))
                        .setEmail(rs.getString("Email"))
                        .build();
                listaEmergencyContacts.add(emergencyContact);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los contactos de emergencia: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return listaEmergencyContacts;
    }
}
