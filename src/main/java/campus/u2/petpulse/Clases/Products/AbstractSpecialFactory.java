
package campus.u2.petpulse.Clases.Products;

import java.util.Date;


public interface AbstractSpecialFactory {
    
    Accesory createAccesory(Integer idProduct, MaterialType materialType, String dimensions, AccesoryType accesoryType);
    PetFood creatFood(Integer ID_Product, double weight, Integer calories, Boolean isOrganic);
    
}
