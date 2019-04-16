package LabV.JDBC;


import LabV.clases.Human;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    public static void insert(String name, double drinkInBody){

        Connection conn = Connect.connect();
        String sql = "Insert into winners(winner_name,drink_in_body) values (?,?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,name);
            stm.setDouble(2,drinkInBody);

            stm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readWinners(){
        Connection conn = Connect.connect();
        String sql = "Select * from winners";
        List<String> names = new ArrayList<>();
        try{
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()){
                names.add(result.getString("winner_name"));
                //System.out.println("Name: "+result.getString("winner_name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return names;
    }

    // en MAVEN hay que agregar la libreria sql mediante las dependencias en pom.xml, sin maven hay que agregar la libreria manualmente
    // en File --> Project Structure --> libraries
}
