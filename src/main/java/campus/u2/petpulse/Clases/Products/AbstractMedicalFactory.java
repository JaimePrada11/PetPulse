
package campus.u2.petpulse.Clases.Products;

import java.util.Date;


public interface AbstractMedicalFactory {
    
    Medicine createMedicine(Integer ID_Product, Integer dosage, boolean prescriptionRequired, String unitofMeasure, Integer quantityPerPackage, String doseInterval, MedicineType medicineType);
    Vaccine createVaccine (Integer ID_Product, double storageTemperature, AdministrationMethod administrationMethod, Integer numberOfDoses, Integer period);
    MedicalMaterial createMedicalMaterial(Integer ID_Product, Integer size, MaterialType materialType, boolean reusable);

}
