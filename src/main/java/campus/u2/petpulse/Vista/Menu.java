package campus.u2.petpulse.Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import campus.u2.petpulse.Clases.Products.AdministrationMethod;
import campus.u2.petpulse.Controlador.ProductsControlleres.AdministrationMethodController;
import campus.u2.petpulse.Controlador.ProductsControlleres.VaccineController;
import campus.u2.petpulse.Controlador.ServicesControlleres.VaccinationController;
import campus.u2.petpulse.Vista.MenuFunction.ProductMenuFunction;
import campus.u2.petpulse.Vista.MenuFunction.ServiceMenuFunction;
import java.sql.SQLException;


public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        //VaccinationController.deleteVaccination(8);
        ServiceMenuFunction.showMenu();
      //ProductMenuFunction.showMenu();
        
       
    }

}
