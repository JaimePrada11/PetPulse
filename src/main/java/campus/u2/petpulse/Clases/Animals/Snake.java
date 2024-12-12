/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Animals;

import campus.u2.petpulse.Clases.Users.Users;
import java.time.LocalDate;

/**
 *
 * @author alrip
 */
public class Snake extends Reptiles{

    public Snake() {
    }

    public Snake(String subSpecies, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(subSpecies, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
    }

    public Snake(String subSpecies, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,Double weight ) {
        super(subSpecies, idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
    }
    
    
    
}
