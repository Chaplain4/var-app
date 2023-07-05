package Homework;

import java.util.Scanner;

public class StaticMethods {

    public static void methodOne(String a, int times) {
        // написать метод, который будет печатать передаваемый текст несколько раз
        while (times > 0) {
            System.out.println(a);
            times--;
        }
    }

    public static double methodTwo(double num1, double num2, double num3, double num4) {
        // функция, возвращающая среднее арифметическое 4 аргументов
        double average = (num1 + num2 + num3 + num4) / 4;
        return average;
    }

    public static double methodThree(int num, int power) {
        // функция возведения в степень
        double result;
        if (power > 0) {
            result = num;
            while (power > 1) {
                result *= num;
                power--;
            }
        } else if (power < 0) {
            if (num == 0) {
                System.out.println("Бесконечность!");
                result = Double.MAX_VALUE;
            } else
                result = (double) 1 / num;
            while (power < -1) {
                result /= num;
                power++;
            }
        } else if (num >= 0) {
            result = 1;
        } else result = -1;
        return result;
    }

    public static void methodFive(String s) {
        //1. Передать на вход программы число в качестве аргумента.
        // 2. Если оно нечетное, распечатать его.
        // 3. Используем оператор if.
        // 4. Используйте метод Integer.parseInt() для преобразования из String в int.
        int num = Integer.parseInt(s);
        if (!(num % 2 == 0)) {
            System.out.println(num);
        }
    }

    public static void methodSix() {
        //6. Число от 0 до 10.
        // 1. С помощью класса Scanner ввести целое число.
        // 2. Если это число от 0 до 10, вывести на консоль сообщение “Положительное число меньше 10 или ноль”,
        // иначе вывести сообщение “Положительное число больше 10 или отрицательное”.
        // 3. Используем оператор if-else.
        System.out.println("Введите целое число");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        // В условии задачи путаница т.к. не включено число 10
        // Зададим условие так, чтобы выведенное сообщение было верным
        if (number == 10) {
            System.out.println("10");
        } else if ((number >= 0) && (number <= 9)) {
            System.out.println("Положительное число меньше 10 или ноль");
        } else System.out.println("Положительное число больше 10 или отрицательное");
    }

    public static void methodSeven(int weekday) {
        //1. Передать на вход программы число от 1 до 7 в качестве аргумента.
        // 2. Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
        // Если 6 или 7 – “Выходной”.
        // 3. Используем конструкцию if-else-if.
        if (weekday == 1) {
            System.out.println("Понедельник");
        } else if (weekday == 2) {
            System.out.println("Вторник");
        } else if (weekday == 3) {
            System.out.println("Среда");
        } else if (weekday == 4) {
            System.out.println("Четверг");
        } else if (weekday == 5) {
            System.out.println("Пятница");
        } else if ((weekday == 6) || (weekday == 7)) {
            System.out.println("Выходной");
        } else System.out.println("Не день недели");
    }

    public static void methodEight(int weekday) {
        //Переписать задание "Дни недели" используя оператор switch
        switch (weekday) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
            case 7:
                System.out.println("Выходной");
                break;
            default:
                System.out.println("Не день недели");
        }
    }

    public static void methodNine() {
        //Распечатать 10 строк: “Task1”. “Task2”. … “Task10”. Используем цикл while.
        int stringcount = 1;
        while (stringcount < 11) {
            System.out.print("Task");
            System.out.println(stringcount);
            stringcount++;
        }
    }

    public static void methodTen() {
        //Распечатать все числа от 1 до 100, которые делятся на 5 без остатка.
        // Используем цикл do-while.
        int num = 1;
        do {
            if (num % 5 == 0) {
                System.out.println(num);
            }
            num++;
        } while (num <= 100);
    }

    public static void methodEleven() {
        //Распечатать 5 символов в одну строку начиная с ‘h’.
        // Используем цикл for.
        for (char symbol = 'h', counter = 0; !(counter == 15); counter++) {
            System.out.print(symbol);
            symbol++;
        }
    }

    public static void methodTwelve() {
        //Реализовать подсчет факториала используя цикл for.
        //Число n задается случайным образом (используйте Math.random()).
        // Оно должно быть в диапазоне от 0 до 5.
        int n = (int) (Math.random() * 6);
        System.out.println("n = " + n);
        System.out.print(n + "! = ");
        int factorial = 1;
        for (; n > 0; n--) {
            factorial *= n;
        }
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        //Задачи 1-3, 5-12 в виде отдельных методов в main
       Homework.StaticMethods.methodOne("Test line", 5);
        System.out.println(Homework.StaticMethods.methodTwo(1, 2, 3, 4));
        System.out.println(Homework.StaticMethods.methodThree(-1, 20));
        Homework.StaticMethods.methodFive("48943");
        Homework.StaticMethods.methodSix();
        Homework.StaticMethods.methodSeven(3);
        Homework.StaticMethods.methodEight(7);
        Homework.StaticMethods.methodNine();
        Homework.StaticMethods.methodTen();
        Homework.StaticMethods.methodEleven();
        Homework.StaticMethods.methodTwelve();
    }
}
