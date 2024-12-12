
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;


public abstract class Mammals extends Animal{
    protected String breed;

    public Mammals() {
        
    }

    public Mammals(String breed, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species,weight);
        this.breed = breed;
    }

    public Mammals(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species,  weight);
        this.breed = breed;
    }

    public Mammals(Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, int owner, Integer ID_Species, Double weight) {
        super(idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species,   weight);
    }
    
    

 

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    
    
    
}
