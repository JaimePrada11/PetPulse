
package campus.u2.petpulse.Clases.Products;



public class SpecialFactory implements AbstractSpecialFactory {

    @Override
    public PetFood creatFood(Integer ID_Product, double weight, Integer calories, Boolean isOrganic) {
        return new PetFood(ID_Product, 0, calories, isOrganic);
    }

    @Override
    public Accesory createAccesory(Integer idProduct, MaterialType materialType, String dimensions, AccesoryType accesoryType) {
        return new Accesory(idProduct, materialType, dimensions, accesoryType);
    }


    
    
}
