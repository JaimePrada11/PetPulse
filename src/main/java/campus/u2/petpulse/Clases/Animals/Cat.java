/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Animals;

import java.time.LocalDate;


public class Cat extends Mammals {

    public Cat() {
    }

    public Cat(String breed, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species, Double weight) {
        super(breed, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species, weight);
    }

    public Cat(String breed, Integer idPet, String name, LocalDate birthdate, Integer age, String sex, String photo, String allergies, String preExistingConditions, boolean available, Integer owner, Integer ID_Species,  Double weight) {
        super(breed, idPet, name, birthdate, age, sex, photo, allergies, preExistingConditions, available, owner, ID_Species,weight);
    }
    

    
}
