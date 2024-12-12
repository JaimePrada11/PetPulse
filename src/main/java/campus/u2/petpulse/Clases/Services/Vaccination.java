package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;

public class Vaccination extends Service {

    private Integer idService;
    private LocalDate applicationDate;
    private LocalDate nextDoseDate;

    public Vaccination() {
    }

    public Vaccination(Integer idService, LocalDate applicationDate, LocalDate nextDoseDate) {
        this.idService = idService;
        this.applicationDate = applicationDate;
        this.nextDoseDate = nextDoseDate;
    }

    public Vaccination(LocalDate applicationDate, LocalDate nextDoseDate, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.idService = ID_Service;
        this.applicationDate = applicationDate;
        this.nextDoseDate = nextDoseDate;
    }

    // Getters and Setters
    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getNextDoseDate() {
        return nextDoseDate;
    }

    public void setNextDoseDate(LocalDate nextDoseDate) {
        this.nextDoseDate = nextDoseDate;
    }

    public boolean checkVaccineStatus() {
        LocalDate today = LocalDate.now();
        return today.isBefore(nextDoseDate);
    }

    @Override
    public String toString() {
        return "Vaccination{" + "idService=" + idService + ", applicationDate=" + applicationDate + ", nextDoseDate=" + nextDoseDate + '}';
    }

}
