package LabV.classes;

import java.util.Date;

public class Player extends Thread{

    private String name;
    static boolean playing;
    private String wordToGuess;
    private String usedLetters;

    public Player (String name){
        this.name = name;
        playing = Boolean.FALSE;
        wordToGuess = null;
        usedLetters = new String();

    }

    @Override
    public synchronized void run() {
        System.out.println("hola");
        while (!playing) {
            try {
                while (playing) {
                    System.out.println("1 While");
                    wait();
                }
                System.out.println("playing: " + playing);
                playing = Boolean.TRUE;

                if (!Hangman.ended) {
                    System.out.println("1 if");
                    boolean flag = false;
                    Character letter = null;
                    while (flag == false) {
                        System.out.println("2 while");
                        letter = (Hangman.randomLetter());
                        if (usedLetters.contains(letter.toString().toLowerCase())) {
                            System.out.println("2 if");
                            flag = false;
                        } else {
                            System.out.println("1 else");
                            usedLetters = usedLetters.concat(letter.toString().toLowerCase());
                            flag = true;
                        }
                    }

                    if (wordToGuess.contains(letter.toString().toLowerCase())) {
                        System.out.println("3 if");
                        wordToGuess = wordToGuess.replaceAll(letter.toString(), "*"); //

                    }

                    if (Hangman.wordIsComplete(wordToGuess)) {
                        System.out.println("GANOOOOOOOOOOOOOOOOOOOOOO");
                        Date date = new Date();
                        Winner winner = new Winner(name, date, Hangman.word);
                        Hangman.winner = winner;
                        Hangman.ended = Boolean.TRUE;
                    }

                    /* despues setear el word to guess y used letters a ""*/
                    playing = Boolean.FALSE;
                    notifyAll();
                    Thread.sleep(100);
                    System.out.println("playing: " + playing);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setWordToGuess (String word){
        wordToGuess = word;
    }

    public String getPlayerName() {
        return name;
    }
}
