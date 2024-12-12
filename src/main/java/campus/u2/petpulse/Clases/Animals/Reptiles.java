package campus.u2.petpulse.Clases.Animals;

import campus.u2.petpulse.Clases.Users.Users;
import java.time.LocalDate;

public abstract class Reptiles extends Animal {

    protected String subSpecies;

    public Reptiles() {

    }

    public Reptiles(String subSpecies, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
        this.subSpecies = subSpecies;
    }

    public Reptiles(String subSpecies, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species,  weight);
        this.subSpecies = subSpecies;
    }
    
    

    
    
    

}
