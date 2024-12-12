
package campus.u2.petpulse.Clases.Animals;

import campus.u2.petpulse.Clases.Users.Users;
import java.time.LocalDate;


public class ReptileFactory implements AbstractReptileFactory{

    @Override
    public Iguana createIguana(String subSpecies, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        return new Iguana( subSpecies,  idPet,  name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species,  weight);
    }

    @Override
    public Snake createSnake(String subSpecies, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        return new Snake( subSpecies,  idPet,  name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species, weight);
    }
    
    
    
}
