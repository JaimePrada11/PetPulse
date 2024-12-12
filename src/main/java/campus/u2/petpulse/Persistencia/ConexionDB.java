/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campus.u2.petpulse.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConexionDB  {

    private static final String url = "jdbc:mysql://localhost:3306/petpulse";
    private static final String user = "root";
    private static final String password = "J12345";
    private static Connection con = null;
    
    private ConexionDB () {}

     public static Connection getConexion() {
       
            try {
                con = DriverManager.getConnection(url, user, password);
                if (con != null && con.isValid(2)) {
                    System.out.println("Conexión exitosa pet!!");
                } else {
                    System.out.println("Conexión fallida o no válida.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al establecer la conexión: " + ex.getMessage());
                ex.printStackTrace();
            }
        
        return con;
    }
    
    
     public static void closeConecction() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
