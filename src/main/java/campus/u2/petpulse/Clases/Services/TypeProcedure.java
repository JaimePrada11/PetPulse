
package campus.u2.petpulse.Clases.Services;


public class TypeProcedure {
    
    private Integer id;
    private String name;

    public TypeProcedure() {
    }

    public TypeProcedure(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeProcedure(String name) {
        this.name = name;
    }

    public TypeProcedure(Integer id) {
        this.id = id;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeProcedure{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
