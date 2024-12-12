
package campus.u2.petpulse.Clases.Products;


public class stockManagement {
    
    private static int minimumStock = 15;  
    private static int criticalStock = 5;    

    public static int getGlobalMinimumStock() {
        return minimumStock;
    }

    public static void setGlobalMinimumStock(int newMinimumStock) {
        minimumStock = newMinimumStock;
    }

    public static int getGlobalCriticalStock() {
        return criticalStock;
    }

    public static void setGlobalCriticalStock(int newCriticalStock) {
        criticalStock = newCriticalStock;
    }

    public static boolean isStockBelowMinimum(Product product) {
        return product.getStock() < minimumStock;
    }

    public static boolean isStockCritical(Product product) {
        return product.getStock() < criticalStock;
    }

    public static void showStockThresholds() {
        System.out.println("Current Global Minimum Stock: " + minimumStock);
        System.out.println("Current Global Critical Stock: " + criticalStock);
    }
}
