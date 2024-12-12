package campus.u2.petpulse.Clases.BillingProcess;

public class Suppliers {

    private int ID_Supplier;
    private String Company_Name;
    private String NIT;
    private String contactName;
    private String Phone_Number;
    private String Email;

    public Suppliers() {

    }

    public Suppliers(String Company_Name, String NIT, String contactName, String Phone_Number, String Email) {
        this.Company_Name = Company_Name;
        this.NIT = NIT;
        this.contactName = contactName;
        this.Phone_Number = Phone_Number;
        this.Email = Email;
    }

    public Suppliers(int ID_Supplier, String Company_Name, String NIT, String contactName, String Phone_Number, String Email) {
        this.ID_Supplier = ID_Supplier;
        this.Company_Name = Company_Name;
        this.NIT = NIT;
        this.contactName = contactName;
        this.Phone_Number = Phone_Number;
        this.Email = Email;
    }

    public int getID_Supplier() {
        return ID_Supplier;
    }

    public void setID_Supplier(int ID_Supplier) {
        this.ID_Supplier = ID_Supplier;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public void setCompany_Name(String Company_Name) {
        this.Company_Name = Company_Name;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "ID_Supplier=" + ID_Supplier + ", Company_Name=" + Company_Name + ", NIT=" + NIT + ", contactName=" + contactName + ", Phone_Number=" + Phone_Number + ", Email=" + Email + '}';
    }

}
