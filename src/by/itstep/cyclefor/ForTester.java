package by.itstep.cyclefor;

import java.util.Scanner;

public class ForTester {
    public static void task1() {
        // 0 2 4 6 8 10 ... (1000 TIMES)
        for (int i = 0; i < 2000; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void task2() {
        for (int i = 1, n = 1; n <= 500; i = i + 2, n = n + 1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void task3() {
        for (int i = 10, n = 50; n > 0; i = i + 10, n = n - 1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void task4() {
        for (int i = -1, n = 1; n <= 100; i = i - 1, n = n + 1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void task5() {
        for (int i = -1, n = 1; n <= 100; i--, n++) {
            if (i % 2 == 0) {
                System.out.print((-1) * i + " ");
            } else System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void task5_1() {
        for (int i = -1, n = 1; n <= 100; i--, n++) {
            if ((i / 2) == ((i + 1) / 2)) {
                System.out.print(i + " ");
            } else System.out.print((-1) * i + " ");
        }
        System.out.println();
    }

    public static void anyTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first number:");
        int firstN = sc.nextInt();
        System.out.println("Input increment:");
        int increment = sc.nextInt();
        System.out.println("Input number of iterations:");
        int iterationN = sc.nextInt();
        System.out.println("Your numbers row is:");
        for (int n = firstN; iterationN > 0; n = n + increment, iterationN--) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void task6() {
        for (int i = 0; i < 25; i++) {
            System.out.print((int) (Math.random() * 11 + 1) - 1 + " ");
        }
        System.out.println();
    }

    public static void task7() {
        System.out.print("                    ТАБЛИЦА УМНОЖЕНИЯ");
        System.out.println();
        System.out.println();

        for (int num1 = 2, num2 = 2; num1*num2 < 100; ) {
            num1 = 2;
            for (; num2 < 11; ) {
                num1 = 2;
                for (; num1 < 6; ) {
                    int result = num1 * num2;
                    System.out.print(num1 + " x " + num2 + " = " + result + "          ");
                    num1++;
                }
                System.out.println();
                num2++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        очередность:                       0                                       1               3                 2
//        for(<тут декларируются переменные, созданные только для этого цикла>;<условие цикла>;<итерация цикла>) {<тело цикла>}
//        <1.> - выполняется только единожды
//        <2.> - true либо false. Если true - выполняется тело цикла
//        <3.> - выполняется каждый раз перед проверкой условия либо после тела цикла
//        task1();
//        task2();
//        task3();
//        task4();
//        task6();
//        task5();
        task7();
//        task5_1();
//        anyTask();
//        for (int i = 0; i < 10; i++){
//            System.out.println(i);
//        }
//
//        for (; true; ){
//            System.out.println("inside For");
//            double y = Math.random();
//            System.out.println(y);
//            int x = (int) (Math.random()*10);
//            System.out.println(x);
//            if (x == 5) {
//                break; // выход из цикла
//            }
//        }
//            int i;
        // после цикла можно вводить переменные, одноименные созданным для цикла

        // %
//            double number = 349;
//            double number2 = 86;
//            double result = number % number2;
//            System.out.println(result);
    }
}
