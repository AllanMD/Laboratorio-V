package LabV.classes;

import LabV.database.Database;

import java.util.Random;

public class Hangman {

    private String wordToGuess;
    private boolean ended = Boolean.FALSE;
    private Winner winner;//
    private boolean playing;
    private String usedLetters;

    public Hangman() {
        wordToGuess = generateRandomWord();
        winner = null;
        playing = Boolean.FALSE;
        usedLetters = new String();
    }

    public String generateRandomWord(){
        String randomWord = Database.readWord().toLowerCase();
        return randomWord;
    }

    public char randomLetter(){
        Random r = new Random();
        char letter = (char)(r.nextInt(26) + 'a'); // stackoverflow
        return letter;
    }


    public boolean wordIsComplete(String word){ //if the player completed the word, it returns true, else false
        boolean flag = true;

        for (int i = 0; i < word.length();i++){
            if (word.charAt(i) != '*'){
                flag = false;
            }
        }
        return flag;
    }


    public synchronized boolean play(String name){


         boolean won = Boolean.FALSE;

         while (playing) {
             try {
                 wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

         playing = Boolean.TRUE;

         if (!ended) {
             boolean flag = false;
             Character letter = null;
             while (flag == false) {
                 letter = randomLetter();
                 if (usedLetters.contains(letter.toString().toLowerCase())) {
                     flag = false;
                 } else {
                     usedLetters = usedLetters.concat(letter.toString().toLowerCase());
                     flag = true;
                 }
             }

             System.out.println(name + " intenta con la letra: " + letter);

             if (wordToGuess.contains(letter.toString().toLowerCase())) {
                 wordToGuess = wordToGuess.replaceAll(letter.toString(), "*");
             }

             if (wordIsComplete(wordToGuess)) {
                 ended = Boolean.TRUE;
                 won = Boolean.TRUE;
                 usedLetters = new String();
             }
         }

         playing = Boolean.FALSE;
         notifyAll();

        return won;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }
}
