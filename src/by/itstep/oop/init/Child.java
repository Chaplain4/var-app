package by.itstep.oop.init;

public class Child extends Parent {
    private int p;
    private static int pStatic;

    static {
        System.out.println("Child static block begin");
        System.out.println(pStatic);
        pStatic = 123;
        System.out.println(pStatic);
        System.out.println("Child static block end");
    }

    {
        System.out.println("Child Non-Static block begin");
        System.out.println(p);
        p = 123;
        System.out.println(p);
        System.out.println("Child Non-Static block end");
    }

    public Child() {
        System.out.println("Child constructor begin");
        p = 321;
        System.out.println(p);
        System.out.println("Child constructor end");
    }

    public int getP() {
        return p;
    }

    public static int getpStatic() {
        return pStatic;
    }
}

