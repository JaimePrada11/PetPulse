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
public class EstirilizationBuilder {
    
private Integer id;
    private String name;
    private LocalDate starDate;
    private LocalDate endDate;
    private String location;
    private Integer idEventType;

    public EstirilizationBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public EstirilizationBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EstirilizationBuilder setStarDate(LocalDate starDate) {
        this.starDate = starDate;
        return this;
    }

    public EstirilizationBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public EstirilizationBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public EstirilizationBuilder setIdEventType(Integer idEventType) {
        this.idEventType = idEventType;
        return this;
    }

    public EstirilizationEvent build() {
        return new EstirilizationEvent(id, name, starDate, endDate, location, idEventType);
    }
}