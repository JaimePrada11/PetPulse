package campus.u2.petpulse.Clases.Products;

import campus.u2.petpulse.Clases.BillingProcess.Suppliers;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private Integer idProduct;
    private String SKU;
    private String name;
    private String batch;
    private String manufacturer;
    private LocalDate entryDate;
    private LocalDate dueDate;
    private Integer stock;
    private Double price;
    private ProductType productType;
    private List<Suppliers> suppliers;

    public Product() {
    }

    public Product(Integer idProduct, String SKU, String name, String batch, String manufacturer, LocalDate entryDate, LocalDate dueDate, Integer stock, Double price, ProductType productType) {
        this.idProduct = idProduct;
        this.SKU = SKU;
        this.name = name;
        this.batch = batch;
        this.manufacturer = manufacturer;
        this.entryDate = entryDate;
        this.dueDate = dueDate;
        this.stock = stock;
        this.price = price;
        this.productType = productType;
        this.suppliers = new ArrayList<>();
    }

    public Product(String SKU, String name, String batch, String manufacturer, LocalDate entryDate, LocalDate dueDate, Integer stock, Double price, ProductType productType) {
        this.SKU = SKU;
        this.name = name;
        this.batch = batch;
        this.manufacturer = manufacturer;
        this.entryDate = entryDate;
        this.dueDate = dueDate;
        this.stock = stock;
        this.price = price;
        this.productType = productType;
        this.suppliers = new ArrayList<>();
    }

    // Getters and setters
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void addSupplier(Suppliers supplier) {
        suppliers.add(supplier);
    }

    public void removeSupplier(Suppliers supplier){
        suppliers.remove(supplier);
    }

    public List<Suppliers> getProveedores() {
        return suppliers;
    }

    public boolean isExpired() {
        
        LocalDate currentDate = LocalDate.now();
        return dueDate.isBefore(currentDate);
    }

    public int applyDiscount(double discountPercentage) {
        return (int) (price - (price * discountPercentage / 100));
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public boolean isStockBelowMinimum() {
        return stockManagement.isStockBelowMinimum(this);
    }

    public boolean isStockCritical() {
        return stockManagement.isStockCritical(this);
    }

    public void updateStock(int quantity) {
        this.stock = quantity;
    }

    public void reduceStock(int quantity) {
        if (quantity <= stock) {
            this.stock -= quantity;
        } else {
            System.out.println("Not enough stock to reduce.");
        }
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", SKU=" + SKU + ", name=" + name + ", batch=" + batch + ", manufacturer=" + manufacturer + ", entryDate=" + entryDate + ", dueDate=" + dueDate + ", stock=" + stock + ", price=" + price + ", productType=" + productType + '}';
    }

}
