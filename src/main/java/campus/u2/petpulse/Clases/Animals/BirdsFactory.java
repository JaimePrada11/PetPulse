/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;

/**
 *
 * @author alrip
 */
public class BirdsFactory implements AbstractBirdsFactory{

   
    @Override
    public Guacamaya createGuacamaya(String variant, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        return new Guacamaya( variant,  idPet,  name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species, weight);
    }


    @Override
    public Parrot createParrot(String variant, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        return new Parrot(variant,  idPet,  name,  birthdate,  age,  sex,  photo,  allergies,  preExistingConditions,  available,  owner,  ID_Species,  weight);
    }
    
}
