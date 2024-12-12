/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Users;

import java.time.LocalDate;



/**
 *
 * @author alrip
 */
public class NormalcoworkerBuilder {

    private Integer id;
    private String name;
    private String idCard;
    private String address;
    private String phone_Number;
    private String email;
    private LocalDate hireDate;
    private Boolean state;
    private Integer id_Position;
    protected String username;
    protected String  passwordU;

    public NormalcoworkerBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public NormalcoworkerBuilder setname(String name) {
        this.name = name;
        return this;
    }

    public NormalcoworkerBuilder setIdCard(String idCard) {
        this.idCard = idCard;
        return this;

    }

    public NormalcoworkerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public NormalcoworkerBuilder setPhoneNumber(String phone_Number) {
        this.phone_Number = phone_Number;
        return this;
    }

    public NormalcoworkerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
      public NormalcoworkerBuilder setPassword(String username ){
        this.username = username;
        return  this;
               
    }
    
    public NormalcoworkerBuilder setPasswordU(String passwordU){
        this.passwordU = passwordU;
        return this;
 
    }

// Metodos de atributos no comunes
    public NormalcoworkerBuilder setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public NormalcoworkerBuilder setState(Boolean state) {
        this.state = state;
        return this;
    }

    public NormalcoworkerBuilder setIdPosition(Integer id_Position) {
        this.id_Position = id_Position;
        return this;
    }

    public Normalcoworker build() {

        Normalcoworker normalcoworker = new Normalcoworker(id, name, idCard, address, phone_Number, email,username,passwordU);
        normalcoworker.setHireDate(hireDate);
        normalcoworker.setState(state);
        normalcoworker.setIdPosition(id_Position);
        return normalcoworker;

    }
}
