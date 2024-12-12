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
public abstract class Event {

    protected Integer id;
    protected String name;
    protected LocalDate starDate;
    protected LocalDate endDate;
    protected String location;
    protected Integer ID_EventType;
    //protected ArrayList<Services> servicesList; 
    protected ArrayList<Users> usersList;       
   // protected ArrayList<Animal> petsList;       

    // Constructor sin parámetros
//    public Event() {
//        this.servicesList = new ArrayList<>();
//        this.usersList = new ArrayList<>();
//        this.petsList = new ArrayList<>();
//    }

    public Event() {
    }
    

    // Constructor con parámetros
    public Event(String name, LocalDate starDate, LocalDate endDate, String location, Integer ID_EventType) {
        //this();
        this.name = name;
        this.starDate = starDate;
        this.endDate = endDate;
        this.location = location;
        this.ID_EventType = ID_EventType;
    }

    // Constructor con todos los parámetros
    public Event(Integer id, String name, LocalDate starDate, LocalDate endDate, String location, Integer ID_EventType) {
        this(name, starDate, endDate, location, ID_EventType);
        this.id = id;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getID_EventType() {
        return ID_EventType;
    }

    public void setID_EventType(Integer ID_EventType) {
        this.ID_EventType = ID_EventType;
    }

//    public ArrayList<Services> getServicesList() {
//        return servicesList;
//    }
//
//    public void setServicesList(ArrayList<Services> servicesList) {
//        this.servicesList = servicesList;
//    }

    public ArrayList<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<Users> usersList) {
        this.usersList = usersList;
    }

//    public ArrayList<Animal> getPetsList() {
//        return petsList;
//    }
//
//    public void setPetsList(ArrayList<Animal> petsList) {
//        this.petsList = petsList;
//    }
}