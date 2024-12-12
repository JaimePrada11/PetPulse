
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;


public abstract class Animal {
    
    protected Integer idPet;
    protected String name;
    protected LocalDate birthdate;
    protected Integer age;
    protected String sex;
    protected String photo;
    protected String allergies;
    protected String preExistingConditions;
    protected boolean available;
    protected Integer owner; 
    protected Integer ID_Species;
    protected  Double weight;

    public Animal() {
    }

    public Animal(String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
        this.sex = sex;
        this.photo = photo;
        this.allergies = allergies;
        this.preExistingConditions = preExistingConditions;
        this.available = available;
        this.owner = owner;
        this.ID_Species = ID_Species;
        this.weight =   weight;
    }

    public Animal(Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        this.idPet = idPet;
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
        this.sex = sex;
        this.photo = photo;
        this.allergies = allergies;
        this.preExistingConditions = preExistingConditions;
        this.available = available;
        this.owner = owner;
        this.ID_Species = ID_Species;
        this.weight =weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPreExistingConditions() {
        return preExistingConditions;
    }

    public void setPreExistingConditions(String preExistingConditions) {
        this.preExistingConditions = preExistingConditions;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getID_Species() {
        return ID_Species;
    }

    public void setID_Species(Integer ID_Species) {
        this.ID_Species = ID_Species;
    }

    @Override
    public String toString() {
        return "Animal{" + "idPet=" + idPet + ", name=" + name + ", birthdate=" + birthdate + ", age=" + age + ", sex=" + sex + ", photo=" + photo + ", allergies=" + allergies + ", preExistingConditions=" + preExistingConditions + ", available=" + available + ", owner=" + owner + ", ID_Species=" + ID_Species + '}';
    }
    
    

    
    
    
    
    
}
