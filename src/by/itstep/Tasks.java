package by.itstep;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Tasks {


    public static void triangle() {
        //Δ площадь, периметр, равносторонний, равнобедренный
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a:");
        double a = sc.nextInt();
        System.out.println("Input b:");
        double b = sc.nextInt();
        System.out.println("Input c:");
        double c = sc.nextInt();
        if (a + b > c) {
            if (b + c > a) {
                if (c + a > b) {
                    System.out.println("Δ is valid");
                    double perimeter = a+b+c;
                    double area = Math.sqrt(perimeter*(perimeter-a)*(perimeter-b)*(perimeter-c));
                    System.out.println("perimeter equals " + perimeter);
                    System.out.println("area equals " + area);
                    if ( ((Math.pow(a, 2) + Math.pow(b, 2)) == (Math.pow(c, 2))) || ((Math.pow(b, 2) + Math.pow(c, 2)) == (Math.pow(a, 2))) || ((Math.pow(a, 2) + Math.pow(c, 2)) == (Math.pow(b, 2)))) {
                        System.out.println("Δ is square");
                    } else System.out.println("Δ is not square");
                    if (a==b && a==c){
                        System.out.println("Δ is even-sided");
                    } else if ((a==b) || (b==c) || (c==a)) {
                        System.out.println("Δ is isosceles");
                    } else
                    System.out.println("Δ is not isosceles");
                }
            }
        } else System.out.println("Δ is invalid");
    }
    public static void square() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a:");
        double a = sc.nextInt();
        System.out.println("Input b:");
        double b = sc.nextInt();
        double perimeter = (a + b) * 2;
        double area = a*b;
        System.out.println("perimeter is " + perimeter);
        System.out.println("area is " + area);
        if (a == b) {
            System.out.println("this is square");
        }
        else System.out.println("this is not square");

    }
    public static void circle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input r:");
        double r = sc.nextInt();
        double d = r*2;
        System.out.println("Diameter = " + d);
        double circle = Math.PI*d;
        double area = Math.PI*Math.pow(r, 2);
        System.out.println("circle = " + circle);
        System.out.println("area = " + area);
    }
    public static void squareEq() {
        System.out.println("squareEq begin");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a:");
        int a = sc.nextInt();
        System.out.println("Input b:");
        int b = sc.nextInt();
        System.out.println("Input c:");
        int c = sc.nextInt();
        System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
        double x1;
        double x2;
        double discr = Math.pow(b, 2)-(4*a*c);
        System.out.println("Discriminant = " + discr);
        if (discr < 0) {
            System.out.println("No roots");
        } else if (discr == 0) {
            System.out.println("1 root");
            x1 = -b/(2*a);
            System.out.println("x = " + x1);
        } else System.out.println("2 roots");
        x1 = ((Math.sqrt(discr))-b)/(2*a);
        x2 = (-(Math.sqrt(discr))-b)/(2*a);
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
    }
    public static void calories() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your gender? 1 - male, 2 - female");
        int gender = sc.nextInt();
        System.out.println("What's your height?");
        int height = sc.nextInt();
        System.out.println("What's your weight?");
        int weight = sc.nextInt();
        System.out.println("What's your age?");
        int age = sc.nextInt();
        System.out.println("How many workouts per week?");
        int workouts = sc.nextInt();
        double bmr;
        if (gender == 1) {
            bmr = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
        } else bmr = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
        if (workouts > 7) {
            bmr = bmr*1.9;
        } else if (workouts > 5) {
            bmr = bmr*1.725;
        } else if (workouts > 3) {
            bmr = bmr*1.55;
        } else if (workouts > 0) {
            bmr = bmr*1.375;
        } else bmr = bmr*1.2;
        System.out.println("BMR = " + bmr);
        //BMR = 447,6 + (9,2 × вес в кг) + (3,1 × рост в см) – (4,3 × возраст в годах)
        //BMR = 88,36 + (13,4 × вес в кг) + (4,8 × рост в см) – (5,7 × возраст в годах).
        //Сидячий образ жизни без нагрузок – BMR умножить на 1,2.
        //Тренировки  1-3 раза в неделю – BMR умножить на 1,375.
        //Занятия 3-5 дней в неделю – BMR умножить на 1,55.
        //Интенсивные тренировки 6-7 раз в неделю –BMR умножить на 1,725.
        //Спортсмены, выполняющие упражнения чаще, чем раз в день –BMR умножить на 1,9.
    }
    public static void geometry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("select problem: 1 - triangle, 2 - rectangle, 3 - circle");
        int problem = sc.nextInt();
        if (problem == 1) {
            triangle();
        } else if (problem == 2) {
            square();
        } else if (problem == 3) {
            circle();
        } else System.out.println("no such problem");
        }




    public static void main(String[] args) {
        System.out.println("begin method main");
        calories();
        System.out.println("Main END");



    }
}
