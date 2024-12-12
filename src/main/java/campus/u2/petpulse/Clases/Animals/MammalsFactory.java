
package campus.u2.petpulse.Clases.Animals;

import campus.u2.petpulse.Clases.Users.Users;
import java.time.LocalDate;




public class MammalsFactory  implements AbstractMammalsFactory {

    @Override
    public Dog createDog(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
       return new Dog( breed,idPet,  name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species, weight);
    }

    
    @Override
    public Cat createCat(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species ,Double weight) {
       return new Cat( breed, idPet,  name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species, weight);
    }


    @Override
    public Horses createHorses(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        return new Horses( breed,  idPet, name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species, weight);
    }


    @Override
    public GuineaPig createGuineaPig(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        return new GuineaPig ( breed,idPet,  name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species,weight);
    }

    
    
}
