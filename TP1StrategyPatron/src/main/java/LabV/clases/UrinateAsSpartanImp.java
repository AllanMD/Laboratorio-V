package LabV.clases;

import LabV.interfaces.IUrinate;

public class UrinateAsSpartanImp implements IUrinate {


    @Override
    public double urinate(double drinkInBody) {

        return (drinkInBody*0.20); // espartanos orinan el 80% de la bebida en cuerpo
    }

}
