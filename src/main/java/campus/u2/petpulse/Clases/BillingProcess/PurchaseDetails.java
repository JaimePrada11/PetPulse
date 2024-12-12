
package campus.u2.petpulse.Clases.BillingProcess;

public class PurchaseDetails {
    
    private  Integer ID_Product;
    private Integer ID_Purchase;
    private  Integer Quantity;
    private Double total;

    public PurchaseDetails() {
    }

    public PurchaseDetails(Integer ID_Product, Integer ID_Purchase, Integer Quantity, Double total) {
        this.ID_Product = ID_Product;
        this.ID_Purchase = ID_Purchase;
        this.Quantity = Quantity;
        this.total = 0.0;
    }

    public Integer getID_Product() {
        return ID_Product;
    }

    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }

    public Integer getID_Purchase() {
        return ID_Purchase;
    }

    public void setID_Purchase(Integer ID_Purchase) {
        this.ID_Purchase = ID_Purchase;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PurchaseDetails{" + "ID_Product=" + ID_Product + ", ID_Purchase=" + ID_Purchase + ", Quantity=" + Quantity + ", total=" + total + '}';
    }
    

    
}