package Homework;

public class StaticMethodsTaskFour {
    //Создайте класс, реализующий статические методы
    public static void methodOne(int q, int w) {
        //В переменных q и w хранятся два натуральных числа.
        // Создайте метод, выводящий на экран результат деления q на w с остатком.
        System.out.println(q + " / " + w + " = " + q / w + " и " + q % w + " в остатке");
    }

    public static void methodTwoAndFour(int n) {
        //Создайте метод, вычисляющий и выводящий на экран сумму цифр любого целого числа n.
        n = Math.abs(n);
        int result = n % 10;
        int digitCount = 0;
        while (Math.pow(10, digitCount) <= n) {
            digitCount++;
        }
        while (!(digitCount == 0)) {
            result += n / Math.pow(10, digitCount);
            n = (int) (n % Math.pow(10, digitCount));
            digitCount--;
        }
        System.out.println(result);
    }

    public static void methodThree(double n) {
        //В переменной n хранится вещественное число с ненулевой дробной частью.
        // Создайте метод, округляющий число n до ближайшего целого и выводящий результат на экран.
        int wholePart = (int) n;
        if (n - wholePart >= 0.5) {
            wholePart++;
        }
        System.out.println(wholePart);
    }

    public static void main(String[] args) {
        Homework.StaticMethodsTaskFour.methodOne(21, 8);
        Homework.StaticMethodsTaskFour.methodTwoAndFour(-12345);
        Homework.StaticMethodsTaskFour.methodThree(21.011991);
    }
}








