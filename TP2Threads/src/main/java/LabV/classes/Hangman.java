package LabV.classes;

import LabV.database.Database;

public class Hangman {

    static String word;
    static boolean ended = Boolean.FALSE;
    static Winner winner; //?

    public static void generateRandomWord(){
        word = Database.readWord().toLowerCase();
    }

    public static char randomLetter(){
        //ascii code: a-z = 97 a 122
        char letter = (char) (Math.random() * 122 + 97); // char  between 97 and 122 - a and z
        return letter;
    }

    public static Winner play (Player p1, Player p2){

        generateRandomWord();
        p1.setWordToGuess(word);
        p2.setWordToGuess(word);
        p1.start();
        p2.start();


        return winner;
    }

}
