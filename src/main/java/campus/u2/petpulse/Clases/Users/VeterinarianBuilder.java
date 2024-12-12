package campus.u2.petpulse.Clases.Users;


import java.time.LocalDate;

public class VeterinarianBuilder {

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
    protected String passwordU;

    public VeterinarianBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public VeterinarianBuilder setname(String name) {
        this.name = name;
        return this;
    }

    public VeterinarianBuilder setIdCard(String idCard) {
        this.idCard = idCard;
        return this;

    }

    public VeterinarianBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public VeterinarianBuilder setPhoneNumber(String phone_Number) {
        this.phone_Number = phone_Number;
        return this;
    }

    public VeterinarianBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
     public VeterinarianBuilder setPassword(String username ){
        this.username = username;
        return  this;
               
    }
    
    public VeterinarianBuilder setPasswordU(String passwordU){
        this.passwordU = passwordU;
        return this;
 
    }

// Metodos de atributos no comunes
    public VeterinarianBuilder setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public VeterinarianBuilder setState(Boolean state) {
        this.state = state;
        return this;
    }

    public VeterinarianBuilder setIdPosition(Integer id_Position) {
        this.id_Position = id_Position;
        return this;
    }

    public Veterinarian build() {

        Veterinarian veterinarian = new Veterinarian(id, name, idCard, address, phone_Number, email, username, passwordU);
        veterinarian.setHireDate(hireDate);
        veterinarian.setState(state);
        veterinarian.setIdPosition(id_Position);
        return veterinarian;

    }
}
