package by.itstep.oop.inheritance;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private char gender;

    //Конструктор - единственный способ создать объект. Имя конструктора должно совпадать с классом
    public Person(int id, String name, String lastName, char gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
    }

    //Вызов существующего конструктора. Он должен быть первой инструкцией в новом конструкторе.
    public Person(int id, String name){
        this (id, name, null, ' ');
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Person p = new Person(1,"Ivan","Ivanov",'m');
        System.out.println(p.toString());
        Employee e1 = new Employee(342,"John","Johnson",'m', 500);
        Employee e2 = new Employee(234,"Lance");
        System.out.println(e2.toString());
        Student s1 = new Student(904,"Tom","Thompson", 'm',7.5);
        System.out.println(s1.toString());
        Manager m1 = new Manager(98732, "Victor","Petrov",'m',98762,"Sales");
        System.out.println(m1.toString());
    }
}