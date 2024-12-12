package campus.u2.petpulse.Clases.Products;


public class PetFood extends Product {
    
    private Integer ID_Product;
    private double weight;
    private Integer calories;
    private Boolean isOrganic;

    public PetFood(Integer ID_Product, double weight, Integer calories, Boolean isOrganic) {
        this.ID_Product = ID_Product;
        this.weight = weight;
        this.calories = calories;
        this.isOrganic = isOrganic;
    }

    
    public PetFood() {
    }

    public Integer getID_Product() {
        return ID_Product;
    }

    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }

    
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Boolean getIsOrganic() {
        return isOrganic;
    }

    public void setIsOrganic(Boolean isOrganic) {
        this.isOrganic = isOrganic;
    }

    @Override
    public String toString() {
        return "PetFood{" + "weight=" + weight + ", calories=" + calories + ", isOrganic=" + isOrganic + '}';
    }



    public double adjustPortionSize(double petWeight) {
        if (petWeight < 5) {
            return 50;
        } else if (petWeight >= 5 && petWeight <= 20) {
            return 100;
        } else {
            return 200;
        }
    }

    public double calculateCaloriesPerPortion(double portionWeight) {
        return (portionWeight / weight) * calories;
    }

    public double convertWeightToPounds() {
        return weight * 2.20462; // 1 kg = 2.20462 libras
    }


}
