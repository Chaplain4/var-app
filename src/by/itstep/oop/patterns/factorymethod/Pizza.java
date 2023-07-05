package by.itstep.oop.patterns.factorymethod;

public abstract class Pizza {
    abstract void info();
}

class QuattroFormaggio extends Pizza {

    @Override
    void info() {
        System.out.println("QuattroFormaggio is made");
    }
}

class Margharita extends Pizza {

    @Override
    void info() {
        System.out.println("Margharita is made");
    }
}

class Pepperoni extends Pizza {

    @Override
    void info() {
        System.out.println("Pepperoni is made");
    }
}

class Pizzeria {
    public static Pizza makePizza(int number) {
        switch (number) {
            case 1:
                return new QuattroFormaggio();
            case 2:
                return new Margharita();
            case 3:
                return new Pepperoni();
            default:
                throw new IllegalArgumentException("No such pizza");
        }
    }
}

class PizzaLover {
    public static void main(String[] args) {
        Pizza [] pizzas = {Pizzeria.makePizza(1), Pizzeria.makePizza(2), Pizzeria.makePizza(3)};
        for (Pizza pizza : pizzas) {
            pizza.info();
        }
    }
}
