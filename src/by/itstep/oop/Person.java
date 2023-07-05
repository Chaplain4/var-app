package by.itstep.oop;

import java.util.Scanner;

/*
Class <=> Model <=> Type <=> Template
Класс определяет будущие характеристики и функционал конкретных объектов
*/
public class Person {

    // field - поля. Характеристики будущего объекта.
    int age;
    String name;
    String lastName;
    char gender;
    boolean isSingle;

    //methods <=> functions. Поведение будущих объектов.
    void sayMyName() {
        System.out.println("Hello, my name is " + name);
    }

    void dance() {
        System.out.println(name + " is dancing");
    }

    void drink() {
        if (age >= 18) {
            System.out.println("Spirits");
        } else {
            System.out.println("Water");
        }
    }

    void marriage(Person person1, Person person2) {
        {
            if (person1.isSingle && person2.isSingle && person1.age >= 18 && person2.age >= 18 && ((person1.gender == 'm' && person2.gender == 'f') || (person1.gender == 'f' && person2.gender == 'm'))) {
                person1.lastName = person2.lastName;
                person1.isSingle = false;
                person2.isSingle = false;
            }
        }
    }
}

class Tester {
    public static void main(String[] args) {
        //создание переменной типа Person;
        Person person;
        // instance creation <=> object creation
        // via 'new' operator
        person = new Person();
        //instance fields initialization <=> object populating
        person.name = "John";
        person.age = 32;
        person.gender = 'm';
        person.isSingle = true;
        person.lastName = "Wayne";
        //object behavior <=> methods invocation
        person.sayMyName();
        person.drink();
        person.dance();

        Person valera = new Person();
        valera.name = "Valery";
        valera.age = 17;
        person.gender = 'm';
        person.isSingle = false;
        person.lastName = "Petrov";
        valera.sayMyName();

        Person natasha = new Person();
        natasha.name = "Natasha";
        natasha.age = 35;
        person.gender = 'f';
        person.isSingle = true;
        person.lastName = "Ivanova";
        natasha.sayMyName();


    }
}