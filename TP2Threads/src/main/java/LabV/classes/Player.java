package LabV.classes;

public class Player extends Thread{

    private String name;
    static boolean playing;
    private String wordToGuess;
    private String usedLetters;

    public Player (String name){
        this.name = name;
        playing = Boolean.FALSE;
        wordToGuess = null;
        usedLetters = "";

    }

    @Override
    public void run() {
        System.out.println("hola");

        try {
            while (playing){
                wait();
            }
            playing = true;

            if (!Hangman.ended){

                boolean flag = false;
                Character letter = null;
                while (flag == false){

                     letter = (Hangman.randomLetter());
                    if (usedLetters.contains(letter.toString().toLowerCase())){
                        flag = false;
                    }else {
                        usedLetters.concat(letter.toString().toLowerCase());
                        flag = true;
                    }
                }

                if (wordToGuess.contains(letter.toString().toLowerCase())){

                    wordToGuess = wordToGuess.replaceAll(letter.toString(), "_"); //

                }

                /*if (playerWord.){ // comprobar que la palabra sea igual a "____" , en ese caso , el jugador gano

                }*/ /* despues setear el word to guess y used letters a ""*/





            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setWordToGuess (String word){
        wordToGuess = word;
    }
}
