
package campus.u2.petpulse.Clases.Products;

import java.util.Date;


public class MedicalMaterial  extends Product{
    
    private Integer ID_Product;
    private Integer size;
    private MaterialType materialType;
    private boolean reusable;


    public MedicalMaterial() {
    }

    public MedicalMaterial(Integer ID_Product, Integer size, MaterialType materialType, boolean reusable) {
        this.ID_Product = ID_Product;
        this.size = size;
        this.materialType = materialType;
        this.reusable = reusable;
    }

    public Integer getID_Product() {
        return ID_Product;
    }

    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public boolean isReusable() {
        return reusable;
    }

    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    @Override
    public String toString() {
        return "MedicalMaterial{" + "ID_Product=" + ID_Product + ", size=" + size + ", materialType=" + materialType + ", reusable=" + reusable + '}';
    }
    

    
}
