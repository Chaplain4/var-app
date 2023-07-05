package by.itstep.oop.inheritance.animals;

import by.itstep.oop.Person;

public class AnimalTester {


    public static void main(String[] args) {
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Dog d1 = new Dog();
        Dog d2 = new Dog();
        c1.setName("Barsik");
        c1.setId(1);
        c2.setName("Murzik");
        c2.setId(2);
        d1.setName("Tuzik");
        d1.setId(3);
        d2.setName("Rex");
        d2.setId(4);
        Shepherd shepherd1;
        shepherd1 = new Shepherd();
        shepherd1.setName("Bobik");
        shepherd1.setId(5);
        shepherd1.guardSheep();
        Dog d3 = (Dog) shepherd1;
        d3.serve();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        c1.setOwner(person1);
        c2.setOwner(person2);
        d1.setOwner(person3);
        d2.setOwner(person4);
        d3.setOwner(person5);
    }
}
