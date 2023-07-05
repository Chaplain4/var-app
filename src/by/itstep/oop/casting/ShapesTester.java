package by.itstep.oop.casting;

public class ShapesTester {

    public static void  shapeTest(Shape shape){
        shape.calculatePerimeter();
        shape.calculatePerimeter();
        shape.showInfo();
        shape.print();
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle(11,9,6);
        t1.setColor("Red");
        t1.calculatePerimeter();
        t1.calculateArea();
        t1.showInfo();
        t1.print();
        Cube c1 = new Cube(5);
        c1.setColor("Black");
        c1.calculateArea();
        c1.calculatePerimeter();
        c1.calculateVolume();
        c1.print();
        System.out.println(c1.toString());
        //кастинг не меняет ничего внутри объекта

        //Upcasting - конкретный объект мы рассматривает обобщенной ссылкой родительского класса.
        //Тем самым функционал более конкретного класса становится недоступен
        Shape sh1 = new Triangle(3,4,5);
        //явный Upcasting
        Shape sh2 = (Shape) new Rectangle(10,10);
        sh2.calculateArea();
        sh1.calculateArea();
        System.out.println(sh1.getArea());

        //Downcasting - это процесс, когда мы из общего объекта получаем более конкретный
        Shape sh3 = new Triangle(5, 7, 11);
        Triangle tr2 = (Triangle) sh3; //всегда в явной форме
        shapeTest(c1);

    }
}
