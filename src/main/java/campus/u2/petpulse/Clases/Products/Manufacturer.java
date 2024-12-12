
package campus.u2.petpulse.Clases.Products;


public class Manufacturer {
    
    private int idManufacturer;
    private String name;

    public Manufacturer() {
    }

    public Manufacturer(int idManufacturer, String name) {
        this.idManufacturer = idManufacturer;
        this.name = name;
    }

    public Manufacturer(String name) {
        this.name = name;
    }
    
    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manufacturer{" + "idManufacturer=" + idManufacturer + ", name=" + name + '}';
    }
    
    
        
}
