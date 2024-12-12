
package campus.u2.petpulse.Clases.Services;

public class Procedure extends Service {
    
    private Integer ID_Service;
    private TypeProcedure procedureTypes;
    private String recoveryTime;


    public Procedure() {
    }

    public Procedure(Integer ID_Service, TypeProcedure procedureTypes, String recoveryTime, Integer IDService, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.ID_Service = ID_Service;
        this.procedureTypes = procedureTypes;
        this.recoveryTime = recoveryTime;
    }

    public Procedure(Integer ID_Service, TypeProcedure procedureTypes, String recoveryTime) {
        this.ID_Service = ID_Service;
        this.procedureTypes = procedureTypes;
        this.recoveryTime = recoveryTime;
    }

    public Procedure(TypeProcedure procedureTypes, String recoveryTime, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.ID_Service= ID_Service;
        this.procedureTypes = procedureTypes;
        this.recoveryTime = recoveryTime;
    }


    // Getters and Setters

    @Override
    public Integer getID_Service() {
        return ID_Service;
    }

    @Override
    public void setID_Service(Integer ID_Service) {
        this.ID_Service = ID_Service;
    }

    public TypeProcedure getProcedureTypes() {
        return procedureTypes;
    }

    public void setProcedureTypes(TypeProcedure procedureTypes) {
        this.procedureTypes = procedureTypes;
    }

    public String getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(String recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    @Override
    public String toString() {
        return "Procedure{" + "ID_Service=" + ID_Service + ", procedureTypes=" + procedureTypes + ", recoveryTime=" + recoveryTime + '}';
    }

  
    
    
}
