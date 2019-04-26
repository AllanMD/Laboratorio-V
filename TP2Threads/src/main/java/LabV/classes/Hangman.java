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


    public static boolean wordIsComplete(String word){ //if the player completed the word, it returns true, else false
        boolean flag = true;

        for (int i = 0; i < word.length();i++){
            if (word.charAt(i) != '*'){
                flag = false;
            }
        }
        return flag;
    }
    public static void play (Player p1, Player p2){

        generateRandomWord();
        System.out.println("-------------\n La PALABRA A ADIVINAR ES: " + word.toUpperCase() + "\n-----------------");
        p1.setWordToGuess(word);
        p2.setWordToGuess(word);

            p1.start();
            p2.start();

        System.out.println("final");
        //System.out.println("El ganador es:" + winner.toString());
        //return winner;
    }


}
