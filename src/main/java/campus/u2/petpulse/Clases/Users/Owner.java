package campus.u2.petpulse.Clases.Users;

import campus.u2.petpulse.Clases.Animals.Animal;
import java.util.ArrayList;

public class Owner extends Users {

    private Integer emergencyContacts;
    private Integer Subscription_ID;
    private Integer Loyalty_Points;
    private ArrayList <Animal> petsList;
 
         

    public Owner() {
    }

    public Owner(Integer id, String name, String id_Card, String address, String phone_Number, String email) {
        super(id, name, id_Card, address, phone_Number, email);
    }

    public Owner(String name, String id_Card, String address, String phone_Number, String email) {
        super(name, id_Card, address, phone_Number, email);
        this.emergencyContacts = null;
        this.Loyalty_Points = 0;
        this.Subscription_ID=1;
        this.petsList = new ArrayList<>();
    }

    public Owner(Integer id, String name, String id_Card, String address, String phone_Number, String email, String username, String passwordU) {
        super(id, name, id_Card, address, phone_Number, email, username, passwordU);
        this.emergencyContacts = null;
        this.Loyalty_Points = 0;
        this.Subscription_ID=1;
        this.petsList = new ArrayList<>();
    }

    public Owner(EmergencyContacts emergencyContacts, Integer id, String name, String id_Card, String address, String phone_Number, String email) {
        super(id, name, id_Card, address, phone_Number, email);
        this.emergencyContacts = null;
        this.Loyalty_Points = 0;
        this.Subscription_ID=1;
        this.petsList = new ArrayList<>();
    }

    public ArrayList<Animal> getPetsList() {
        return petsList;
    }

    public void setPetsList(ArrayList<Animal> petsList) {
        this.petsList = petsList;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordU() {
        return passwordU;
    }

    
    
    
    
    public Integer getSubscription_ID() {
        return Subscription_ID;
    }

    public void setSubscription_ID(Integer Subscription_ID) {
        this.Subscription_ID = Subscription_ID;
    }

    public Integer getLoyalty_Points() {
        return Loyalty_Points;
    }

    public void setLoyalty_Points(Integer Loyalty_Points) {
        this.Loyalty_Points = Loyalty_Points;
    }
    
    
    
    
    
    

    public Integer getEmergencyContacts() {
  
        return emergencyContacts;
    }

    public void setEmergencyContacts(Integer emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
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
    public String toString() {
        
        return  super.toString() + "Owner{" + "emergencyContacts=" + emergencyContacts + ", Subscription_ID=" + Subscription_ID + ", Loyalty_Points=" + Loyalty_Points + ", petsList=" + petsList + '}';
    }
    
    

}
