
package campus.u2.petpulse.Clases.Products;

public class AccesoryType {
    
    private int idAccesoryType;
    private String name;
    

    public AccesoryType() {
    }

    public AccesoryType(int idAccesoryType) {
        this.idAccesoryType = idAccesoryType;
    }
    
    public AccesoryType(int idAccesoryType, String name) {
        this.idAccesoryType = idAccesoryType;
        this.name = name;
    }

    public AccesoryType(String name) {
        this.name = name;
    }

    public int getIdAccesoryType() {
        return idAccesoryType;
    }

    public void setIdAccesoryType(int idAccesoryType) {
        this.idAccesoryType = idAccesoryType;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AccesoryType{" + "idAccesoryType=" + idAccesoryType + ", name=" + name + '}';
    }

    
}
