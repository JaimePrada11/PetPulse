package campus.u2.petpulse.Controlador.ProductsControlleres;

import campus.u2.petpulse.Clases.Products.Product;
import campus.u2.petpulse.Clases.Products.ProductType;
import campus.u2.petpulse.Persistencia.CRUD;
import campus.u2.petpulse.Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductController {

    public static boolean registerProduct(String SKU, String name, String batch, String manufacturer, LocalDate entryDate, LocalDate dueDate, Integer stock, Double price, ProductType productType) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Product product = new Product(SKU, name, batch, manufacturer, entryDate, dueDate, stock, price, productType);

        String query = "INSERT INTO Products (SKU, Name, Batch, Manufacturer, EntryDate, DueDate, Stock, Price, ID_ProductsTypes) "
                + "VALUES ('" + product.getSKU() + "', '" + product.getName() + "', '" + product.getBatch() + "', '"
                + product.getManufacturer() + "', '" + product.getEntryDate() + "', '" + product.getDueDate() + "', "
                + product.getStock() + ", " + product.getPrice() + ", " + product.getProductType().getIdProductType() + ");";

        return CRUD.executeCommit(query);
    }

    public static boolean updateProduct(Integer id, String SKU, String name, String batch, String manufacturer, LocalDate entryDate, LocalDate dueDate, Integer stock, Double price, ProductType productType) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Product product = new Product(SKU, name, batch, manufacturer, entryDate, dueDate, stock, price, productType);

        String query = "UPDATE Products SET SKU = '" + product.getSKU() + "', "
                + "Name = '" + product.getName() + "', " + "Batch = '" + product.getBatch() + "', " + "ID_Manufacturer = '" + product.getManufacturer() + "', "
                + "Entry_Date = '" + product.getEntryDate() + "', " + "Due_Date = '" + product.getDueDate() + "', " + "Stock = " + product.getStock() + ", "
                + "Price = " + product.getPrice() + ", " + "ID_Products_Types = " + product.getProductType() + " " + "WHERE ID_Product = " + id + ";";

        return CRUD.executeCommit(query);
    }

    public static boolean updateProduct(String SKU, String name, String batch, String manufacturer, LocalDate entryDate, LocalDate dueDate, Integer stock, Double price, ProductType productType) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        Product product = new Product(SKU, name, batch, manufacturer, entryDate, dueDate, stock, price, productType);

        String query = "UPDATE Products SET Name = '" + product.getName() + "', Batch = '" + product.getBatch()
                + "', ID_Manufacturer = " + product.getManufacturer() + ", Entry_Date = '" + product.getEntryDate()
                + "', Due_Date = '" + product.getDueDate() + "', Stock = " + product.getStock() + ", Price = " + product.getPrice()
                + ", ID_Products_Types = " + product.getProductType() + " WHERE SKU = " + SKU + ";";
        return CRUD.executeCommit(query);
    }

    public static boolean deleteProduct(int productId) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "DELETE FROM Products WHERE ID_Product = ?";
        return CRUD.deleteFromDB(query, productId);
    }

    public static boolean updateStock(int productId, int newStock) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "UPDATE Products SET Stock = " + newStock + " WHERE ID_Product = " + productId;

        return CRUD.executeCommit(query);
    }

    public static Product getProductId(int idProducto) throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());

        String query = "SELECT * FROM Products WHERE ID_Product= ?";
        ResultSet rs = CRUD.queryDB(query, idProducto);
        Product product = new Product();
        try {
            if (rs.next()) {
                product.setIdProduct(rs.getInt("ID_Product"));
                product.setSKU(rs.getString("SKU"));
                product.setName(rs.getString("Name"));
                product.setBatch(rs.getString("Batch"));
                product.setManufacturer(rs.getString("Manufacturer"));
                product.setEntryDate(rs.getDate("EntryDate").toLocalDate());
                product.setDueDate(rs.getDate("DueDate").toLocalDate());
                product.setStock(rs.getInt("Stock"));
                product.setPrice(rs.getDouble("Price"));

                int producttype = rs.getInt("ID_ProductsTypes");
                ProductType p = new ProductType(producttype);
                product.setProductType(p);

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, "Error", ex);
            return null;
        }
        return product;
    }

    public static Product getProduct(String SKU) {
        String query = "SELECT * FROM Products WHERE SKU = ?";
        ResultSet rs = CRUD.queryDB(query, SKU);
        Product product = new Product();

        try {
            if (rs.next()) {
                product.setIdProduct(rs.getInt("ID_Product"));
                product.setSKU(rs.getString("SKU"));
                product.setName(rs.getString("Name"));
                product.setBatch(rs.getString("Batch"));
                product.setManufacturer(rs.getString("Manufacturer"));
                product.setEntryDate(rs.getDate("EntryDate").toLocalDate());
                product.setDueDate(rs.getDate("DueDate").toLocalDate());
                product.setStock(rs.getInt("Stock"));
                product.setPrice(rs.getDouble("Price"));

                int producttype = rs.getInt("ID_ProductsTypes");
                ProductType p = new ProductType(producttype);
                product.setProductType(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, "Error", ex);
        }
        return null;
    }

    public static List<Product> listProducts() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        List<Product> productList = new ArrayList<>();

        String query = "SELECT p.*, pt.Name AS productTypeName FROM Products p "
                 + "JOIN ProductsTypes pt ON p.ID_ProductsTypes = pt.ID_ProductsTypes";

   

        ResultSet rs = CRUD.queryDB(query);

        try {
            while (rs.next()) {
                Product product = new Product() {
                    {
                        setIdProduct(rs.getInt("ID_Product"));
                        setName(rs.getString("Name"));
                        setSKU(rs.getString("SKU"));
                        setBatch(rs.getString("Batch"));
                        setManufacturer(rs.getString("Manufacturer"));
                        setEntryDate(rs.getDate("EntryDate").toLocalDate());
                        setDueDate(rs.getDate("DueDate").toLocalDate());
                        setStock(rs.getInt("Stock"));
                        setPrice(rs.getDouble("Price"));

                        ProductType p = new ProductType();
                        p.setIdProductType(rs.getInt("ID_ProductsTypes"));
                        p.setName(rs.getString("productTypeName"));
                        setProductType(p);

                    }
                };
                productList.add(product);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            CRUD.closeConnection();
        }

        return productList;
    }

    public static int getLastProductID() throws SQLException {
        CRUD.setConnection(ConexionDB.getConexion());
        String query = "SELECT MAX(ID_Product) AS last_id FROM Products ;";

        ResultSet rs = CRUD.queryDB(query);
        int lastId = -1;

        try {
            if (rs.next()) {
                lastId = rs.getInt("last_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            CRUD.closeConnection();
        }

        return lastId;
    }

}
