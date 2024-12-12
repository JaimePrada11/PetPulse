
package campus.u2.petpulse.Clases.Services;


public class ServiceType {
    
    private Integer idServiceType;
    private String name;

    public ServiceType() {
    }

    public ServiceType(Integer idServiceType, String name) {
        this.idServiceType = idServiceType;
        this.name = name;
    }

    public ServiceType(String name) {
        this.name = name;
    }

    public ServiceType(Integer idServiceType) {
        this.idServiceType = idServiceType;
    }
    
    

    public Integer getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(Integer idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "ServiceType{" + "idServiceType=" + idServiceType + ", name=" + name + '}';
    }
    
    
}
