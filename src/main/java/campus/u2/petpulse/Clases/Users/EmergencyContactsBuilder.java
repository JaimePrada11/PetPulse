/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Clases.Users;

public class EmergencyContactsBuilder {

    private Integer id;
    private String name;
    private String idCard;
    private String address;
    private String phone_Number;
    private String email;

    public EmergencyContactsBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public EmergencyContactsBuilder setName(String name) { 
        this.name = name;
        return this;
    }

    public EmergencyContactsBuilder setIdCard(String idCard) {
        this.idCard = idCard;
        return this;

    }

    public EmergencyContactsBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmergencyContactsBuilder setPhoneNumber(String phone_Number) {
        this.phone_Number = phone_Number;
        return this;
    }

    public EmergencyContactsBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmergencyContacts build() {

        EmergencyContacts emergencyContacts = new EmergencyContacts(id, name, idCard, address, phone_Number, email);
        return emergencyContacts;
    }

}
