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


public class SpeciesControlador {
// Método para registrar una nueva especie
    public static boolean registerSpecies(String speciesName) {
        String query = "INSERT INTO Species (SpeciesName) VALUES (?)";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, speciesName);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar especie: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Método para actualizar una especie
    public static boolean updateSpecies(Integer idSpecies, String speciesName) {
        String query = "UPDATE Species SET SpeciesName = ? WHERE ID_Species = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, speciesName, idSpecies);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar especie: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Método para eliminar una especie
    public static boolean deleteSpecies(Integer idSpecies) {
        String query = "DELETE FROM Species WHERE ID_Species = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idSpecies);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar especie: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return false;
    }

    // Método para obtener una especie por ID
    public static Species getSpeciesById(Integer idSpecies) {
        String query = "SELECT * FROM Species WHERE ID_Species = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idSpecies);
            if (rs.next()) {
                Species species = new Species(
                        rs.getInt("ID_Species"),
                        rs.getString("SpeciesName")
                );
                rs.close();
                return species;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener especie: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return null;
    }

    // Método para listar todas las especies
    public static List<Species> listSpecies() {
        String query = "SELECT * FROM Species";
        List<Species> speciesList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);
            while (rs.next()) {
                Species species = new Species(
                        rs.getInt("ID_Species"),
                        rs.getString("SpeciesName")
                );
                speciesList.add(species);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar especies: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }
        return speciesList;
    }
}
