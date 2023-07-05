package by.itstep.oop.casting;

public class Cube extends Square {
    private double volume;

    public Cube(double a) {
        super(a);
    }

    @Override
    public void print() {
        System.out.println(" ____");
        System.out.println("|    |\\");
        System.out.println("|____| \\");
        System.out.println(" \\___\\/ ");
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(a * 12);
    }

    @Override
    public void calculateArea() {
        setArea(Math.pow(a, 2)*6);
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void calculateVolume() {
        setVolume(Math.pow(a,3));
    }

    @Override
    public String toString() {
        return "Cube{" +
                "area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                ", color='" + getColor() + '\'' +
                "volume=" + volume +
                ", a=" + a +
                "} ";
    }
}
