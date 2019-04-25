package LabV;

import LabV.classes.Hangman;
import LabV.classes.Player;
import LabV.database.Database;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        /*Date fecha = new Date();
        java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
        Database.insertWinner("Allan",  fecha2,"River" );*/

        Database.insertWord("Pato");
        Database.insertWord("Casa");
        Database.insertWord("Comida");
        Database.insertWord("Fuego");

        Player p1 = new Player("allan");
        Hangman.generateRandomWord();
        String palabra = "______";
        char[] juego = palabra.toCharArray();



        p1.start();
    }
}
