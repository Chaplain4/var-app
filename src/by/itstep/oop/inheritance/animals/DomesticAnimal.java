package by.itstep.oop.inheritance.animals;

import by.itstep.oop.Person;
import by.itstep.oop.inheritance.Parent;

public class DomesticAnimal extends Animal {

    private Person owner;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    void sleep(){
        System.out.println(getName() + " is sleeping");
    }

    void eat(){
        System.out.println(getName() + " eat()");
    }

    void play(){
        System.out.println(getName() + " play() ");
    }

    void voice() {
        System.out.println("some voice");
    }
}
