
package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;


public class PreOperatory extends Service {
    
    private Integer idService;
    private Procedure procedure;
    private String analysis;
    private LocalDate estimatedTime; 

    public PreOperatory(Procedure procedure, String analysis, LocalDate estimatedTime, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.idService = ID_Service;
        this.procedure = procedure;
        this.analysis = analysis;
        this.estimatedTime = estimatedTime;
    }


    public PreOperatory(Integer idService, Procedure procedure, String analysis, LocalDate estimatedTime) {
        this.idService = idService;
        this.procedure = procedure;
        this.analysis = analysis;
        this.estimatedTime = estimatedTime;
    }

    public PreOperatory() {
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public LocalDate getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(LocalDate estimatedTime) {
        this.estimatedTime = estimatedTime;
    }


    public boolean isPreparationComplete(LocalDate elapsedTime) {
    if (estimatedTime == null || elapsedTime == null) {
        throw new IllegalArgumentException("The preparation date or the elapsed time cannot be null.");
    }
    
    if (estimatedTime.isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("The estimated preparation date cannot be a past date.");
    }

    return !elapsedTime.isBefore(estimatedTime);
}


    @Override
    public String toString() {
        return "PreOperatory{" + "idService=" + idService + ", procedure=" + procedure + ", analysis=" + analysis + ", estimatedTime=" + estimatedTime + '}';
    }
    
    

}
