package LabV;

import LabV.JDBC.DataBase;
import LabV.clases.*;
import LabV.interfaces.IDrink;

import java.sql.DatabaseMetaData;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Human allan = new Viking("Allan",21, 71, new DrinkAsVikingImp(), new UrinateAsVikingImp(),10);
        Human vikingo1 = new Viking("Pedro",3883, 765, new DrinkAsVikingImp(), new UrinateAsVikingImp(),10);
        Human vikingo2 = new Viking("Juan",353, 75, new DrinkAsVikingImp(), new UrinateAsVikingImp(),10);
        Human spartan1 = new Spartan("Jefe Maestro",117,130,new DrinkAsSpartanImp(), new UrinateAsSpartanImp(),20);
        Human spartan2 = new Spartan ("Nachota Scocco",  30, 76, new DrinkAsSpartanImp(), new UrinateAsSpartanImp(),13);
        Human spartan3 = new Spartan ("Pity Martinez",25,78,new DrinkAsSpartanImp(),new UrinateAsSpartanImp(),19);

        List<Human> vikings = Arrays.asList(allan,vikingo1,vikingo2);
        List<Human> spartans = Arrays.asList(spartan1,spartan2,spartan3);

        System.out.println(String.format("vikingos: %s",vikings));
        System.out.println(String.format("espartanos: %s",spartans));
        //ordenar equipo por edad
        vikings.sort(comparing(Human::getAge)); // human::getage es un lambda
        System.out.println(String.format("\nvikingos despues de ordenar: %s",vikings));

        spartans.sort(comparing(Human::getAge));
        System.out.println(String.format("espartanos despues de ordenar: %s",spartans));


        int randomVikingIndex = (int) (Math.random() * vikings.size()); // math random va a devolver un numero entre 0 y el numero del tamaño del arreglo
        int randomSpartanIndex = (int) (Math.random()* spartans.size());

        Human vikingCompetitor = vikings.get(randomVikingIndex);
        Human spartanCompetitor = spartans.get(randomSpartanIndex);

        System.out.println("\ncompetidor vikingo: " + vikingCompetitor);
        System.out.println("competidor espartano: " + spartanCompetitor);


        Competition competition = new Competition();

        Human winner = competition.clash(vikingCompetitor, spartanCompetitor);

        System.out.println("\nGANADOR: " + winner);
        DataBase.insert(winner.getName(),winner.getDrinkInBody());
        System.out.println("\nGanadores: " + DataBase.readWinners());

        Human tavernOwner = new Human("Moe", 50, 100, new DrinkAsVikingImp(), new UrinateAsSpartanImp());

        System.out.println("\nEl ganador '"+ winner.getName() + "' se enfrenta al dueño de la taberna '" + tavernOwner.getName()+ "' !");

        Human finalWinner = competition.clash(winner, tavernOwner);

        System.out.println("Y el maximo ganador es: " + finalWinner);

    }
}
