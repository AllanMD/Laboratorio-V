package LabV.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection connect(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tp1_lab5","root", "");

            // primer parametro: servidor/base de datos. Segundo parametro: usuario. Tercer parametro: contraseña
        } catch (ClassNotFoundException e){
            System.out.println("La libreria SQL no se agrego correctamente");
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }
}
