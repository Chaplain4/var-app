package by.itstep.oop.inheritance.animals;

public class Dog extends DomesticAnimal {
    void serve(){
        System.out.println(getName() + " is serving");
    }

    @Override
    void voice() {
        System.out.println(getName() + " voices Woof-woof");
    }

    @Override
    void play() {
        System.out.println(getName() + " play() -> with stick");
    }

    @Override
    void eat() {
        System.out.println(getName() + " eat() -> Bones");
    }
}
