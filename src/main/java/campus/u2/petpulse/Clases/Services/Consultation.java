package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;

public class Consultation extends Service {

    private Integer IDService;
    private String reason;
    private String diagnosis;
    private String recommendations;
    private LocalDate consultationDate;

    public Consultation() {        

    }

    public Consultation(Integer id, String name, String description, Double price, Integer points, ServiceType serviceType,
            String reason, String diagnosis, String recommendations, LocalDate consultationDate) {
        super(id, name, description, price, points, serviceType);
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.recommendations = recommendations;
        this.consultationDate = consultationDate;
    }

    public Consultation(String reason, String diagnosis, String recommendations, LocalDate consultationDate, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.IDService = ID_Service;
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.recommendations = recommendations;
        this.consultationDate = consultationDate;
    }

    public Consultation(Integer IDService, String reason, String diagnosis, String recommendations, LocalDate consultationDate) {
        this.IDService = IDService;
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.recommendations = recommendations;
        this.consultationDate = consultationDate;

    }

    public Integer getIDService() {
        return IDService;
    }

    public void setIDService(Integer ID_Service) {
        this.IDService = ID_Service;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public void updateDiagnosis(String newDiagnosis) {
        this.diagnosis = newDiagnosis;
    }

    public void scheduleConsultation(LocalDate newDate) {
        this.consultationDate = newDate;
    }

    @Override
    public String toString() {
        return "Consultation{" + "IDService=" + IDService + ", reason=" + reason + ", diagnosis=" + diagnosis + ", recommendations=" + recommendations + ", consultationDate=" + consultationDate + '}';
    }

    
}
