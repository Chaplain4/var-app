package by.itstep.oop.casting;

public class Square extends Rectangle {
    public Square(double a) {
        super(a);
    }

    @Override
    public void print() {
        System.out.println(" ____");
        System.out.println("|    |");
        System.out.println("|____|");
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(a * 4);
    }

    @Override
    public void calculateArea() {
        setArea(a * a);
    }

    @Override
    public String toString() {
        return "Square{" +
                "area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                ", color='" + getColor() + '\'' +
                "a=" + a +
                "} " + super.toString();
    }
}
