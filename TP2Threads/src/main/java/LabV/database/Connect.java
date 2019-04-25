package LabV.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public static Connection connect(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost","root", "");
                // primer parametro: servidor/base de datos o solo servidor/. Segundo parametro: usuario. Tercer parametro: contraseña

            Statement stat = conn.createStatement();

            /*String query = "SET GLOBAL time_zone = '+3:00';";
            stat.executeUpdate(query); no funciona esto, pero la sentencia sql sirve para el error de time server*/

            String query = "CREATE DATABASE IF NOT EXISTS tp2_lab5;";

            stat.executeUpdate(query);


            query = "USE tp2_lab5";
            stat.executeUpdate(query);

            query = "CREATE TABLE IF NOT EXISTS winners ("
                    + "winner_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + " winner_name VARCHAR(60),"
                    + " date DATE,"
                    + " word VARCHAR(50));";

            stat.executeUpdate(query);

            query = "CREATE TABLE IF NOT EXISTS words ("
                    + " word VARCHAR(60));";

            stat.executeUpdate(query);

        } catch (ClassNotFoundException e){
            System.out.println("La libreria SQL no se agrego correctamente");
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }
}
