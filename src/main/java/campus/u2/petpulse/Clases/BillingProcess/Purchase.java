package campus.u2.petpulse.Clases.BillingProcess;

import java.time.LocalDate;
import java.util.ArrayList;

public class Purchase {

    private Integer id_Purchase;
    private ArrayList<Items> listItems;
    private LocalDate date;
    private Double total;
    private Integer idSuplier;

    public Purchase() {
    }

    public Purchase(LocalDate date, Double total, Integer idSuplier) {
        this.listItems = new ArrayList<Items>();
        this.date = date;
        this.total = 0.0;
        this.idSuplier = idSuplier;
    }

    public Purchase(Integer id_Purchase, LocalDate date, Double total, Integer idSuplier) {
        this.id_Purchase = id_Purchase;
        this.listItems = new ArrayList<Items>();
        this.date = date;
        this.total = total;
        this.idSuplier = idSuplier;
    }

    public Purchase(LocalDate date, Integer idSuplier) {
        this.listItems = new ArrayList<Items>();
        this.date = date;
        this.idSuplier = idSuplier;
    }

    public Integer getId_Purchase() {
        return id_Purchase;
    }

    public void setId_Purchase(Integer id_Purchase) {
        this.id_Purchase = id_Purchase;
    }

    public ArrayList<Items> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<Items> listItems) {
        this.listItems = listItems;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(Integer idSuplier) {
        this.idSuplier = idSuplier;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id_Purchase=" + id_Purchase + ", listItems=" + listItems + ", date=" + date + ", total=" + total + ", idSuplier=" + idSuplier + '}';
    }

}
