package app;

import clases.City;
import clases.Event;
import clases.Location;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {

        List<Event> events = Arrays.asList(
                new Event (4,"Partido", new Location(1,"Monumental",new City(1,"Buenos Aires"))),
                new Event (1,"Concierto",new Location(2,"Estadio Unico", new City(2,"La Plata"))),
                new Event (2,"Abandono",new Location(3,"Bombonera",new City(3,"Buenos Aires"))),
                new Event(3,"Cumpleaños",new Location(4,"Casita",new City(4,"Paris"))),
                new Event(6,"Fiesta",new Location(5,"Playa",new City(5,"Mar del Plata"))),
                new Event(5,"Navidad",new Location(6,"Salon",new City(6,"Polo Norte")))
        );

        //All the events
        events.stream().forEach(System.out::println);

        System.out.println("\n---------------- PRIMEROS 5 EVENTOS ORDENADOS POR ID ----------------------");
        events.stream().sorted(comparing(Event::getId)).limit(5).forEach(System.out::println);

        System.out.println("\n---------------- PRIMEROS 5 EVENTOS ORDENADOS POR NOMBRE ----------------------");
        events.stream().sorted(comparing(Event::getName)).limit(5).forEach(System.out::println);

        List<Event> events2 = getFirtFiveEventsById(events);
        System.out.println("------- Eventos despues de obtenerlos a traves del metodo -------------");
        events2.stream().forEach(System.out::println);


    }

    // test method
    public static List<Event> getFirtFiveEventsById (List<Event> events){
        return events.stream().sorted(comparing(Event::getId)).limit(5).collect(Collectors.toList());
    }
}
