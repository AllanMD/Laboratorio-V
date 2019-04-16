package LabV.clases;

import LabV.interfaces.IUrinate;

public class UrinateAsVikingImp implements IUrinate {

    @Override
    public double urinate(double drinkInBody) {
        return (drinkInBody*0.14); // Vikingos orinan el 86% de su bebida en cuerpo
        //todos orinan el 80% de la bebida en cuerpo
        // hay q restar lo orinado a bebida en cuerpo
        // el q mayor bebida en cuerpo tenga gana
    }
}
