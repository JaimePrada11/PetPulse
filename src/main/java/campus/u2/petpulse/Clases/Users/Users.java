/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Users;

public abstract class Users {
    
    protected  Integer id;
    protected String name;
    protected String id_Card;
    protected String address;
    protected String phone_Number;
    protected String email;
    protected String username;
    protected String  passwordU;

    public Users() {
    }
    
    

    public Users(Integer id, String name, String id_Card, String address, String phone_Number, String email, String username, String passwordU) {
        this.id = id;
        this.name = name;
        this.id_Card = id_Card;
        this.address = address;
        this.phone_Number = phone_Number;
        this.email = email;
        this.username = username;
        this.passwordU = passwordU;
    }
    
    
    

    public Users(String name, String id_Card, String address, String phone_Number, String email) {
        this.name = name;
        this.id_Card = id_Card;
        this.address = address;
        this.phone_Number = phone_Number;
        this.email = email;
    }
    
    

    public Users(Integer id, String name, String id_Card, String address, String phone_Number, String email) {
        this.id = id;
        this.name = name;
        this.id_Card = id_Card;
        this.address = address;
        this.phone_Number = phone_Number;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", id_Card=" + id_Card + ", address=" + address + ", phone_Number=" + phone_Number + ", email=" + email + ", username=" + username + ", passwordU=" + passwordU + '}';
    }

  
   
    
}
