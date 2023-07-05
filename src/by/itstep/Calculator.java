package by.itstep;

import java.util.Scanner;

public class Calculator {

    public static void list2() {
        int letter2 = 1;
        Scanner sc = new Scanner(System.in);
        while (letter2 == 1) {
            int letter = (int) (Math.random() * 5) + 1;
            switch (letter) {
                case 1: {
                    System.out.println(Calculator.summa(vvod(), vvod()));
                    break;
                }
                case 2: {
                    System.out.println(Calculator.razn(vvod(), vvod()));
                    break;
                }
                case 3: {
                    System.out.println(Calculator.proizved(vvod(), vvod()));
                    break;
                }
                case 4: {
                    System.out.println(Calculator.sqRoot(vvod()));
                    break;
                }
                case 5: {
                    System.out.println(Calculator.pifagor(vvod(), vvod()));
                    break;
                }
                default:
                    System.out.println("no such method");
            }
            System.out.println("would you like to try again 1- y/ 2 - n?");
            letter2 = sc.nextInt();
        }
    }

    public static void list() {
        int letter2 = 1;
        Scanner sc = new Scanner(System.in);
        while (letter2 == 1) {
            System.out.println("Select option");
            System.out.println("1 - summa");
            System.out.println("2 - raznost");
            System.out.println("3 - proizved");
            System.out.println("4 - sq root");
            System.out.println("5 - pifagor triangle");
            int letter = sc.nextInt();
            switch (letter) {
                case 1: {
                    System.out.println(Calculator.summa(vvod(), vvod()));
                    break;
                }
                case 2: {
                    System.out.println(Calculator.razn(vvod(), vvod()));
                    break;
                }
                case 3: {
                    System.out.println(Calculator.proizved(vvod(), vvod()));
                    break;
                }
                case 4: {
                    System.out.println(Calculator.sqRoot(vvod()));
                    break;
                }
                case 5: {
                    System.out.println(Calculator.pifagor(vvod(), vvod()));
                    break;
                }
                default:
                    System.out.println("no such method");
            }
            System.out.println("would you like to try again 1- y/ 2 - n?");
            letter2 = sc.nextInt();
        }
    }

    public static int vvod() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input number");
        int a = sc.nextInt();
        return a;
    }

    public static int summa(int a, int b) {
        return a + b;
    }

    public static int razn(int a, int b) {
        return a - b;
    }

    public static int proizved(int a, int b) {
        return a * b;
    }

    public static int sqRoot(int a) {
        return (int) Math.sqrt(a);
    }

    public static double pifagor(double catet1, double catet2) {
        //calculates hipotenuse
        double hipotenuse = Math.sqrt(Math.pow(catet1, 2) + Math.pow(catet2, 2));
        return hipotenuse;
    }

    public static double chastn(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Div by Zero");
        }
        return a / b;
    }

    public static int rasst(int speed, int time) {
        return speed * time;
    }

    char a = (char) Calculator.summa(3, 7);

    // client
    public static void main(String[] args) {
        list2();
    }
}
