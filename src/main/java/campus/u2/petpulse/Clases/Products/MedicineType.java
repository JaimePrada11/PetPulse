
package campus.u2.petpulse.Clases.Products;

public class MedicineType {
    
    private int idMedicineType;
    private String name;

    public MedicineType(int idMedicineType, String name) {
        this.idMedicineType = idMedicineType;
        this.name = name;
    }

    public MedicineType() {
    }

    public MedicineType(int idMedicineType) {
        this.idMedicineType = idMedicineType;
    }

    
    public MedicineType(String name) {
        this.name = name;
    }

    public int getIdMedicineType() {
        return idMedicineType;
    }

    public void setIdMedicineType(int idMedicineTypee) {
        this.idMedicineType = idMedicineTypee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MedicineType{" + "idMedicineTypee=" + idMedicineType + ", name=" + name + '}';
    }
    
    
}
