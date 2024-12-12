
package campus.u2.petpulse.Clases.Services;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class Training extends Service {
    
    private Integer idService;
    private String results;
    private LocalTime durationSession; 
    private int totalSessions;

    public Training() {
    }

    public Training(Integer idService, String results, LocalTime durationSession, int totalSessions) {
        this.idService = idService;
        this.results = results;
        this.durationSession = durationSession;
        this.totalSessions = totalSessions;
    }

    public Training(String results, LocalTime durationSession, int totalSessions, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.idService = ID_Service;
        this.results = results;
        this.durationSession = durationSession;
        this.totalSessions = totalSessions;
    }
    
        // Getters y Setters

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public LocalTime getDurationSession() {
        return durationSession;
    }

    public void setDurationSession(LocalTime durationSession) {
        this.durationSession = durationSession;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }

    public boolean isTrainingComplete(int completedSessions) {
        return completedSessions >= totalSessions;
    }

    @Override
    public String toString() {
        return "Training{" + "idService=" + idService + ", results=" + results + ", durationSession=" + durationSession + ", totalSessions=" + totalSessions + '}';
    }
    
    
}
