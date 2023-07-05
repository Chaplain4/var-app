package by.itstep.oop.inheritance.animals;

public class Cat extends DomesticAnimal {

    @Override
    void sleep(){
        super.sleep();
        super.sleep();
        super.sleep();
    }

    @Override
    void eat(){
        System.out.println(getName() + " eat() -> Milk");
    }

    @Override
    void play(){
        System.out.println(getName() + " play() -> with mouse");
    }

    @Override
    void voice() {
        System.out.println("meow");
    }
}
