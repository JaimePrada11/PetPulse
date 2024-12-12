
package campus.u2.petpulse.Clases.Products;

import java.time.LocalDate;
import java.util.Date;


public class Medicine extends Product {
    
    private Integer IDProduct;
    private Integer dosage; 
    private boolean prescriptionRequired; 
    private String unitofMeasure; 
    private Integer quantityPerPackage; 
    private String doseInterval;
    private MedicineType medicineType;

    public Medicine() {
    }

    public Medicine(Integer ID_Product, Integer dosage, boolean prescriptionRequired, String unitofMeasure, Integer quantityPerPackage, String doseInterval, MedicineType medicineType) {
        this.IDProduct = ID_Product;
        this.dosage = dosage;
        this.prescriptionRequired = prescriptionRequired;
        this.unitofMeasure = unitofMeasure;
        this.quantityPerPackage = quantityPerPackage;
        this.doseInterval = doseInterval;
        this.medicineType = medicineType;
    }

    public Medicine(Integer dosage, boolean prescriptionRequired, String unitofMeasure, Integer quantityPerPackage, String doseInterval, MedicineType medicineType, Integer idProduct, String SKU, String name, String batch, String manufacturer, LocalDate entryDate, LocalDate dueDate, Integer stock, Double price, ProductType productType) {
        super(idProduct, SKU, name, batch, manufacturer, entryDate, dueDate, stock, price, productType);
        this.IDProduct = idProduct;
        this.dosage = dosage;
        this.prescriptionRequired = prescriptionRequired;
        this.unitofMeasure = unitofMeasure;
        this.quantityPerPackage = quantityPerPackage;
        this.doseInterval = doseInterval;
        this.medicineType = medicineType;
    }

    

    public Integer getID_Product() {
        return IDProduct;
    }

    public void setID_Product(Integer ID_Product) {
        this.IDProduct = ID_Product;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public boolean isPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public String getUnitofMeasure() {
        return unitofMeasure;
    }

    public void setUnitofMeasure(String unitofMeasure) {
        this.unitofMeasure = unitofMeasure;
    }

    public Integer getQuantityPerPackage() {
        return quantityPerPackage;
    }

    public void setQuantityPerPackage(Integer quantityPerPackage) {
        this.quantityPerPackage = quantityPerPackage;
    }

    public String getDoseInterval() {
        return doseInterval;
    }

    public void setDoseInterval(String doseInterval) {
        this.doseInterval = doseInterval;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }    
       
    public double getRecommendedDosage(double weight, double baseDosage, int age) {
        double adjustmentFactor;
        
        if (age < 2) { 
            adjustmentFactor = 0.75;
        } else if (age <= 7) { 
            adjustmentFactor = 1.0;
        } else { 
            adjustmentFactor = 0.85; 
        }

        return weight * baseDosage * adjustmentFactor;
    }


    @Override
    public String toString() {
        return "Medicine{" + "ID_Product=" + IDProduct + ", dosage=" + dosage + ", prescriptionRequired=" + prescriptionRequired + ", unitofMeasure=" + unitofMeasure + ", quantityPerPackage=" + quantityPerPackage + ", doseInterval=" + doseInterval + ", medicineType=" + medicineType + '}';
    }

}
