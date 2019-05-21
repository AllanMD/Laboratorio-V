package labV;

import java.util.Observable;
import java.util.Observer;

public class Mecanico implements Observer {

    /*despues de notificar un cambio se invoca esta funcion, y hago lo q quiero en base a esos cambios*/
    @Override
    public void update(Observable o, Object arg) { // el objeto observable lo recibe automaticamente siempre
        System.out.println(arg);
        System.out.println("El auto quedo de la siguiente forma: " + o.toString());
    }


}
