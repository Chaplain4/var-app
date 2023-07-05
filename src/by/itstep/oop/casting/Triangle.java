package by.itstep.oop.casting;

public class Triangle extends Shape {
    private double a, b, c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Triangle(double area, double perimeter, String color, double a, double b, double c) {
        super(area, perimeter, color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double area, double perimeter, double a, double b, double c) {
        super(area, perimeter);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double area, double a, double b, double c) {
        super(area);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void print() {
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(a + b + c);
    }

    @Override
    public void calculateArea() {
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        setArea(s);
    }

}
