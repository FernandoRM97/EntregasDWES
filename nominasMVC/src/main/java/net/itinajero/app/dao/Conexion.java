package net.itinajero.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static final String URL = "jdbc:oracle:thin:@192.168.1.46:1521:xe";
    private static final String USERNAME = "nomina";
    private static final String PASSWORD = "nomina";

    public static Connection getConnection() {
        
        Connection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion realizada con exito");
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Conexion fallida");
            System.out.println("");
        }
        return connection;
    }
    
}