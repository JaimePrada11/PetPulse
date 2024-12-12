
package campus.u2.petpulse.Clases.Appointments;


public class State {
    
    private Integer idState;
    private String name;

    public State() {
    }

    public State(Integer idState, String name) {
        this.idState = idState;
        this.name = name;
    }

    public State(Integer idState) {
        this.idState = idState;
    }

    public State(String name) {
        this.name = name;
    }
    
    
    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" + "idState=" + idState + ", name=" + name + '}';
    }
    
    
}
