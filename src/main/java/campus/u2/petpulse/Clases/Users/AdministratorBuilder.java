
package campus.u2.petpulse.Clases.Users;


import java.time.LocalDate;


public class AdministratorBuilder {
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

    public AdministratorBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public AdministratorBuilder setname(String name) {
        this.name = name;
        return this;
    }

    public AdministratorBuilder setIdCard(String idCard) {
        this.idCard = idCard;
        return this;

    }

    public AdministratorBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public AdministratorBuilder setPhoneNumber(String phone_Number) {
        this.phone_Number = phone_Number;
        return this;
    }

    public AdministratorBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
     public AdministratorBuilder setusername(String username ){
        this.username = username;
        return  this;
               
    }
    
    public AdministratorBuilder setPasswordU(String passwordU){
        this.passwordU = passwordU;
        return this;
 
    }

// Metodos de atributos no comunes
    public AdministratorBuilder setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public AdministratorBuilder setState(Boolean state) {
        this.state = state;
        return this;
    }

    public AdministratorBuilder setIdPosition(Integer id_Position) {
        this.id_Position = id_Position;
        return this;
    }

    public Administrator build() {

        Administrator administrator = new Administrator(id, name, idCard, address, phone_Number, email, username, passwordU);
        administrator.setHireDate(hireDate);
        administrator.setState(state);
        administrator.setIdPosition(id_Position);
        return administrator;

    }
    }
    
    
    
    
    
    
    
    
    
    

