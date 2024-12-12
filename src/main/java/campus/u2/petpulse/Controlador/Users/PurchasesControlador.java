package campus.u2.petpulse.Controlador.Users;

import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import campus.u2.petpulse.Clases.Products.*;
import campus.u2.petpulse.Clases.BillingProcess.*;
import campus.u2.petpulse.Controlador.ProductsControlleres.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchasesControlador {

    // Insertar una compra
    public static boolean insertPurchase(LocalDate date, Integer idSupplier) {
        String query = "INSERT INTO Purchases(DatePurchase, ID_Supplier) VALUES(?, ?)";
        Purchase purchase = new Purchase(date, idSupplier);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, purchase.getDate(), purchase.getIdSuplier());
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

    // Actualizar una compra
    public static boolean updatePurchase(int idPurchase, LocalDate date, Integer idSupplier, int total) {
        String query = "UPDATE Purchases SET DatePurchase = ?, ID_Supplier = ?, Total = ? WHERE ID_Purchase = ?";
        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, date, idSupplier, total, idPurchase);
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

    // Eliminar una compra
    public static boolean deletePurchase(int idPurchase) {
        String query = "DELETE FROM Purchases WHERE ID_Purchase = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idPurchase);
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

    // Obtener una compra por ID
    public static Purchase getPurchaseById(int idPurchase) {
        String query = "SELECT * FROM Purchases WHERE ID_Purchase = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idPurchase);

            if (rs.next()) {
                Purchase purchase = new Purchase(
                        rs.getInt("ID_Purchase"),
                        rs.getDate("DatePurchase").toLocalDate(),
                        rs.getDouble("Total"),
                        rs.getInt("ID_Supplier")
                );
                rs.close();

                List<PurchaseDetails> lista = PurchaseDetailsControlador.getPurchaseDetailsByPurchaseId(idPurchase);
                if (lista.size() >= 0) {
                    try {
                        Double total = 0.0;
                        for (PurchaseDetails i : lista) {
                            Product productoTemporal = ProductController.getProductId(i.getID_Product());
                            Integer quantity = i.getQuantity();
                            Double price = productoTemporal.getPrice();
                            Double subTotal = price * quantity;
                            total = total + subTotal;
                            Items item = new Items(productoTemporal, quantity, subTotal);
                            purchase.getListItems().add(item);
                        }
                        purchase.setTotal(total);
                       

                    } catch (Exception e) {
                        System.out.println("Error en el proceso: " + e.getMessage());
                    }

                }

                return purchase;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la compra: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }

        return null;
    }
    
    public static String getPurchaseInvoice(int idPurchase) {
    Purchase purchase = getPurchaseById(idPurchase);
    if (purchase == null) {
        return "Compra no encontrada.";
    }

    StringBuilder invoice = new StringBuilder();
    invoice.append("### Factura de Compra\n\n")
           .append("**ID de la Compra:** ").append(purchase.getId_Purchase()).append("\n")
           .append("**Fecha de Compra:** ").append(purchase.getDate()).append("\n")
           .append("**Proveedor:** ").append(purchase.getIdSuplier()).append("\n\n")
           .append("**Detalles de la Compra:**\n")
           .append("| Producto       | Cantidad | Precio Unitario | Subtotal    |\n")
           .append("|----------------|----------|-----------------|-------------|\n");

    for (Items item : purchase.getListItems()) {
        invoice.append("| ")
               .append(item.getProduct().getName()).append(" | ")
               .append(item.getQuantity()).append(" | ")
               .append(item.getProduct().getPrice()).append(" | ")
               .append(item.getSubTotal()).append(" |\n");
    }

    invoice.append("\n**Total de la Compra:** ").append(purchase.getTotal());

    return invoice.toString();
}


    // Listar todas las compras
    public static List<Purchase> listPurchases() {
        String query = "SELECT * FROM Purchases";
        List<Purchase> purchasesList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                Purchase purchase = new Purchase(
                        rs.getInt("ID_Purchase"),
                        rs.getDate("DatePurchase").toLocalDate(),
                        rs.getDouble("Total"),
                        rs.getInt("ID_Supplier")
                );
                purchasesList.add(purchase);
            }

            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las compras: " + e.getMessage());
        } finally {
            CRUD.closeConnection();
        }

        return purchasesList;
    }
}
