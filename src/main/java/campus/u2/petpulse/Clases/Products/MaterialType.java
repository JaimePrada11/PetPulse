
package campus.u2.petpulse.Clases.Products;


public class MaterialType {
    
    private Integer idmaterialType;
    private String name;

    public MaterialType(Integer materialType, String name) {
        this.idmaterialType = materialType;
        this.name = name;
    }

    public MaterialType(String name) {
        this.name = name;
    }

    public MaterialType(Integer idmaterialType) {
        this.idmaterialType = idmaterialType;
    }
    

    public MaterialType() {
    }

    public Integer getMaterialType() {
        return idmaterialType;
    }

    public void setMaterialType(int materialType) {
        this.idmaterialType = materialType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaterialType{" + "idmaterialType=" + idmaterialType + ", name=" + name + '}';
    }
    
    
    
    
}
