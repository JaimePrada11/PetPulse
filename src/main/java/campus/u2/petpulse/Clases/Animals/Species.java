
package campus.u2.petpulse.Clases.Animals;


public class Species {
    
    private Integer ID_Species;
    private String SpeciesName;

    public Species() {
    }

    public Species(String SpeciesName) {
        this.SpeciesName = SpeciesName;
    }
    
    
    public Species(Integer ID_Species, String SpeciesName) {
        this.ID_Species = ID_Species;
        this.SpeciesName = SpeciesName;
    }

    public Integer getID_Species() {
        return ID_Species;
    }

    public void setID_Species(Integer ID_Species) {
        this.ID_Species = ID_Species;
    }

    public String getSpeciesName() {
        return SpeciesName;
    }

    public void setSpeciesName(String SpeciesName) {
        this.SpeciesName = SpeciesName;
    }

    @Override
    public String toString() {
        return "Species{" + "ID_Species=" + ID_Species + ", SpeciesName=" + SpeciesName + '}';
    }
    
    
    
    
    
    
    
    
}
