package LabV.classes;

import LabV.database.Database;

import java.util.Date;

public class Player extends Thread{

    private String name;
    static boolean playing;
    private String wordToGuess;
    private Hangman hangman;

    public Player (String name, Hangman hangman){
        this.name = name;
        this.hangman = hangman;
        playing = Boolean.FALSE;
        wordToGuess = null;
    }

    @Override
    public void run() {
        boolean won = Boolean.FALSE;

        while (!hangman.isEnded()){
            won = hangman.play(name);
            try {
                Thread.sleep(10); // para que? // si lo pongo en Hangman.play el comportamiento es distinto
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(won){
            Date date = new Date(); // the date for the winner object
            java.sql.Date date2 = new java.sql.Date(date.getTime()); // the date for the database
            Winner winner = new Winner(name, date, wordToGuess);
            hangman.setWinner(winner); //-
            Database.insertWinner(name, date2, wordToGuess);
            System.out.println("EL GANADOR ES: " + name.toUpperCase() + " (ACERTÓ LA ULTIMA LETRA)");
        }

    }

    public void setWordToGuess (String word){
        wordToGuess = word;
    }

    public String getPlayerName() {
        return name;
    }
}
