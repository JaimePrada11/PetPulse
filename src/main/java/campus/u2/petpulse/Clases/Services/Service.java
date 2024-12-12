package campus.u2.petpulse.Clases.Services;

import java.util.List;

public class Service {

    private Integer ID_Service;
    private String name;
    private String description;
    private Double price;
    private Integer points;
    private ServiceType serviceType;
    private List<Service> subService;

    public Service() {
    }

    public Service(Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        this.ID_Service = ID_Service;
        this.name = name;
        this.description = description;
        this.price = price;
        this.points = points;
        this.serviceType = serviceType;
    }

    public Service(String name, String description, Double price, Integer points, ServiceType serviceType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.points = points;
        this.serviceType = serviceType;
    }
    
    

    public Integer getID_Service() {
        return ID_Service;
    }

    public void setID_Service(Integer ID_Service) {
        this.ID_Service = ID_Service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Service{" + "ID_Service=" + ID_Service + ", name=" + name + ", description=" + description + ", price=" + price + ", points=" + points + ", serviceType=" + serviceType + '}';
    }

    
    public void addService(Service Service) {
        subService.add(Service);
    }

    public void removeService(Service Service) {
        subService.remove(Service);
    }
    
    public List<Service> obtenerSubservicios() {
        return subService ;
    }

}
