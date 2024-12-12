
package campus.u2.petpulse.Clases.Animals;

import campus.u2.petpulse.Clases.Users.Users;
import java.time.LocalDate;


public class GuineaPig  extends Mammals{

    public GuineaPig() {
    }

    public GuineaPig(String breed, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(breed, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species,  weight);
    }

    public GuineaPig(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(breed, idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
    }
    
}
