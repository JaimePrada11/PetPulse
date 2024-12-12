
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;


public abstract class Birds extends Animal {
    
    protected String variant;

    public Birds() {
        
    }

    public Birds(String variant, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        super(name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
        this.variant = variant;
    }

    public Birds(String variant, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        super(idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
        this.variant = variant;
    }
    
    
    
}
