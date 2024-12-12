package campus.u2.petpulse.Clases.Animals;

public class Attributes {

    private Integer id;
    private String name;
    private Integer idSubcategory;

    public Attributes() {
    }

    public Attributes(String name, Integer idSubcategory) {
        this.name = name;
        this.idSubcategory = idSubcategory;
    }

    public Attributes(Integer id, String name, Integer idSubcategory) {
        this.id = id;
        this.name = name;
        this.idSubcategory = idSubcategory;
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

    public Integer getIdSubcategory() {
        return idSubcategory;
    }

    public void setIdSubcategory(Integer idSubcategory) {
        this.idSubcategory = idSubcategory;
    }

    @Override
    public String toString() {
        return "Attributes{" + "id=" + id + ", name=" + name + '}';
    }
    
    

}

