/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Users;


import java.time.LocalDate;

public class Veterinarian extends Users {

    private LocalDate hireDate;
    private Boolean state;
    private Integer id_Position; 
    
    

    public Veterinarian() {
    }
    


    public Veterinarian(Integer id, String name, String id_Card, String address, String phone_Number, String email) {
        super(id, name, id_Card, address, phone_Number, email);
    }

    public Veterinarian(Integer id, String name, String id_Card, String address, String phone_Number, String email, String username, String passwordU) {
        super(id, name, id_Card, address, phone_Number, email, username, passwordU);
    }

    public Veterinarian(String name, String id_Card, String address, String phone_Number, String email) {
        super(name, id_Card, address, phone_Number, email);
    }
    
    
    
    
    public Veterinarian setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Veterinarian setState(Boolean state) {
        this.state = state;
        return this;
    }

    public Veterinarian setIdPosition(Integer id_Position) {
        this.id_Position = id_Position;
        return this;
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

    public String getId_Card() {
        return id_Card;
    }

    public void setId_Card(String id_Card) {
        this.id_Card = id_Card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
   
        
        
  
    
    

}
