package LabV.database;


import LabV.classes.Winner;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    public static void insertWinner(String name, Date date, String word){

        Connection conn = Connect.connect();
        String sql = "Insert into winners(winner_name,date, word) values (?,?,?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,name);
            stm.setDate(2,date);
            stm.setString(3,word);

            stm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Winner> readWinners(){
        Connection conn = Connect.connect();
        String sql = "Select * from winners";
        List<Winner> winners = null;
        try{
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            winners = new ArrayList<Winner>();
            while (result.next()){
                Winner winner = new Winner (result.getString("winner_name"), result.getDate("date"), result.getString("word"));
                //winner.add(result.getString("winner_name"));
                //System.out.println("Name: "+result.getString("winner_name"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return winners;
    }

    public static void insertWord(String word){

        Connection conn = Connect.connect();
        String sql = "Insert into words(word) values (?)";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,word);

            stm.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readWords(){
        Connection conn = Connect.connect();
        String sql = "Select * from words";
        List<String> words = new ArrayList<>();
        try{
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()){
                words.add(result.getString("word"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return words;
    }


    // en MAVEN hay que agregar la libreria sql mediante las dependencias en pom.xml, sin maven hay que agregar la libreria manualmente
    // en File --> Project Structure --> libraries
}