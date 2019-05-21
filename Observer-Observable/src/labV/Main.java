package labV;

public class Main {

    public static void main(String[] args) {


        Auto auto = new Auto(4,"Duster", "AAA 123", 10, 29, 15);
        Mecanico mecanico = new Mecanico();

        auto.addObserver(mecanico);

        auto.setNivelAceite(20);
        auto.setPresionNeumaticos(40);
        auto.setNivelAgua(100);
    }

}
