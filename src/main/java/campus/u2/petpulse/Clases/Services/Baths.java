
package campus.u2.petpulse.Clases.Services;


public class Baths extends Service {
    
    private Integer idService;
    private String haircutStyle; 
    private boolean nailTrimmingIncluded; 

    public Baths() {
    }

    public Baths(Integer idService, String haircutStyle, boolean nailTrimmingIncluded) {
        this.idService = idService;
        this.haircutStyle = haircutStyle;
        this.nailTrimmingIncluded = nailTrimmingIncluded;
    }

    public Baths(String haircutStyle, boolean nailTrimmingIncluded, Integer ID_Service, String name, String description, Double price, Integer points, ServiceType serviceType) {
        super(ID_Service, name, description, price, points, serviceType);
        this.idService = ID_Service;
        this.haircutStyle = haircutStyle;
        this.nailTrimmingIncluded = nailTrimmingIncluded;
    }
    

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getHaircutStyle() {
        return haircutStyle;
    }

    public void setHaircutStyle(String haircutStyle) {
        this.haircutStyle = haircutStyle;
    }


    public boolean isNailTrimmingIncluded() {
        return nailTrimmingIncluded;
    }

    public void setNailTrimmingIncluded(boolean nailTrimmingIncluded) {
        this.nailTrimmingIncluded = nailTrimmingIncluded;
    }

    @Override
    public String toString() {
        return "Baths{" + "idService=" + idService + ", haircutStyle=" + haircutStyle + ", nailTrimmingIncluded=" + nailTrimmingIncluded + '}';
    }
    
    
 
}
