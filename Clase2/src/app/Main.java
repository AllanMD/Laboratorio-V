package App;

import Clases.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hola la concha de tu  madre");
        Persona persona1 = new Persona("allan",28,19040012);
        Persona persona2 = new Persona("federico", 14,40794525);
        Persona persona3 = new Persona("pablito", 66,56654456);

        List<Persona> personas= new ArrayList<Persona>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        System.out.println("--------Para imprimir la list completa--------");
        System.out.println(String.format("Personas: %s",personas));

        System.out.println("----------MAYORES A 21-------------");
        // mayores a 21
        System.out.println(String.format("Mayores a 21: %s",personas.stream()
        .filter(persona->persona.getEdad() > 21)
        .collect(Collectors.toList())));

        System.out.println("-----------MENORES A 18-------------------");
        // menores 18
        System.out.println(String.format("menores 18: %s",personas.stream()
                .filter(persona->persona.getEdad() < 18)
                .collect(Collectors.toList())));

        System.out.println("---------MAYORES A 21 + DNI >20000000 -------------------");
        System.out.println(String.format("MAYORES A 21 + DNI >20000000: %s",personas.stream()
                .filter(persona->persona.getEdad() > 21 && persona.getDni()>20000000).
                //.filter( persona->persona.getDni() >20000000) // tambien funciona con este
                collect(Collectors.toList())));


        List <Integer> numeros = Arrays.asList(4,2,8,1);
        /*lo mismo que hacer new arraylist y hacer los numeros.add:
        numeros.add(4);
        numeros.add(2);
        numeros.add(8);
        numeros.add(1); */

        Long hola = numeros.stream().filter(numero->numero > 5).count();

        System.out.println("ordenados:");
        numeros.stream().sorted().forEach(System.out::println);

        numeros.sort();

        System.out.println("numeroooo:" + hola);
    }
}
