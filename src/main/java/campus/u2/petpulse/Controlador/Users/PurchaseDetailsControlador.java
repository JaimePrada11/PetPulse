package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Clases.BillingProcess.*;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDetailsControlador {

    // Insertar un detalle de compra
    public static boolean insertPurchaseDetail(int idProduct, int idPurchase, int quantity, Double subtotal) {
        String query = "INSERT INTO PurchaseDetails(ID_Product, ID_Purchase, Quantity, subTotal) VALUES(?, ?, ?, ?)";
        // Instancia del objeto antes de realizar la inserción
        PurchaseDetails detail = new PurchaseDetails(idProduct, idPurchase, quantity, subtotal);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query,
                        detail.getID_Product(),
                        detail.getID_Purchase(),
                        detail.getQuantity(),
                        detail.getTotal());
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

    // Actualizar un detalle de compra
    public static boolean updatePurchaseDetail(int idProduct, int idPurchase, int quantity, Double subtotal) {
        String query = "UPDATE PurchaseDetails SET Quantity = ?, subTotal = ? WHERE ID_Product = ? AND ID_Purchase = ?";
        // Instancia del objeto antes de realizar la actualización
        PurchaseDetails detail = new PurchaseDetails(idProduct, idPurchase, quantity, subtotal);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query,
                        detail.getQuantity(),
                        detail.getTotal(),
                        detail.getID_Product(),
                        detail.getID_Purchase());
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

    // Eliminar un detalle de compra
    public static boolean deletePurchaseDetail(int idProduct, int idPurchase) {
        String query = "DELETE FROM PurchaseDetails WHERE ID_Product = ? AND ID_Purchase = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idProduct, idPurchase);
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
// Obtener un detalle de compra por ID de compra

    public static List<PurchaseDetails> getPurchaseDetailsByPurchaseId(int idPurchase) {
        String query = "SELECT * FROM PurchaseDetails WHERE ID_Purchase = ?";

        List<PurchaseDetails> detailsList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idPurchase);

            while (rs.next()) {
                PurchaseDetails detail = new PurchaseDetails(
                        rs.getInt("ID_Product"),
                        rs.getInt("ID_Purchase"),
                        rs.getInt("Quantity"),
                        rs.getDouble("subTotal")
                );
                detailsList.add(detail);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los detalles de compra: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }

        return detailsList;
    }

    // Listar todos los detalles de compra
    public static List<PurchaseDetails> listPurchaseDetails() {
        String query = "SELECT * FROM PurchaseDetails";
        List<PurchaseDetails> detailsList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                PurchaseDetails detail = new PurchaseDetails(
                        rs.getInt("ID_Product"),
                        rs.getInt("ID_Purchase"),
                        rs.getInt("Quantity"),
                        rs.getDouble("subTotal")
                );
                detailsList.add(detail);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los detalles de compra: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }

        return detailsList;
    }
}
