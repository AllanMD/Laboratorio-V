package LabV;

import LabV.classes.Hangman;
import LabV.classes.Player;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "AHORCADO!" );

        /*Database.insertWord("Pato");
        Database.insertWord("Casa");
        Database.insertWord("Comida");
        Database.insertWord("Fuego");*/


        Hangman hangman = new Hangman();

        Player p1 = new Player("allan", hangman);
        Player p2 = new Player("pedro", hangman);

        String word = hangman.generateRandomWord();


        System.out.println("El jugador 1 es: " + p1.getPlayerName());
        System.out.println("El jugador 2 es: " + p2.getPlayerName());

        System.out.println("-------------\n La PALABRA A ADIVINAR ES: " + word.toUpperCase() + "\n-----------------");

        p1.setWordToGuess(word);
        p2.setWordToGuess(word);

        p1.start();
        p2.start();


    }
}
