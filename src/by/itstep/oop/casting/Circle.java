package by.itstep.oop.casting;

public class Circle extends Shape {
    double radius;

    @Override
    public String toString() {
        return "Circle{" +
                "area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                ", color='" + getColor() + '\'' +
                "radius=" + radius +
                "} " + super.toString();
    }

    @Override
    public void print() {
        System.out.println("o");
    }

    public Circle(double area, double perimeter, String color, double radius) {
        super(area, perimeter, color);
        this.radius = radius;
    }

    public Circle(double area, double perimeter, double radius) {
        super(area, perimeter);
        this.radius = radius;
    }

    public Circle(double area, double radius) {
        super(area);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = 2*radius*Math.PI;
        setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        double area = Math.PI*Math.pow(radius,2);
        setArea(area);
    }
}
