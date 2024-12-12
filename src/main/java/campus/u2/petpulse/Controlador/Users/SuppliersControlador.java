package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import campus.u2.petpulse.Clases.BillingProcess.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuppliersControlador {

   
    
    // Insertar un proveedor
    public static boolean insertSupplier(String companyName, String nit, String contactName, String phoneNumber, String email) {
        String query = "INSERT INTO Suppliers(Company_Name, NIT, contactName, Phone_Number, Email) VALUES(?, ?, ?, ?, ?)";
        Suppliers supplier = new Suppliers(companyName, nit, contactName, phoneNumber, email);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, supplier.getCompany_Name(), supplier.getNIT(),
                        supplier.getContactName(), supplier.getPhone_Number(), supplier.getEmail());
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

    // Actualizar un proveedor
    public static boolean updateSupplier(int idSupplier, String companyName, String nit, String contactName, String phoneNumber, String email) throws SQLException {
        String query = "UPDATE Suppliers SET Company_Name = ?, NIT = ?, contactName = ?, Phone_Number = ?, Email = ? WHERE ID_Supplier = ?";
        Suppliers supplier = new Suppliers(idSupplier, companyName, nit, contactName, phoneNumber, email);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, supplier.getCompany_Name(), supplier.getNIT(),
                        supplier.getContactName(), supplier.getPhone_Number(), supplier.getEmail(), supplier.getID_Supplier());
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

    // Eliminar un proveedor
    public static boolean deleteSupplier(int idSupplier) throws SQLException {
        String query = "DELETE FROM Suppliers WHERE ID_Supplier = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idSupplier);
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

    // Obtener un proveedor por ID
    public static Suppliers getSupplierById(int idSupplier) throws SQLException {
        String query = "SELECT * FROM Suppliers WHERE ID_Supplier = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idSupplier);

            if (rs.next()) {
                Suppliers supplier = new Suppliers(
                        rs.getInt("ID_Supplier"),
                        rs.getString("Company_Name"),
                        rs.getString("NIT"),
                        rs.getString("contactName"),
                        rs.getString("Phone_Number"),
                        rs.getString("Email")
                );
                rs.close();
                return supplier;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el proveedor: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return null;
    }

    // Listar todos los proveedores
    public static List<Suppliers> listSuppliers() throws SQLException {
        String query = "SELECT * FROM Suppliers";
        List<Suppliers> suppliersList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                Suppliers supplier = new Suppliers(
                        rs.getInt("ID_Supplier"),
                        rs.getString("Company_Name"),
                        rs.getString("NIT"),
                        rs.getString("contactName"),
                        rs.getString("Phone_Number"),
                        rs.getString("Email")
                );
                suppliersList.add(supplier);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los proveedores: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return suppliersList;
    }

    // Obtener un proveedor por NIT
    public static Suppliers getSupplierByNIT(String nit) throws SQLException {
        String query = "SELECT * FROM Suppliers WHERE NIT = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, nit);
            if (rs.next()) {
                Suppliers supplier = new Suppliers(rs.getInt("ID_Supplier"), rs.getString("Company_Name"), rs.getString("NIT"), rs.getString("contactName"), rs.getString("Phone_Number"), rs.getString("Email"));
                rs.close();
                return supplier;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el proveedor: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }
        return null;

    }
// Actualizar un proveedor por NIT
    public static boolean updateSupplierByNIT(String nit, String companyName, String contactName, String phoneNumber, String email) throws SQLException {
        String query = "UPDATE Suppliers SET Company_Name = ?, contactName = ?, Phone_Number = ?, Email = ? WHERE NIT = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, companyName, contactName, phoneNumber, email, nit);
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
}
