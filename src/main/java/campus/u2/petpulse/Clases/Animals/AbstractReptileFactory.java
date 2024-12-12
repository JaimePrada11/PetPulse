
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;


public interface AbstractReptileFactory {
    
    
    Iguana createIguana(String subSpecies, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weigth );

    Snake createSnake(String subSpecies, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,Double weigth);
    
    
}
