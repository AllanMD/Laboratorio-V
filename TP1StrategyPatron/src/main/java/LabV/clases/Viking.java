package LabV.clases;

import LabV.interfaces.IDrink;
import LabV.interfaces.IUrinate;

public class Viking extends Human {

    private Integer professionalDrinker;

    public Viking() {
        super();
        professionalDrinker = 0;
    }

    public Viking(String name, Integer age, Integer weight, IDrink drink, IUrinate urinate, Integer professionalDrinker) {
        super(name, age, weight, drink, urinate);
        this.professionalDrinker = professionalDrinker;
    }

    public Integer getProfessionalDrinker() {
        return professionalDrinker;
    }

    public void setProfessionalDrinker(Integer professionalDrinker) {
        this.professionalDrinker = professionalDrinker;
    }

    @Override
    public double drink() {
        double drinkInBody = super.drink() + professionalDrinker;
        super.setDrinkInBody(drinkInBody);
        return drinkInBody;

    }

    @Override
    public String toString() {
        return "Viking{" +
                super.toString() +
                "professionalDrinker=" + professionalDrinker +
                '}';
    }
}
