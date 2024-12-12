/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Services;

import java.time.LocalDate;


public class PostOperatory extends Service {

    private Integer idService;
    private LocalDate nextControlAppointments;
    private Procedure procedure;
    private String recoveryStatus;
    private String postOpCareInstructions;

    public PostOperatory() {
    }

    
    public PostOperatory(LocalDate nextControlAppointments, Procedure procedure, String recoveryStatus, String postOpCareInstructions, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.idService = ID_Service;
        this.nextControlAppointments = nextControlAppointments;
        this.procedure = procedure;
        this.recoveryStatus = recoveryStatus;
        this.postOpCareInstructions = postOpCareInstructions;
    }

    public PostOperatory(Integer idService, LocalDate nextControlAppointments, Procedure procedure, String recoveryStatus, String postOpCareInstructions) {
        this.idService = idService;
        this.nextControlAppointments = nextControlAppointments;
        this.procedure = procedure;
        this.recoveryStatus = recoveryStatus;
        this.postOpCareInstructions = postOpCareInstructions;
    }
    
    

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public LocalDate getNextControlAppointments() {
        return nextControlAppointments;
    }

    public void setNextControlAppointments(LocalDate nextControlAppointments) {
        this.nextControlAppointments = nextControlAppointments;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public String getRecoveryStatus() {
        return recoveryStatus;
    }

    public void setRecoveryStatus(String recoveryStatus) {
        this.recoveryStatus = recoveryStatus;
    }

    public String getPostOpCareInstructions() {
        return postOpCareInstructions;
    }

    public void setPostOpCareInstructions(String postOpCareInstructions) {
        this.postOpCareInstructions = postOpCareInstructions;
    }

    public boolean isRecoveryComplete() {
        return "Recovered".equalsIgnoreCase(recoveryStatus);
    }

    public void updateRecoveryStatus(String newStatus) {
        this.recoveryStatus = newStatus;
    }

    @Override
    public String toString() {
        return "PostOperatory{" + "idService=" + idService + ", nextControlAppointments=" + nextControlAppointments + ", procedure=" + procedure + ", recoveryStatus=" + recoveryStatus + ", postOpCareInstructions=" + postOpCareInstructions + '}';
    }
    
    
 
}
