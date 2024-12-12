/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Users;


import java.time.LocalDate;
public class Administrator extends Users {

    private LocalDate hireDate;
    private Boolean state;
    private Integer id_Position;

    public Administrator() {
    }

    public Administrator(Integer id, String name, String id_Card, String address, String phone_Number, String email) {
        super(id, name, id_Card, address, phone_Number, email);
    }

    public Administrator(String name, String id_Card, String address, String phone_Number, String email) {
        super(name, id_Card, address, phone_Number, email);
        
    } 

    public Administrator(Integer id, String name, String id_Card, String address, String phone_Number, String email, String username, String passwordU) {
        super(id, name, id_Card, address, phone_Number, email, username, passwordU);
        
    }
    
    
    
    

   
   

    public Administrator setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Administrator setState(Boolean state) {
        this.state = state;
        return this;
    }

    public Administrator setIdPosition(Integer id_Position) {
        this.id_Position = id_Position;
        return this;
    }

    public void metodoPrueba() {
        System.out.println("Prbando");
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Boolean getState() {
        return state;
    }

    public Integer getId_Position() {
        return id_Position;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getId_Card() {
        return id_Card;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Worker{"
                + "hireDate=" + hireDate
                + ", state=" + state
                + ", id_Position=" + id_Position
                + "} " + super.toString();
    }

}
