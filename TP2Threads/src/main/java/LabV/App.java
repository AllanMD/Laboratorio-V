package LabV;

import LabV.classes.Hangman;
import LabV.classes.Player;
import LabV.classes.Winner;
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
        System.out.println( "AHORCADO!" );

        /*Date fecha = new Date();
        java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
        Database.insertWinner("Allan",  fecha2,"River" );*/

        /*Database.insertWord("Pato");
        Database.insertWord("Casa");
        Database.insertWord("Comida");
        Database.insertWord("Fuego");*/

        Player p1 = new Player("allan");
        Player p2 = new Player("pedro");

        System.out.println("El jugador 1 es: " + p1.getPlayerName());
        System.out.println("El jugador 2 es: " + p2.getPlayerName());

        Hangman.play(p1,p2);

        System.out.println("PUTO");



    }
}
