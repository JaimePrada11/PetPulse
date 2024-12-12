
package campus.u2.petpulse.Clases.Animals;

import campus.u2.petpulse.Clases.Users.Users;
import java.time.LocalDate;


public class Guacamaya extends Birds{

    public Guacamaya() {
    }
    
    

    public Guacamaya(String variant, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        super(variant, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
    }

    public Guacamaya(String variant, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        super(variant, idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species,weight);
    }
    
    
    
}
