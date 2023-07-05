package by.itstep.oop.casting;

public class Driver {
    private char[] types;//'a', 'b' ...

    public void drive(){
        System.out.println("Driving");
    }
    public void shareDocs(){
        System.out.println("Sharing docs... Types");
        for (char type : types) {
            System.out.print(type);
        }
        System.out.println();
    }

    public Driver(char[] types) {
        this.types = types;
    }

    public char[] getTypes() {
        return types;
    }

    public void setTypes(char[] types) {
        this.types = types;
    }
}

class Programmer extends Driver {

    public Programmer(char[] types) {
        super(types);
    }

    public void code(){
        System.out.println("main(){}...");
    }
}

class Student extends Driver {

    public Student(char[] types) {
        super(types);
    }
    public void study(){
        System.out.println("studying...");
    }
}

class Test {

    public static void testDriver (Driver driver) {

        driver.shareDocs();
        driver.drive();
        if (driver instanceof Programmer) {
            Programmer p = (Programmer) driver;
            p.code();
        } else if (driver instanceof Student) {
            Student s = (Student) driver;
            s.study();
        }

    }

    public static void main(String[] args) {
        char[] types = {'a','b'};
        Driver d1 = new Driver(types);
        d1.drive();
        d1.shareDocs();
        char[] types2 = {'b'};
        Programmer p1 = new Programmer(types2);
        p1.drive();
        p1.code();
        p1.drive();

        //когда есть IS - A rel.
        Driver d2 = p1;
        Object o1 = p1;
        Object o2 = new int [5];
        Driver d10 = new Driver(types);

        //оператор, проверяющий на принадлежность иерархии указанного типа
        if (d10 instanceof Student) {
            Student st10 = (Student) d10;
            st10.study();
        } else {
            System.out.println("d10 is not a student");
        }
        //проверка на совпадение класса с указанным. Проверки на вложенность нет.
        if(d10.getClass() == Student.class) {
            Student st10 = (Student) d10;
            st10.study();
        } else {
            System.out.println("d10 is not a student");
        }

        Triangle o100 = new Triangle(2,5,6);

        o100.showInfo();
        Shape sh100 = o100;
        sh100.calculatePerimeter();
        sh100.calculateArea();
        sh100.showInfo();
    }
}