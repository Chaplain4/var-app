package Homework;

import java.util.Scanner;

public class Arrays {
    public static void task3dot0(int arrayLength) {
        //Создать и распечатать массив разными способами
        System.out.println("Beginning task 3.0");
        int array[] = new int[arrayLength];

        for (int n = 0; n < arrayLength; n++) {
            array[n] = (int) ((Math.random() * 10) + 1);
            System.out.print(array[n] + " ");
        }
        System.out.println();

        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();

        int n = 0;
        while (n < arrayLength) {
            array[n] = (int) ((Math.random() * 10) + 1);
            System.out.print(array[n] + " ");
            n++;
        }
        System.out.println();

        System.out.println("Finishing task 3.0");
    }

    public static int[] createIntArray(int arrayLength, int minValue, int maxValue) {
        if (minValue > maxValue) {
            System.out.println("Invalid Min/Max Values!");
        }
        int array[] = new int[arrayLength];
        if (minValue >= 0) {
            for (int n = 0; n < arrayLength; n++) {
                array[n] = (int) ((Math.random() * (maxValue - minValue + 1) + minValue));
            }
        } else if (maxValue >= 0) {
            for (int n = 0; n < arrayLength; n++) {
                array[n] = (int) ((Math.random() * (maxValue - minValue + 2) + minValue - 1));
            }
        } else {
            for (int n = 0; n < arrayLength; n++) {
                array[n] = (int) ((Math.random() * -1 * (minValue - (maxValue + 1)) + (minValue - 1)));
            }
        }
        return array;
    }


    public static void task3dot1(int[] array) {
        //Сумма и произведение элементов одномерного массива
        //Сумма положительных элементов массива
        System.out.println("Beginning task 3.1");
        if (array.length == 0) {
            System.out.println("Empty array!");
        } else
            for (int n = 0, sum = 0, multiplication = 1, positiveSum = 0; n < array.length; n++) {
                System.out.print(array[n] + " ");
                sum += array[n];
                multiplication *= array[n];
                if (array[n] > 0) {
                    positiveSum += array[n];
                }
                if (n == (array.length - 1)) {
                    System.out.println();
                    System.out.println("Sum of array elements is " + sum);
                    System.out.println("Multiplication of array elements is " + multiplication);
                    System.out.println("Sum of positive array elements is " + positiveSum);
                }
            }
        System.out.println("Finishing task 3.1");
    }

