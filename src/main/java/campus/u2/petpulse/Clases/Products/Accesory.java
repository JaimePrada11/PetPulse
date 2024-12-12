package campus.u2.petpulse.Clases.Products;

import java.util.Date;

public class Accesory extends Product{

    private Integer idProduct;
    private MaterialType materialType;
    private String dimensions;
    private AccesoryType accesoryType;

    public Accesory() {
    }

    public Accesory(Integer idProduct, MaterialType materialType, String dimensions, AccesoryType accesoryType) {
        this.idProduct = idProduct;
        this.materialType = materialType;
        this.dimensions = dimensions;
        this.accesoryType = accesoryType;
    }

   

    @Override
    public Integer getIdProduct() {
        return idProduct;
    }

    @Override
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public AccesoryType getAccesoryType() {
        return accesoryType;
    }

    public void setAccesoryType(AccesoryType accesoryType) {
        this.accesoryType = accesoryType;
    }

    @Override
    public String toString() {
        return "Accesory{" + "idProduct=" + idProduct + ", materialType=" + materialType + ", dimensions=" + dimensions + ", accesoryType=" + accesoryType + '}';
    }


}
