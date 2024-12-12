package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetsAttributesControlador {

    
    // Insertar una relación entre una mascota y un atributo
    public static boolean insertPetAttribute(int idPet, int idAttribute) {
        String query = "INSERT INTO PetsAttributes(ID_Pet, ID_Attribute) VALUES(?, ?)";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, idPet, idAttribute);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar en PetsAttributes: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Actualizar una relación (cambiar el atributo asociado a una mascota)
    public static boolean updatePetAttribute(int idPet, int oldIdAttribute, int newIdAttribute) throws SQLException {
        String query = "UPDATE PetsAttributes SET ID_Attribute = ? WHERE ID_Pet = ? AND ID_Attribute = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, newIdAttribute, idPet, oldIdAttribute);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar PetsAttributes: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Eliminar una relación
    public static boolean deletePetAttribute(int idPet, int idAttribute) throws SQLException {
        String query = "DELETE FROM PetsAttributes WHERE ID_Pet = ? AND ID_Attribute = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idPet, idAttribute);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar en PetsAttributes: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Obtener todos los atributos asociados a una mascota
    public static List<Integer> getAttributesByPetId(int idPet) throws SQLException {
        String query = "SELECT ID_Attribute FROM PetsAttributes WHERE ID_Pet = ?";
        List<Integer> attributes = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idPet);

            while (rs.next()) {
                attributes.add(rs.getInt("ID_Attribute"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener atributos por ID de mascota: " + e.getMessage());
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return attributes;
    }

    // Obtener todas las mascotas asociadas a un atributo
    public static List<Integer> getPetsByAttributeId(int idAttribute) throws SQLException {
        String query = "SELECT ID_Pet FROM PetsAttributes WHERE ID_Attribute = ?";
        List<Integer> pets = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idAttribute);

            while (rs.next()) {
                pets.add(rs.getInt("ID_Pet"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener mascotas por ID de atributo: " + e.getMessage());
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return pets;
    }
    
}
