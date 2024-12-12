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
public class VaccinationEventBuilder {
   private Integer id;
    private String name;
    private LocalDate starDate;
    private LocalDate endDate;
    private String location;
    private Integer idEventType;

    public VaccinationEventBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public VaccinationEventBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public VaccinationEventBuilder setStarDate(LocalDate starDate) {
        this.starDate = starDate;
        return this;
    }

    public VaccinationEventBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public VaccinationEventBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public VaccinationEventBuilder setIdEventType(Integer idEventType) {
        this.idEventType = idEventType;
        return this;
    }

    public VaccinationEvent build() {
        return new VaccinationEvent(id, name, starDate, endDate, location, idEventType);
    }
}