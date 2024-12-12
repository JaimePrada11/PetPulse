package campus.u2.petpulse.Clases.Appointments;

import campus.u2.petpulse.Clases.Animals.Animal;
import campus.u2.petpulse.Clases.Services.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Appointment {

    private Integer idAppointment;
    private LocalDateTime dateAppointment;
    private String reason;
    private State state;
    private Animal mascota;
    private List<Service> services;

    public Appointment() {
    }

    public Appointment(Integer idAppointment, LocalDateTime dateAppointment, String reason, State state, Animal mascota) {
        this.idAppointment = idAppointment;
        this.dateAppointment = dateAppointment;
        this.reason = reason;
        this.state = state;
        this.mascota = mascota;
        this.services = new ArrayList<>();
    }

    public Appointment(LocalDateTime dateAppointment, String reason, State state, Animal mascota) {
        this.dateAppointment = dateAppointment;
        this.reason = reason;
        this.state = state;
        this.mascota = mascota;
        this.services = new ArrayList<>();
    }

    public Integer getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Integer idAppointment) {
        this.idAppointment = idAppointment;
    }

    
    
    public LocalDateTime getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(LocalDateTime dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Animal getMascota() {
        return mascota;
    }

    public void setMascota(Animal mascota) {
        this.mascota = mascota;
    }
    
    public void addService(Service service) {
        services.add(service);
    }
    
    public void removeService(Service service) {
        services.add(service);
    }
    
    public List<Service> getServices() {
        return services;
    }
    

    @Override
    public String toString() {
        return "Appointment{" + "idAppointment=" + idAppointment + ", dateAppointment=" + dateAppointment + ", reason=" + reason + ", state=" + state + ", mascota=" + mascota + '}';
    }

}
