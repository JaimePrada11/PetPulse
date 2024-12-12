
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;


public interface AbstractMammalsFactory {

    Dog createDog(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,Double weight);

    Cat createCat(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,Double weight);

    Horses createHorses(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight);

    GuineaPig createGuineaPig(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight);

    
    
    
}
