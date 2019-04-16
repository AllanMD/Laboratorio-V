package LabV.clases;

import LabV.interfaces.IDrink;
import LabV.interfaces.IUrinate;

public class Spartan extends Human {

    private Integer extraTolerance;

    public Spartan() {
        super();
        extraTolerance = 0;
    }

    public Spartan(String name, Integer age, Integer weight, IDrink drink, IUrinate urinate, Integer extraTolerance) {
        super(name, age, weight, drink, urinate);
        this.extraTolerance = extraTolerance;
    }

    public Integer getExtraTolerance() {
        return extraTolerance;
    }

    public void setExtraTolerance(Integer extraTolerance) {
        this.extraTolerance = extraTolerance;
    }

    @Override
    public double urinate() {
        double drinkInBody = super.urinate();
        super.setDrinkInBody(drinkInBody);
        return drinkInBody;
    }
}
