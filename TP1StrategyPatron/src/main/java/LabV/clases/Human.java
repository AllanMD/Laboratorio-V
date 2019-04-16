package LabV.clases;

import LabV.interfaces.IDrink;
import LabV.interfaces.IUrinate;

public class Human{

    private String name;
    private Integer age;
    private Integer weight;
    private IDrink drink;
    private IUrinate urinate; //
    private double drinkInBody;


    public Human() {
        this.name = "";
        this.age = 0;
        this.weight = 0;
        this.drink = null;
        this.urinate = null;
        this.drinkInBody = 0;
    }

    public Human(String name, Integer age, Integer weight, IDrink drink, IUrinate urinate) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.drink = drink;
        this.urinate = urinate;
        this.drinkInBody = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public IDrink getDrink() {
        return drink;
    }

    public void setDrink(IDrink drink) {
        this.drink = drink;
    }

    public IUrinate getUrinate() {
        return urinate;
    }

    public void setUrinate(IUrinate urinate) { /*modificar*/
        this.urinate = urinate;
    }

    public double getDrinkInBody() {
        return drinkInBody;
    }

    public void setDrinkInBody(double drinkInBody) {
        this.drinkInBody = drinkInBody;
    }

    public double urinate(){
        drinkInBody = urinate.urinate(drinkInBody);
        return urinate.urinate(drinkInBody);
    }

    public double drink (){
        drinkInBody = drink.drink(age,weight);

        return drinkInBody;
    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", drinkInBody=" + String.format("%.2f", drinkInBody) +
                '}';
    }
}