    public static void task3dot2(int[] array) {
        //Заменить элементы массива на противоположные
        System.out.println("Beginning task 3.2");
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int element1 = 0, element2 = (array.length - 1), temp1 = 0, temp2 = 0; element1 < element2; element1++, element2--) {
            temp1 = array[element1];
            temp2 = array[element2];
            array[element1] = temp2;
            array[element2] = temp1;
        }
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Finishing task 3.2");
    }

    public static void task3dot3andDot4(int[] array) {
        //Найти и распечатать MAX & MIN заданного массива
        //Поменять местами минимальный и максимальный элементы массива
        System.out.println("Beginning task 3.3, 3.4");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n : array) {
            System.out.print(n + " ");
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        System.out.println();
        System.out.println("MAX = " + max);
        System.out.println("MIN = " + min);
        for (int n = 0; n < array.length; n++) {
            if (array[n] == max) {
                array[n] = min;
            } else if (array[n] == min) {
                array[n] = max;
            }
        }
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Finishing task 3.3, 3.4");
    }

    public static void task3dot5(int[] array) {
        // Вывести элементы массива, которые больше среднего арифметического
        System.out.println("Beginning task 3.5");
        double average = 0;
        for (int n : array) {
            System.out.print(n + " ");
            average += n;
        }
        System.out.println();
        average /= array.length;
        System.out.println("Array average is " + average);
        System.out.println("Elements greater than average are: ");
        for (int n : array) {
            if (n > average) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
        System.out.println("Finishing task 3.5");
    }

    public static void task3dot6(int[] array) {
        //Распечатать:
        // 1. Минимальный из элементов массива с нечетными индексами
        // 2. Количества отрицательных и положительных элементов в массиве
        System.out.println("Beginning task 3.6");
        int minOdd = Integer.MAX_VALUE;
        int positiveCount = 0;
        int negativeCount = 0;
        int indexCounter = 0;
        for (int n : array) {
            System.out.print(n + " ");
            if ((n < minOdd) && !(indexCounter % 2 == 0)) {
                minOdd = n;
            }
            if (n > 0) {
                positiveCount++;
            } else if (n < 0) {
                negativeCount++;
            }
            indexCounter++;
        }
        System.out.println();
        System.out.println("Minimal element with odd index is " + minOdd);
        System.out.println("Number of positive elements is " + positiveCount);
        System.out.println("Number of negative elements is " + negativeCount);
        System.out.println("Finishing task 3.6");
    }

    public static void task3dot7() {
        // Вставка элемента в массив. Программа просит ввести массив с клавиатуры.
        //после ввода массив должен сохраниться в переменную и распечататься. Затем
        //предлагается ввести позицию и элемент для вставки. В случае если вставка не
        //возможна написать в консоль.
        // В случае успешной вставки распечатать модифицированный массив.
        System.out.println("Beginning task 3.7");
        Scanner sc = new Scanner(System.in);
        int arrayLength = 0;
        char option = 'y';
        String input = "";
        while (option == 'y' || option == 'Y') {
            System.out.println("Would you like to input element with index number " + arrayLength + " ?");
            System.out.println("Y/N?");
            option = sc.next().charAt(0);
            if (!(option == 'y' || option == 'Y' || option == 'n' || option == 'N')) {
                option = 'y';
                System.out.println("You must input Y or N!");
            } else if (option == 'y' || option == 'Y') {
                System.out.println("Input element with index number " + arrayLength + ". It must have Integer data type.");
                int nextValue = sc.nextInt();
                input = input + nextValue + " ";
                arrayLength++;
            }
        }
        System.out.println(input);
        String[] inputsArray = input.split(" ");
        int[] resultArray = new int[arrayLength];
        for (int n = 0; n < arrayLength; n++) {
            resultArray[n] = Integer.parseInt(inputsArray[n]);
        }
        option = 'y';
        while (option == 'y' || option == 'Y') {
            for (int n = 0; n < arrayLength; n++) {
                System.out.println("Element with index number " + n + " = " + resultArray[n]);
            }
            System.out.println("Would you like to edit this array?");
            System.out.println("Y/N?");
            option = sc.next().charAt(0);
            if (!(option == 'y' || option == 'Y' || option == 'n' || option == 'N')) {
                option = 'y';
                System.out.println("You must input Y or N!");
            } else if (option == 'y' || option == 'Y') {
                System.out.println("Select index number to edit the element");
                int nextValue = sc.nextInt();
                if ((nextValue < 0) || (nextValue > (resultArray.length - 1))) {
                    System.out.println("Invalid index number");
                } else {
                    System.out.println("Select new value for element with index number" + nextValue + ". It must have Integer data type.");
                    resultArray[nextValue] = sc.nextInt();
                }
            } else for (int n = 0; n < resultArray.length; n++) {
                System.out.println("Element with index number " + n + " = " + resultArray[n]);
            }
        }
        System.out.println("Finishing task 3.7");
    }

    public static void main(String[] args) {
        Homework.Arrays.task3dot0(5);
        Homework.Arrays.task3dot1(Homework.Arrays.createIntArray(5, -5, 5));
        Homework.Arrays.task3dot2(Homework.Arrays.createIntArray(5, 1, 10));
        Homework.Arrays.task3dot3andDot4(Homework.Arrays.createIntArray(50, -5, 5));
        Homework.Arrays.task3dot5(Homework.Arrays.createIntArray(50, -5, 5));
        Homework.Arrays.task3dot6(Homework.Arrays.createIntArray(10, -5, 5));
        Homework.Arrays.task3dot7();
    }
}

