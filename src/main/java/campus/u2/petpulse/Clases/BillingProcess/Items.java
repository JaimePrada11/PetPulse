package campus.u2.petpulse.Clases.BillingProcess;

import campus.u2.petpulse.Clases.Products.Product;

public class Items {

    private Product product;
    private Integer quantity;
    private Double subTotal;

    public Items(Product product, Integer quantity, Double subTotal) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "Items{" + "product=" + product + ", quantity=" + quantity + ", subTotal=" + subTotal + '}';
    }

}
