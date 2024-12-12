
package campus.u2.petpulse.Clases.Products;



public class MedicalFactory implements AbstractMedicalFactory {

    @Override
    public Medicine createMedicine(Integer ID_Product, Integer dosage, boolean prescriptionRequired, String unitofMeasure, Integer quantityPerPackage, String doseInterval, MedicineType medicineType) {
        return new Medicine(ID_Product, dosage, prescriptionRequired, unitofMeasure, quantityPerPackage, doseInterval, medicineType);
    }

    @Override
    public Vaccine createVaccine(Integer ID_Product, double storageTemperature, AdministrationMethod administrationMethod, Integer numberOfDoses, Integer period) {
        return new Vaccine(ID_Product, storageTemperature, administrationMethod, numberOfDoses, period);
    }

    @Override
    public MedicalMaterial createMedicalMaterial(Integer ID_Product, Integer size, MaterialType materialType, boolean reusable) {
        return new MedicalMaterial(ID_Product, size, materialType, reusable);
    }


  
   

}
