package Homework;

import java.util.Random;
import java.util.Scanner;

public class ifelsefor {
    public static void taskOne() {
//        1. Дано целое число. Если оно является положительным, то прибавить к нему
//        1; Если отрицательным, то вычесть из него 2; если нулевым, то заменить его
//        на 10. Вывести полученное число.
        System.out.println("Beginning Task One");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input an integer");
        int number = sc.nextInt();
        if (number > 0) {
            number++;
        } else if (number < 0) {
            number = number - 2;
        } else number = 10;
        System.out.println("result is " + number);
        System.out.println("Finishing Task One");
    }

    public static void taskTwo() {
//        2. Даны три числа. Вывести эти числа в порядке убывания / возрастания.
        System.out.println("Beginning Task Two");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input three numbers");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double num3 = sc.nextDouble();
        System.out.println("From (g)reatest to smallest or from (s)mallest to greatest?");
        char letter = sc.next().charAt(0);
        for (; !(letter == 'g' || letter == 's'); ) {
            System.out.println("You must input g or s");
            letter = sc.next().charAt(0);
        }
        if (num1 > num2) {
            if (num2 > num3 || num2 == num3) {
                if (letter == 'g') {
                    System.out.println(num1 + " " + num2 + " " + num3);
                } else System.out.println(num3 + " " + num2 + " " + num1);
            } else if (num3 > num1 || num3 == num1) {
                if (letter == 'g') {
                    System.out.println(num3 + " " + num1 + " " + num2);
                } else System.out.println(num2 + " " + num1 + " " + num3);
            } else if (letter == 'g') {
                System.out.println(num1 + " " + num3 + " " + num2);
            } else System.out.println(num2 + " " + num3 + " " + num1);
        } else if (num1 < num2) {
            if (num3 > num2 || num2 == num3) {
                if (letter == 'g') {
                    System.out.println(num3 + " " + num2 + " " + num1);
                } else System.out.println(num1 + " " + num2 + " " + num3);
            } else if (num3 > num1 || num3 == num1) {
                if (letter == 'g') {
                    System.out.println(num2 + " " + num3 + " " + num1);
                } else System.out.println(num1 + " " + num3 + " " + num2);
            } else if (letter == 'g') {
                System.out.println(num2 + " " + num1 + " " + num3);
            } else System.out.println(num3 + " " + num1 + " " + num2);
        } else {
            if (num3 > num2) {
                if (letter == 'g') {
                    System.out.println(num3 + " " + num2 + " " + num1);
                } else System.out.println(num1 + " " + num2 + " " + num3);
            } else {
                if (letter == 'g') {
                    System.out.println(num1 + " " + num2 + " " + num3);
                } else System.out.println(num3 + " " + num2 + " " + num1);
            }
        }
        System.out.println("Finishing Task Two");
    }

    public static void taskThree() {
//        3. Даны три числа. Найти среднее из них (то есть число, расположенное
//        между наименьшим и наибольшим).
        System.out.println("Beginning Task Three");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input three numbers");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double num3 = sc.nextDouble();
        if (num1 > num2) {
            if (num2 > num3 || num2 == num3) {
                System.out.println(num2);
            } else if (num3 > num1 || num3 == num1) {
                System.out.println(num1);
            } else System.out.println(num3);
        } else if (num1 < num2) {
            if (num3 > num2 || num2 == num3) {
                System.out.println(num2);
            } else if (num3 > num1 || num3 == num1) {
                System.out.println(num3);
            } else
                System.out.println(num1);
        } else {
            if (num3 > num2) {
                System.out.println(num2);
            } else {
                System.out.println(num2);
            }
        }
        System.out.println("Finishing Task Three");
    }

