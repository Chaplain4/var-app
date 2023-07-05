package by.itstep.oop;

import lombok.Data;

@Data
public class Dog {

    private long id;
    private String name;
    private String type;
    private Person owner;
    private char gender;
    private double weight;
    private double height;
    private int age;


    // Getters and Setters - методы модификации полей

    public String getName() {
        return name;
    }


    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge){
        if(newAge < 0) {
            System.out.println("Incorrect age : " + newAge);
        } else {
            age = newAge;
        }
    }

    public char getGen() {
        return gender;
    }

    public void setGen(char gender) {
        this.gender = gender;
    }
}

class DogTester {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.setName("Zhuchka");
        System.out.println("name is " + d1.getName());
        d1.setAge(-2);
        System.out.println("Age is " + d1.getAge());

    }
}