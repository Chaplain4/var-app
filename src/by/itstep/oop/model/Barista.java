package by.itstep.oop.model;

public class Barista {
    public static void main(String[] args) throws InterruptedException {
        CoffeeMachine coffeeMachine = new CoffeeMachine("Delonghi");
        coffeeMachine.turnOnOff();
        coffeeMachine.addCoffeeCount(50);
        coffeeMachine.addMilkCount(600);
        coffeeMachine.addSugarCount(50);
        coffeeMachine.addWaterCount(1000);
        coffeeMachine.makeLatte();
    }
}