    public static void taskFour() {
        // 4*. Необходимо написать программу, которая проверяет пользователя на знание таблицы умножения.
        //Пользователь сам вводит два целых числа. Программа задаёт вопрос: результат умножения первого числа на второе.
        //Пользователь должен ввести ответ и увидеть на экране правильно он ответил или нет.
        //Если нет — показать еще и правильный результат.
        System.out.println("Beginning Task Four");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input two numbers");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("Can you count " + num1 + " x " + num2 + " ?");
        System.out.println("Input answer");
        int answer = sc.nextInt();
        if (answer == num1 * num2) {
            System.out.println("Correct!");
        } else System.out.println("You made a mistake! Correct answer is " + num1 * num2 + ".");
        System.out.println("Finishing Task Four");
    }

    public static void methodOne() {
        //5. Создайте метод (например – methodOne()), выводящий на консоль
        // все четырёхзначные числа последовательности 1000 1003 1006 1009
        // 1012 1015...
        System.out.println("Beginning Task Five");
        for (int x = 1000; x < 10000; x = x + 3) {
            System.out.println(x);
        }
        System.out.println("Finishing Task Five");
    }

    public static void methodTwo() {
        //6. Создайте метод (например – methodTwo()), выводящий на консоль
        // первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17
        System.out.println("Beginning Task Six");
        for (int x = 1, counter = 0; counter < 55; counter++) {
            System.out.println(x);
            x = x + 2;
        }
        System.out.println("Finishing Task Six");
    }

    public static void methodThree() {
        //7.  Создайте метод (например – methodThree()), выводящий на консоль все
        // неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….
        System.out.println("Beginning Task Seven");
        for (int x = 90; !(x < 0); x = x - 5) {
            System.out.println(x);
        }
        System.out.println("Finishing Task Seven");
    }

    public static void methodFour() {
        //8. Создайте метод (например – methodFour()), выводящий на консоль
        // первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
        System.out.println("Beginning Task Eight");
        for (int x = 2, counter = 0; counter < 20; counter++) {
            System.out.println(x);
            x = x * 2;
        }
        System.out.println("Finishing Task Eight");
    }

    public static void methodFive() {
        //9. * Создайте метод (например – methodFive()), выводящий на консоль все
        // положительные делители натурального числа, введённого
        // пользователем с клавиатуры.
        System.out.println("Beginning Task Nine");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input natural number");
        int number = sc.nextInt();
        int divisors = 0;
        if (!(number > 0)) {
            System.out.println("Not a natural number!");
        } else
            for (int counter = number; counter > 0; counter--) {
                if (number % counter == 0) {
                    divisors++;
                    System.out.println("Divisor #" + divisors + " = " + counter);
                }
            }
        if (divisors == 2) {
            System.out.println(number + " is a prime number!");
            // 1 не простое число
        }
        System.out.println("Finishing Task Nine");
    }

    public static void taskTen() {
        //10. Создать программу «Угадай число»
        //Попросите пользователя угадать  число от 0 до 100. У него будет семь попыток на
        // угадывание. При каждой попытке будет выводиться сообщение - "Мало" или "Много".
        // Если пользователь угадал, уложившись в семь попыток, то он выиграл. Если нет, то нет.
        System.out.println("Beginning Task Ten");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int secret = random.nextInt(101);
        System.out.println("You need to guess a random number within [0;100] range. You have 7 attempts");
        System.out.println("If your guess is wrong, you will receive a hint: <too great> or <too small>");
        int guess = 101;
        for (int attempts = 7; attempts > -1; attempts--) {
            if (attempts == 0) {
                System.out.println("You are out of attempts!");
                System.out.println("Guessed number was " + secret);
                break;
            } else
                System.out.println("Input your guess #" + (8 - attempts));
            guess = sc.nextInt();
            if (guess == secret) {
                System.out.println("Your guess #" + (8 - attempts) + " is correct!");
                break;
            } else if (guess > secret) {
                System.out.println("too great");
            } else System.out.println("too small");
        }
        System.out.println("Finishing Task Ten");
    }

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        methodOne();
        methodTwo();
        methodThree();
        methodFour();
        methodFive();
        taskTen();
    }
}
