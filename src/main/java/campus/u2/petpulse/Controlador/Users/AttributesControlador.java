/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Controlador.Users;


import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import campus.u2.petpulse.Clases.Animals.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AttributesControlador {

   
    public static boolean insertAttribute(String name, int idSubcategory) {
        String query = "INSERT INTO Attributes(Name, ID_SubCategory) VALUES(?, ?)";
        Attributes attribute = new Attributes(name, idSubcategory);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, attribute.getName(), attribute.getIdSubcategory());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de inserción: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Actualizar un atributo
    public static boolean updateAttribute(int idAttribute, String name, int idSubcategory) throws SQLException {
        String query = "UPDATE Attributes SET Name = ?, ID_SubCategory = ? WHERE ID_Attribute = ?";
        Attributes attribute = new Attributes(idAttribute, name, idSubcategory);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, attribute.getName(), attribute.getIdSubcategory(), attribute.getId());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de actualización: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Eliminar un atributo
    public static boolean deleteAttribute(int idAttribute) throws SQLException {
        String query = "DELETE FROM Attributes WHERE ID_Attribute = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idAttribute);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de eliminación: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Obtener un atributo por ID
    public static Attributes getAttributeById(int idAttribute) throws SQLException {
        String query = "SELECT * FROM Attributes WHERE ID_Attribute = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idAttribute);

            if (rs.next()) {
                Attributes attribute = new Attributes(
                        rs.getInt("ID_Attribute"),
                        rs.getString("Name"),
                        rs.getInt("ID_SubCategory")
                );
                rs.close();
                return attribute;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el atributo: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return null;
    }

    // Listar todos los atributos
    public static List<Attributes> listAttributes() throws SQLException {
        String query = "SELECT * FROM Attributes";
        List<Attributes> attributesList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                Attributes attribute = new Attributes(
                        rs.getInt("ID_Attribute"),
                        rs.getString("Name"),
                        rs.getInt("ID_SubCategory")
                );
                attributesList.add(attribute);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los atributos: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return attributesList;
    }
}
