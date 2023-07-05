package by.itstep.oop.casting;

public class Rectangle extends Shape {
    double a, b;

    public Rectangle(double area, double perimeter, String color, double a, double b) {
        super(area, perimeter, color);
        this.a = a;
        this.b = b;
    }

    public Rectangle(double area, double perimeter, double a, double b) {
        super(area, perimeter);
        this.a = a;
        this.b = b;
    }

    public Rectangle(double area, double a, double b) {
        super(area);
        this.a = a;
        this.b = b;
    }

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(double a) {
        this.a = a;
    }

    public Rectangle() {
    }

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

    @Override
    public String toString() {
        return "Rectangle{" +
                "area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                ", color='" + getColor() + '\'' +
                "a=" + a +
                ", b=" + b +
                "} ";
    }

    @Override
    public void print() {
        System.out.println(" ____________");
        System.out.println("|            |");
        System.out.println("|____________|");
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter((a + b) * 2);
    }

    @Override
    public void calculateArea() {
        setArea(a * b);
    }
}
