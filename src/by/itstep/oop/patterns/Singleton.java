package by.itstep.oop.patterns;

import java.util.Date;

public class Singleton {

    private static Singleton singleton;
    private String value;

    public String getValue() {
        return value;
    }

    private Singleton() {
        System.out.println("+1");
    }

    //Lazy implementation. Создание экземпляра по первому требованию.
    public static Singleton getInstance() {
        if (singleton == null){
            singleton = new Singleton();
            singleton.value = new Date().toString();
        }
        return singleton;
    }
}

class SingletonTester {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton.getValue());
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton.getValue());
        Singleton singleton3 = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton.getValue());
    }
}