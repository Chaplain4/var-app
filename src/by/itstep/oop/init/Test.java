package by.itstep.oop.init;

public class Test {
    int val;

    static {
        System.out.println("Test static block");
    }

    Test() {
        System.out.println("Test constructor");
        System.out.println(val);
    }

    public static void main(String[] args) {
        new Third();
        double pi = Math.PI;
        //В первую очередь запускаются статические поля и блоки - от родителя к наследникам
        //Затем запускаются нестатические поля и блоки включая конструктор - от родителя к наследникам
        //Если объект не создавать - вызывается только заданная статика
    }
}