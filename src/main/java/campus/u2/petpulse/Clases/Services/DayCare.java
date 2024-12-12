
package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;


public class DayCare extends Service {
    
    private Integer idService;
    private String specialConditions;
    private LocalDate startDate;
    private LocalDate endDate;

    public DayCare() {
    }

    public DayCare(Integer idService, String specialConditions, LocalDate startDate, LocalDate endDate) {
        this.idService = idService;
        this.specialConditions = specialConditions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DayCare(String specialConditions, LocalDate startDate, LocalDate endDate, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.specialConditions = specialConditions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }
    
    public String getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DayCare{" + "idService=" + idService + ", specialConditions=" + specialConditions + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    

}

