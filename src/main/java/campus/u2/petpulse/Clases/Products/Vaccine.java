package campus.u2.petpulse.Clases.Products;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Vaccine extends Product {
    
    private Integer ID_Product;
    private Double storageTemperature;
    private AdministrationMethod administrationMethod;
    private Integer numberOfDoses;
    private Integer period;

    public Vaccine() {
    }
    
    public Vaccine(Integer ID_Product, double storageTemperature, AdministrationMethod administrationMethod, Integer numberOfDoses, Integer period) {
        this.ID_Product = ID_Product;
        this.storageTemperature = storageTemperature;
        this.administrationMethod = administrationMethod;
        this.numberOfDoses = numberOfDoses;
        this.period = period;
    }

    public Vaccine(Integer ID_Product, Double storageTemperature, AdministrationMethod administrationMethod, Integer numberOfDoses, Integer period) {
        this.ID_Product = ID_Product;
        this.storageTemperature = storageTemperature;
        this.administrationMethod = administrationMethod;
        this.numberOfDoses = numberOfDoses;
        this.period = period;
    }

    
    
    public Vaccine(Double storageTemperature, AdministrationMethod administrationMethod, Integer numberOfDoses, Integer period, Integer idProduct, String SKU, String name, String batch, String manufacturer, LocalDate entryDate, LocalDate dueDate, Integer stock, Double price, ProductType productType) {
        super(idProduct, SKU, name, batch, manufacturer, entryDate, dueDate, stock, price, productType);
        this.ID_Product = idProduct;
        this.storageTemperature = storageTemperature;
        this.administrationMethod = administrationMethod;
        this.numberOfDoses = numberOfDoses;
        this.period = period;
    }

    
    
    // Getters and setters

    public Integer getID_Product() {
        return ID_Product;
    }

    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }

    public Double getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature(Double storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    

    public AdministrationMethod getAdministrationMethod() {
        return administrationMethod;
    }

    public void setAdministrationMethod(AdministrationMethod administrationMethod) {
        this.administrationMethod = administrationMethod;
    }

    public Integer getNumberOfDoses() {
        return numberOfDoses;
    }

    public void setNumberOfDoses(int numberOfDoses) {
        this.numberOfDoses = numberOfDoses;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
    
  
    public boolean isDosesComplete(int dosesAdministered) {
        return dosesAdministered >= numberOfDoses;
    }

    public Date getNextDose(Date lastAdministeredDate, int doseNumber) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastAdministeredDate);

        if (doseNumber < numberOfDoses) {
            calendar.add(Calendar.DAY_OF_YEAR, period);
        }

        return calendar.getTime();
    }

    @Override
    public String toString() {
        return "Vaccine{" + "ID_Product=" + ID_Product + ", storageTemperature=" + storageTemperature + ", administrationMethod=" + administrationMethod + ", numberOfDoses=" + numberOfDoses + ", period=" + period + '}';
    }

}
