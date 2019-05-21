package labV;

import java.util.Observable;

public class Auto extends Observable {

    private int cantidadRuedas;
    private String modelo;
    private String patente;
    private int nivelAceite;
    private int presionNeumaticos;
    private int nivelAgua;

    public Auto(int cantidadRuedas, String modelo, String patente, int nivelAceite, int presionNeumaticos, int nivelAgua) {
        this.cantidadRuedas = cantidadRuedas;
        this.modelo = modelo;
        this.patente = patente;
        this.nivelAceite = nivelAceite;
        this.presionNeumaticos = presionNeumaticos;
        this.nivelAgua = nivelAgua;
    }

    public int getCantidadRuedas() {
        return cantidadRuedas;
    }

    public void setCantidadRuedas(int cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getNivelAceite() {
        return nivelAceite;
    }

    public void setNivelAceite(int nivelAceite) {
        String mensaje = "Las ruedas pasaron de " + this.nivelAceite + " a " + nivelAceite;
        this.nivelAceite = nivelAceite;
        setChanged(); // Marca que el objeto actual ha sido modificado. cambia el estado "modificado" (changed)
        notifyObservers(mensaje); //se usa despues de producirse un cambio dentro del objeto
        // el metodo invoca al update del observer
        //el primer parametro (Observer o) se pasa automaticamente, en este caso el objeto de tipo Auto
        // al finalizar este metodo, el estado de objeto modificado vuelve a su estado normal
    }

    public int getPresionNeumaticos() {
        return presionNeumaticos;
    }

    public void setPresionNeumaticos(int presionNeumaticos) {
        String mensaje = "Las presion de los neumaticos paso de " + this.presionNeumaticos + " a " + presionNeumaticos;
        this.presionNeumaticos = presionNeumaticos;
        setChanged(); // Marca que el objeto actual ha sido modificado.
        notifyObservers(mensaje);
    }

    public int getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(int nivelAgua) {
        String mensaje = "El nivel de agua paso de " + this.nivelAgua + " a " + nivelAgua;
        this.nivelAgua = nivelAgua;
        setChanged();
        notifyObservers(mensaje );
    }

    @Override
    public String toString() {
        return "Auto{" +
                "cantidadRuedas=" + cantidadRuedas +
                ", modelo='" + modelo + '\'' +
                ", patente='" + patente + '\'' +
                ", nivelAceite=" + nivelAceite +
                ", presionNeumaticos=" + presionNeumaticos +
                ", nivelAgua=" + nivelAgua +
                '}';
    }
}
