// esto es mi cambio
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectar {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sistemamunicipal";
    private static final String USER = "root";
    private static final String PASSWORD = "";
 
    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}

    public Connection conexion() {
        Connection conect = null;
        try {
            // Cargamos el Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecemos la conexión
            conect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion establecida a la base de datos sistemamunicipal");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión");
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return conect;
    }
}
