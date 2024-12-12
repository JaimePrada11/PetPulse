/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Events;

import campus.u2.petpulse.Clases.Users.Users;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class AdoptionEventBuilder {
    private Integer id;
    private String name;
    private LocalDate starDate;
    private LocalDate endDate;
    private String location;
    private Integer idEventType;
 //   private ArrayList<Services> servicesList = new ArrayList<>();
    private ArrayList<Users> usersList = new ArrayList<>();
   // private ArrayList<Animal> petsList = new ArrayList<>();

    public AdoptionEventBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public AdoptionEventBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AdoptionEventBuilder setStarDate(LocalDate starDate) {
        this.starDate = starDate;
        return this;
    }

    public AdoptionEventBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public AdoptionEventBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public AdoptionEventBuilder setIdEventType(Integer idEventType) {
        this.idEventType = idEventType;
        return this;
    }

//    // Métodos para agregar elementos a las listas
//    public AdoptionEventBuilder addService(Services service) {
//        this.servicesList.add(service);
//        return this;
//    }

    public AdoptionEventBuilder addUser(Users user) {
        this.usersList.add(user);
        return this;
    }

//    public AdoptionEventBuilder addPet(Animal pet) {
//        this.petsList.add(pet);
//        return this;
//    }

    public AdoptionEvent build() {
        AdoptionEvent event = new AdoptionEvent(id, name, starDate, endDate, location, idEventType);
        //event.setServicesList(servicesList);
        event.setUsersList(usersList);
        //event.setPetsList(petsList);
        return event;
    }
}