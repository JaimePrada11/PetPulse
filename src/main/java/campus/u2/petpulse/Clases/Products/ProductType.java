
package campus.u2.petpulse.Clases.Products;


public class ProductType {
    
    private Integer idProductType;
    private String name;

    public ProductType() {
    }

    public ProductType(Integer idProductType, String name) {
        this.idProductType = idProductType;
        this.name = name;
    }

    public ProductType(Integer idProductType) {
        this.idProductType = idProductType;
    }

    public ProductType(String name) {
        this.name = name;
    }
    
    public Integer getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(Integer idProductType) {
        this.idProductType = idProductType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductType{" + "idProductType=" + idProductType + ", name=" + name + '}';
    }


}
