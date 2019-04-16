package LabV.clases;

public class Competition {

    // ???
    // hacer enfrentamiento y todo el codigo relacionado al enfrentamiento aca


    public Human clash (Human competitor1, Human competitor2){

        Human winner = new Human();

            competitor1.drink();
            competitor2.drink();
            competitor1.urinate();
            competitor2.urinate();

        if (competitor1.getDrinkInBody() > competitor2.getDrinkInBody()){
            winner = competitor1;
        }
        else {
            winner = competitor2;
        }
        return winner;
    }

}
