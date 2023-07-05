package by.itstep.oop;

public class Human {
    private String name;
    private static int counter;
    private int age;
    public Human(){
        System.out.println("Human+1");
        counter++;
        age++;
    }

    public static int getCounter() {
        return counter;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class TestHuman {
    public static void main(String[] args) {
        //количество созданных объектов
        System.out.println(Human.getCounter());
        Human h1 = new Human();
        new Human();
        new Human();
        new Human();
        System.out.println(Human.getCounter());
        System.out.println(h1.getAge());
        //статические поля принадлежат классу, а нестатические - объекту
        System.out.println(Human.getCounter());

    }
}