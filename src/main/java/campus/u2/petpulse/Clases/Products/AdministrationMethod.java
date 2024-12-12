
package campus.u2.petpulse.Clases.Products;


public class AdministrationMethod {
   private int idAdministrationMethod;
   private String name;

    public AdministrationMethod(int idAdministrationMethod, String name) {
        this.idAdministrationMethod = idAdministrationMethod;
        this.name = name;
    }

    public AdministrationMethod(String name) {
        this.name = name;
    }

    public AdministrationMethod(int idAdministrationMethod) {
        this.idAdministrationMethod = idAdministrationMethod;
    }
    

    public AdministrationMethod() {
    }

    public int getIdAdministrationMethod() {
        return idAdministrationMethod;
    }

    public void setIdAdministrationMethod(int idAdministrationMethod) {
        this.idAdministrationMethod = idAdministrationMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdministrationMethod{" + "idAdministrationMethod=" + idAdministrationMethod + ", name=" + name + '}';
    }
   
}
