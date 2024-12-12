/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Events;

import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class AdoptionEvent extends Event {

    public AdoptionEvent() {
        super();
    }

    public AdoptionEvent(Integer id, String name, LocalDate starDate, LocalDate endDate, String location, Integer idEventType) {
        super(id, name, starDate, endDate, location, idEventType);
    }

    public AdoptionEvent(String name, LocalDate starDate, LocalDate endDate, String location, Integer idEventType) {
        super(name, starDate, endDate, location, idEventType);
    }

    @Override
    public String toString() {
        return "AdoptionEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", ID_EventType=" + ID_EventType +
               // ", servicesList=" + servicesList +
                ", usersList=" + usersList +
               // ", petsList=" + petsList +
                '}';
    }
}