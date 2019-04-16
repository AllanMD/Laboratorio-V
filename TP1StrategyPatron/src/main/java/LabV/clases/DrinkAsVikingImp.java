package LabV.clases;

import LabV.interfaces.IDrink;

public class DrinkAsVikingImp implements IDrink {


    @Override
    public double drink(int age, int weight) {
        return (age * 0.08) + (weight * 0.13);
    }
}
