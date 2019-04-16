package LabV.clases;

import LabV.interfaces.IDrink;

public class DrinkAsSpartanImp implements IDrink {

    public DrinkAsSpartanImp() {
    }

    @Override
    public double drink(int age, int weight)
    {
        return (age * 0.05) + (weight * 0.10);
    }
}
