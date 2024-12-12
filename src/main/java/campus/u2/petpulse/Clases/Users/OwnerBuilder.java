package campus.u2.petpulse.Clases.Users;

import campus.u2.petpulse.Clases.Animals.Animal;
import campus.u2.petpulse.Clases.Events.AdoptionEventBuilder;
import java.util.ArrayList;

public class OwnerBuilder {

    private Integer id;
    private String name;
    private String idCard;
    private String address;
    private String phone_Number;
    private String email;
    private EmergencyContacts emergencyContacts;
    private String username;
    private String passwordU;
    private Integer Subscription_ID;
    private Integer Loyalty_Points;
    private ArrayList <Animal> petsList;

    public OwnerBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public OwnerBuilder setname(String name) {
        this.name = name;
        return this;
    }

    public OwnerBuilder setIdCard(String idCard) {
        this.idCard = idCard;
        return this;

    }

    public OwnerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public OwnerBuilder setPhoneNumber(String phone_Number) {
        this.phone_Number = phone_Number;
        return this;
    }

    public OwnerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public OwnerBuilder setUsername(String username) {
        this.username = username;
        return this;

    }

    public OwnerBuilder setPasswordU(String passwordU) {
        this.passwordU = passwordU;
        return this;

    }

    public OwnerBuilder setSubscription_ID(Integer Subscription_ID) {
        this.Subscription_ID = Subscription_ID;
        return this;

    }

    public OwnerBuilder setLoyalty_Points(Integer Loyalty_Points) {
        this.Loyalty_Points = Loyalty_Points;
        return this;

    }
    
   public OwnerBuilder addPet(Animal pet) {
        this.petsList.add(pet);
        return this;
    }

    public Owner build() {

        Owner owner = new Owner(id, name, idCard, address, phone_Number, email, username, passwordU);
        owner.setPetsList(petsList);
        return owner;
    }

}
