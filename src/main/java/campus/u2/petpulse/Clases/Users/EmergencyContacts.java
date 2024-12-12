/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Users;

import java.util.Comparator;
import java.util.Objects;


public class EmergencyContacts extends Users { 

    public EmergencyContacts() {
    }

    public EmergencyContacts(Integer id, String name, String id_Card, String address, String phone_Number, String email) {
        super(id, name, id_Card, address, phone_Number, email);
    }

    public EmergencyContacts(String name, String id_Card, String address, String phone_Number, String email) {
        super(name, id_Card, address, phone_Number, email);
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
    
    @Override
public boolean equals(Object obj) {
 
    if (this == obj) {
        return true;
    }

    
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }

   
    EmergencyContacts that = (EmergencyContacts) obj;

  
    return this.id != null && this.id.equals(that.id); 
    
}

@Override
public int hashCode() {
    
    return Objects.hash(id); 
}
    
    
    
     
    
    
}

   
