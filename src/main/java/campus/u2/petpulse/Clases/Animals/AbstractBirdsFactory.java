
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;


public interface AbstractBirdsFactory {
    
 Guacamaya createGuacamaya(String variant, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight);

    Parrot createParrot(String variant, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weigth);

    
}
