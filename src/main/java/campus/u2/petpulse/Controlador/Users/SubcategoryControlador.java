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


public class SubcategoryControlador {
// Método para insertar una nueva subcategoría
    public static boolean insertSubcategory(Subcategory subcategory) {
        String query = "INSERT INTO SubCategory(Name) VALUES(?)";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, subcategory.getName());
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

    // Método para actualizar una subcategoría existente
    public static boolean updateSubcategory(int id, String newName) {
        String query = "UPDATE SubCategory SET Name = ? WHERE ID_SubCategory = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, newName, id);
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
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Método para eliminar una subcategoría por ID
    public static boolean deleteSubcategory(int id) {
        String query = "DELETE FROM SubCategory WHERE ID_SubCategory = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, id);
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
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Método para obtener una subcategoría por ID
    public static Subcategory getSubcategoryById(int id) {
        String query = "SELECT * FROM SubCategory WHERE ID_SubCategory = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, id);

            if (rs.next()) {
                Subcategory subcategory = new Subcategory(
                        rs.getInt("ID_SubCategory"),
                        rs.getString("Name")
                );
                rs.close();
                return subcategory;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener subcategoría: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    // Método para listar todas las subcategorías
    public static List<Subcategory> listSubcategories() {
        String query = "SELECT * FROM SubCategory";
        List<Subcategory> subcategories = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                Subcategory subcategory = new Subcategory(
                        rs.getInt("ID_SubCategory"),
                        rs.getString("Name")
                );
                subcategories.add(subcategory);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar subcategorías: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return subcategories;
    }
}