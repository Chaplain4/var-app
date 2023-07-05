package by.itstep.oop.casting;

//Нужен чтобы писать базовые поля и функции. Создать экземпляр Shape невозможно.
public abstract class Shape {
    private double area;
    private double perimeter;
    private String color;

    public Shape(double area, double perimeter, String color) {
        this.area = area;
        this.perimeter = perimeter;
        this.color = color;
    }

    public Shape(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public Shape(double area) {
        this.area = area;
    }

    public Shape() {
    }

    @Override
    public String toString() {
        return "Shape{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", color='" + color + '\'' +
                '}';
    }

    //абстрактные методы декларируются для реализации наследниками.
    //если в классе есть хоть один абстрактный метод, весь класс должен быть абстрактный.
    public abstract void print();
    public abstract void calculatePerimeter();
    public abstract void calculateArea();

    public void showInfo(){
        System.out.println("Shape: S = " + area + ", Perimeter = " + perimeter + ", Color is " + color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
