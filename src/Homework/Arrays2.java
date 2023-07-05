package Homework;

import java.util.Scanner;

public class Arrays2 {
    public static void taskOne() {
        //Заполнить массив числами от -10 до 25 и выведите на экран.
        System.out.println("Beginning task 1");
        int array[] = new int[25 + 10 + 1];
        for (int n = 0; n < array.length; n++) {
            array[n] = -10 + n;
            System.out.print(array[n] + " ");
        }
        System.out.println();
        System.out.println("Finishing task 1");
    }

    public static void taskTwo() {
        System.out.println("Beginning task 2");
        //Заполнить массив числами от 1 до 100, которые делятся на 5 без остатка, выведите на экран.
        int arrayLength = 0;
        for (int n = 1; n < 101; n++) {
            if (n % 5 == 0) {
                arrayLength++;
            }
        }
        int array[] = new int[arrayLength];
        for (int n = 1, arrayNum = 0; n < 101; n++) {
            if (n % 5 == 0) {
                array[arrayNum] = n;
                System.out.print(array[arrayNum] + " ");
                arrayNum++;
            }
        }
        System.out.println();
        System.out.println("Finishing task 2");
    }

    public static void taskThree() {
        //Заполнить массив int типа числами от 100 до 0.
        System.out.println("Beginning task 3");
        int array[] = new int[101];
        for (int n = 0, arrayNum = 100; n < array.length; n++, arrayNum--) {
            array[n] = arrayNum;
        }
        System.out.println("Finishing task 3");
    }

    public static void taskFour(int[] array) {
        //Найти в массиве чисел элементы с наибольшим(max) и наименьшим(min) значениями.
        // Вывести эти 2 элемента на экран, а также посчитать и вывести сумму всех
        // остальных элементов (min и max в сумму не входят).
        System.out.println("Beginning task 4");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxElementIndexesCount = 0;
        int minElementIndexesCount = 0;
        int counter = 0;
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
        for (int n : array) {
            if (n == max) {
                maxElementIndexesCount++;
            }
            if (n == min) {
                minElementIndexesCount++;
            }
        }
        int maxElementIndexes[] = new int[maxElementIndexesCount];
        int minElementIndexes[] = new int[minElementIndexesCount];
        maxElementIndexesCount = 0;
        minElementIndexesCount = 0;
        for (int n : array) {
            if (n == max) {
                maxElementIndexes[maxElementIndexesCount] = counter;
                maxElementIndexesCount++;
            }
            if (n == min) {
                minElementIndexes[minElementIndexesCount] = counter;
                minElementIndexesCount++;
            }
            counter++;
        }
        System.out.println();
        System.out.println("MAX value = " + max);
        System.out.print("Element indexes containing MAX value are : ");
        for (int n : maxElementIndexes) {
            System.out.print("[" + n + "] ");
        }
        System.out.println();
        System.out.println("MIN value = " + min);
        System.out.print("Element indexes containing MIN value are : ");
        for (int n : minElementIndexes) {
            System.out.print("[" + n + "] ");
        }
        System.out.println();
        int sumWithoutMinAndMax = 0;
        for (int count = 0; count < array.length; count++) {
            if (!((array[count] == min) || (array[count] == max))) {
                sumWithoutMinAndMax += array[count];
            }
        }
        System.out.println("Sum of elements without MIN or MAX is : " + sumWithoutMinAndMax);
        System.out.println("Finishing task 4");
    }

    public static void taskFive() {
        //Написать метод для зеркального переворота элементов в массиве ([1, 2, 3, 4] -> [4, 3, 2, 1]).
        System.out.println("Beginning task 5");
        //Это задание аналогично заданию 3.2 из прошолго ДЗ. Ссылаемся на него.
        Homework.Arrays.task3dot2(Homework.Arrays.createIntArray(5, 1, 10));
        System.out.println("Finishing task 5");
    }

    public static void taskSix(int arrayLength) {
        //Написать метод, который заполнит массив произвольного размера числами по
        // возрастанию, начиная с центра массива, например, [5,4,3,2,1,0,1,2,3,4,5].
        System.out.println("Beginning task 6");
        int array[] = new int[arrayLength];
        for (int n = 0, value = array.length / 2; n < (array.length / 2); n++, value--) {
            array[n] = value;
            array[array.length - 1 - n] = value;
        }
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Finishing task 6");
    }

    public static void taskSeven(int[] array) {
        //Найти в массиве число, которое повторяется наибольшее количество раз
        System.out.println("Beginning task 7");
        int numberOfTimes = 0;
        int mostPopularNumber = 0;
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n = 0; n <= (array.length - 1); n++) {
            int counter = 0;
            for (int i = 0; i <= (array.length - 1); i++) {
                if (array[n] == array[i]) {
                    counter++;
                }
            }
            if (counter > numberOfTimes) {
                numberOfTimes = counter;
                mostPopularNumber = array[n];
            }
        }
        System.out.println("Most popular number is : " + mostPopularNumber);
        System.out.println("Array contains " + numberOfTimes + " instances of [" + mostPopularNumber + "]");
        System.out.println("Finishing task 7");
    }

    public static void taskEight() {
        //С помощью консоли пользователь вводит математическое выражение типа “1+33-4*7”.
        // Написать программу для подсчета его значения. Приоритет операций не учитывается.
        System.out.println("Beginning task 8");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input arithmetic problem :");
        String input = sc.next();
        char[] inputArray = input.toCharArray();
        int[][] numbersArray = new int[inputArray.length][inputArray.length];
        int[] digitCountArray = new int[inputArray.length];
        char[] operationsArray = new char[inputArray.length];
        int numberCount = 0;
        double result = 0;
        for (int n = 0, digitCount = 0; n < inputArray.length; n++) {
            if ((inputArray[n] > 47) && (inputArray[n] < 58)) {
                numbersArray[digitCount][numberCount] = Character.getNumericValue(inputArray[n]);
                digitCount++;
                if (n == inputArray.length - 1) {
                    digitCountArray[numberCount] = digitCount;
                }
            } else if ((inputArray[n] == '+') || (inputArray[n] == '-') || (inputArray[n] == '*') || (inputArray[n] == '/')) {
                operationsArray[numberCount] = inputArray[n];
                digitCountArray[numberCount] = digitCount;
                digitCount = 0;
                numberCount++;
            } else {
                System.out.println("Wrong input!");
                break;
            }
        }
        for (int num1 = 0, num2 = 0, x = 0; x < numberCount; x++) {
            num1 = 0;
            num2 = 0;
            for (int a = digitCountArray[x]; a > 0; a--) {
                num1 += (numbersArray[a - 1][x]) * ((int) Math.pow(10, digitCountArray[x] - a));
            }
            for (int a = digitCountArray[x + 1]; a > 0; a--) {
                num2 += (numbersArray[a - 1][x + 1]) * ((int) Math.pow(10, digitCountArray[x + 1] - a));
            }
            if (x == 0) {
                switch (operationsArray[x]) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = (double) num1 / num2;
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
            } else if (x < numberCount) {
                switch (operationsArray[x]) {
                    case '+':
                        result += num2;
                        break;
                    case '-':
                        result -= num2;
                        break;
                    case '*':
                        result *= num2;
                        break;
                    case '/':
                        result /= num2;
                        break;
                    default:
                        System.out.println("Wrong input!");
                }
            }
        }
        System.out.println("result = " + result);
        System.out.println("Finishing task 8");
    }

    public static void taskNine() {
        //Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран сначала в строку,
        // отделяя один элемент от другого пробелом, а затем в столбик (отделяя один элемент от другого началом
        // новой строки). Перед созданием массива подумайте, какого он будет размера.
        //2 4 6 … 18 20
        //2
        //4
        //6
        //…
        //20
        System.out.println("Beginning task 9");
        int arrayLength = 0;
        for (int n = 2; n <= 20; n++) {
            if (n % 2 == 0) {
                arrayLength++;
            }
        }
        int array[] = new int[arrayLength];
        arrayLength = 0;
        for (int n = 2; n <= 20; n++) {
            if (n % 2 == 0) {
                array[arrayLength] = n;
                arrayLength++;
            }
        }
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n : array) {
            System.out.println(n);
        }
        System.out.println("Finishing task 9");
    }

    public static void taskTen() {
        //Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
        // а затем этот же массив выведите на экран тоже в строку, но в обратном порядке
        // (99 97 95 93 … 7 5 3 1).
        System.out.println("Beginning task 10");
        int arrayLength = 0;
        for (int n = 1; n <= 99; n++) {
            if (!(n % 2 == 0)) {
                arrayLength++;
            }
        }
        int array[] = new int[arrayLength];
        arrayLength = 0;
        for (int n = 1; n <= 99; n++) {
            if (!(n % 2 == 0)) {
                array[arrayLength] = n;
                arrayLength++;
            }
        }
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n = arrayLength - 1; n >= 0; n--) {
            System.out.print(array[n] + " ");
        }
        System.out.println();
        System.out.println("Finishing task 10");
    }

    public static void taskEleven() {
        //Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
        //Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на отдельной строке.
        System.out.println("Beginning task 11");
        int[] array = Homework.Arrays.createIntArray(15, 0, 9);
        int oddCount = 0;
        for (int n : array) {
            System.out.print(n + " ");
            if (n % 2 == 0) {
                oddCount++;
            }
        }
        System.out.println();
        System.out.println("Number of odd elements is " + oddCount);
        System.out.println("Finishing task 11");
    }

    public static void taskTwelve() {
        //Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран в строку.
        // Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на экран на отдельной строке.
        System.out.println("Beginning task 12");
        int[] array = Homework.Arrays.createIntArray(8, 1, 10);
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n = 0; n < array.length; n++) {
            if (!(array[n] % 2 == 0)) {
                array[n] = 0;
            }
        }
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Finishing task 12");
    }

    public static void taskThirteen() {
        //Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите массивы на экран
        // в двух отдельных строках. Посчитайте среднее арифметическое элементов каждого массива и сообщите,
        // для какого из массивов это значение оказалось больше (либо сообщите, что их средние арифметические равны).
        System.out.println("Beginning task 13");
        int[] array1 = Homework.Arrays.createIntArray(5, 0, 5);
        int[] array2 = Homework.Arrays.createIntArray(5, 0, 5);
        int arr1sum = 0, arr2sum = 0;
        for (int n : array1) {
            System.out.print(n + " ");
            arr1sum += n;
        }
        System.out.println();
        for (int n : array2) {
            System.out.print(n + " ");
            arr2sum += n;
        }
        System.out.println();
        double arr1avg = (double) arr1sum / array1.length;
        double arr2avg = (double) arr2sum / array2.length;
        System.out.println("Array 1 average is " + arr1avg);
        System.out.println("Array 2 average is " + arr2avg);
        if (arr1avg > arr2avg) {
            System.out.println("Array 1 average is greater");
        } else if (arr2avg > arr1avg) {
            System.out.println("Array 2 average is greater");
        } else System.out.println("Array averages are equal");
        System.out.println("Finishing task 13");
    }

    public static void taskFourteen() {
        //Создайте массив из 4 случайных целых чисел из отрезка [10;99],
        // выведите его на экран в строку. Определить и вывести на экран сообщение о том,
        // является ли массив строго возрастающей последовательностью.
        System.out.println("Beginning task 14");
        int[] array = Homework.Arrays.createIntArray(4, 10, 99);
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        boolean constantlyIncreases = true;
        for (int n = array.length - 1; n > 0; n--) {
            if (array[n] < array[n - 1]) {
                constantlyIncreases = false;
            }
        }
        if (constantlyIncreases == true) {
            System.out.println("Array constantly increases");
        } else System.out.println("Array doesn't constantly increase");
        System.out.println("Finishing task 14");
    }

    public static void taskFifteen() {
        //Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран.
        // Напоминаем, что первый и второй члены последовательности равны единицам,
        // а каждый следующий — сумме двух предыдущих.
        System.out.println("Beginning task 15");
        int[] array = new int[20];
        array[0] = 1;
        array[1] = 1;
        for (int n = 2; n < array.length; n++) {
            array[n] = array[n - 1] + array[n - 2];
        }
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Finishing task 15");
    }

    public static void taskSixteen() {
        //Создайте массив из 12 случайных целых чисел из отрезка [-15;15].
        // Определите какой элемент является в этом массиве максимальным
        // и сообщите индекс его последнего вхождения в массив.
        System.out.println("Beginning task 16");
        int[] array = Homework.Arrays.createIntArray(12, -15, 15);
        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int n : array) {
            System.out.print(n + " ");
            if (n > max) {
                max = n;
            }
        }
        for (int n = 0; n < array.length; n++) {
            if (array[n] == max) {
                counter = n;
            }
        }
        System.out.println();
        System.out.println("MAX value is " + max);
        System.out.println("last index with MAX value is " + counter);
        System.out.println("Finishing task 16");
    }

    public static void taskSeventeen() {
        //Создайте два массива из 10 целых случайных чисел из отрезка [1;9] и третий массив из
        // 10 действительных чисел. Каждый элемент с i-ым индексом третьего массива должен равняться
        // отношению элемента из первого массива с i-ым индексом к элементу из второго массива с i-ым
        // индексом. Вывести все три массива на экран (каждый на отдельной строке), затем вывести
        // количество целых элементов в третьем массиве.
        System.out.println("Beginning task 17");
        int[] array1 = Homework.Arrays.createIntArray(10, 1, 9);
        int[] array2 = Homework.Arrays.createIntArray(10, 1, 9);
        double[] array3 = new double[10];
        int counter = 0;
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (double) array1[i] / array2[i];
            if (array3[i] % 1 == 0) {
                counter++;
            }
        }
        for (int n : array1) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n : array2) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (double n : array3) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Number of whole numbers in array 3 is " + counter);
        System.out.println("Finishing task 17");
    }

    public static void taskEighteen() {
        //Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив на экран в строку.
        // Определите какой элемент встречается в массиве чаще всего и выведите об этом сообщение на экран.
        // Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего
        System.out.println("Beginning task 18");
        int[] array = Homework.Arrays.createIntArray(11, -1, 1);
        int[] valueCount = new int[3];
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n = -1, i = 0; n <= 1; n++) {
            i = 0;
            for (; i < array.length; i++) {
                if (array[i] == n) {
                    valueCount[n + 1]++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int n : valueCount) {
            if (n > max) {
                max = n;
            }
        }
        for (int n : valueCount) {
            if (n == max) {
                counter++;
            }
        }
        if (counter == 1) {
            for (int n = 0; n < valueCount.length; n++) {
                if (valueCount[n] == max) {
                    System.out.println("Most popular element is " + (n - 1));
                }
            }
        }
        System.out.println("Finishing task 18");
    }

    public static void taskNineteen() {
        //Пользователь должен указать с клавиатуры чётное положительное число,
        // а программа должна создать массив указанного размера из случайных
        // целых чисел из [-5;5] и вывести его на экран в строку. После этого
        // программа должна определить и сообщить пользователю о том, сумма модулей
        // какой половины массива больше: левой или правой, либо сообщить, что эти суммы
        // модулей равны. Если пользователь введёт неподходящее число, то программа
        // должна требовать повторного ввода до тех пор, пока не будет указано корректное
        // значение.
        System.out.println("Beginning task 19");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array length :");
        int leftSide = 0;
        int rightSide = 0;
        int input = sc.nextInt();
        while (input <= 0) {
            System.out.println("Wrong length number! Input valid array length.");
            input = sc.nextInt();
        }
        int[] array = Homework.Arrays.createIntArray(input, -5, 5);
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n = 0; n < ((double) (array.length) / 2); n++) {
            if (array[n] < 0) {
                leftSide -= array[n];
            } else leftSide += array[n];
            if (array[array.length - 1 - n] < 0) {
                rightSide -= array[array.length - 1 - n];
            } else rightSide += array[array.length - 1 - n];
        }
        if (leftSide > rightSide) {
            System.out.println("Left side absolute value is greater");
        } else if (rightSide > leftSide) {
            System.out.println("Right side absolute value is greater");
        } else System.out.println("Absolute values of both sides are equal");
        System.out.println("Finishing task 19");
    }

    public static void taskTwenty() {
        //Программа должна создать массив из 12 случайных целых чисел из отрезка [-10;10] таким образом,
        // чтобы отрицательных и положительных элементов там было поровну и не было нулей. При этом порядок
        // следования элементов должен быть случаен (т. е. не подходит вариант, когда в массиве постоянно
        // выпадает сначала 6 положительных, а потом 6 отрицательных чисел или же когда элементы постоянно
        // чередуются через один и пр.). Вывести полученный массив на экран.
        System.out.println("Beginning task 20");
        int[] array = new int[12];
        int zeroCounter = 0;
        int positiveCounter = 0;
        int negativeCounter = 0;
        // решим задачу в лоб перебором - будем генерить случайные массивы пока не получим нужный
        do {
            array = Homework.Arrays.createIntArray(12, -10, 10);
            zeroCounter = 0;
            positiveCounter = 0;
            negativeCounter = 0;
            for (int n = 0; n < array.length; n++) {
                if (array[n] == 0) {
                    zeroCounter++;
                } else if (array[n] > 0) {
                    positiveCounter++;
                } else negativeCounter++;
            }
        } while (!((zeroCounter == 0) && (positiveCounter == negativeCounter)));
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("Finishing task 20");
    }

    public static void taskTwentyOne() {
        // Пользователь вводит с клавиатуры натуральное число большее 3, которое сохраняется в переменную n.
        // Если пользователь ввёл не подходящее число, то программа должна просить пользователя повторить ввод.
        // Создать массив из n случайных целых чисел из отрезка [0;n] и вывести его на экран. Создать второй
        // массив только из чётных элементов первого массива, если они там есть, и вывести его на экран.
        System.out.println("Beginning task 21");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array length :");
        int evenCounter = 0;
        int input = sc.nextInt();
        while (input <= 3) {
            System.out.println("Wrong length number! Input valid array length.");
            input = sc.nextInt();
        }
        int[] array = Homework.Arrays.createIntArray(input, 0, input);
        for (int n = 0; n < array.length; n++) {
            System.out.print(array[n] + " ");
            if (array[n] % 2 == 0) {
                evenCounter++;
            }
        }
        System.out.println();
        int[] evenArray = new int[evenCounter];
        evenCounter = 0;
        for (int n = 0; n < array.length; n++) {
            if (array[n] % 2 == 0) {
                evenArray[evenCounter] = array[n];
                evenCounter++;
            }
        }
        if (evenArray.length > 0) {
            for (int n : evenArray) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println("Finishing task 21");
    }

    public static int[][] create2dIntArray(int arrayLength, int arrayHeight, int minValue, int maxValue) {
        int array[][] = new int[arrayHeight][arrayLength];
        int[] nextLine;
        for (int m = 0; m < arrayHeight; m++) {
            nextLine = Homework.Arrays.createIntArray(arrayLength, minValue, maxValue);
            for (int n = 0; n < arrayLength; n++) {
                array[m][n] = nextLine[n];
            }
        }
        return array;
    }

    public static void print2dIntArray(int[][] array) {
        for (int[] a : array) {
            for (int i : a) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void taskTwentyTwo() {
        //Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных
        // целых чисел из отрезка [10;99]. Вывести массив на экран.
        System.out.println("Beginning task 22");
        Homework.Arrays2.print2dIntArray(Homework.Arrays2.create2dIntArray(5, 8, 10, 99));
        System.out.println("Finishing task 22");
    }

    public static void taskTwentyThree() {
        //Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел из отрезка [-99;99].
        // Вывести массив на экран. После на отдельной строке вывести на экран значение максимального элемента
        // этого массива (его индекс не имеет значения).
        System.out.println("Beginning task 23");
        int[][] array = Homework.Arrays2.create2dIntArray(8, 5, -99, 99);
        int max = Integer.MIN_VALUE;
        Homework.Arrays2.print2dIntArray(array);
        for (int[] a : array) {
            for (int i : a) {
                if (i > max) {
                    max = i;
                }
            }
        }
        System.out.println("MAX value is " + max);
        System.out.println("Finishing task 23");
    }

    public static void taskTwentyFour() {
        //Создать двумерный массив из 7 строк по 4 столбца в каждой из случайных целых чисел из отрезка [-5;5].
        // Вывести массив на экран. Определить и вывести на экран индекс строки с наибольшим по модулю
        // произведением элементов. Если таких строк несколько, то вывести индекс первой встретившейся из них.
        System.out.println("Beginning task 24");
        int[][] array = Homework.Arrays2.create2dIntArray(4, 7, -5, 5);
        int max = Integer.MIN_VALUE;
        Homework.Arrays2.print2dIntArray(array);
        int[] lineAbsoluteValueArray = new int[7];
        for (int n = 0; n < 7; n++) {
            for (int m = 0; m < 4; m++) {
                if (array[n][m] > 0) {
                    lineAbsoluteValueArray[n] += array[n][m];
                } else lineAbsoluteValueArray[n] -= array[n][m];
            }
        }
        for (int n : lineAbsoluteValueArray) {
            if (n > max) {
                max = n;
            }
        }
        for (int n = 0; n < lineAbsoluteValueArray.length; n++) {
            if (lineAbsoluteValueArray[n] == max) {
                System.out.println("Index number of greatest absolute value line #1 is " + n);
                break;
            }
        }
        System.out.println();
        System.out.println("Finishing task 24");
    }

    public static void taskTwentyFive() {
        //Создать двумерный массив из 6 строк по 7 столбцов в каждой из случайных целых чисел из отрезка [0;9].
        // Вывести массив на экран. Преобразовать массив таким образом, чтобы на первом месте в каждой строке
        // стоял её наибольший элемент. При этом изменять состав массива нельзя, а можно только переставлять
        // элементы в рамках одной строки. Порядок остальных элементов строки не важен (т.е. можно соврешить
        // только одну перестановку, а можно отсортировать по убыванию каждую строку). Вывести преобразованный
        // массив на экран.
        System.out.println("Beginning task 25");
        int[][] array = Homework.Arrays2.create2dIntArray(7, 6, 0, 9);
        Homework.Arrays2.print2dIntArray(array);
        //Отсортируем всё
        boolean arrayIsArranged = false;
        while (arrayIsArranged == false) {
            for (int n = 0, placeholder1 = -1, placeholder2 = -1; n < 6; n++) {
                for (int m = 0; m < 6; m++) {
                    if (array[n][m] < array[n][m + 1]) {
                        placeholder1 = array[n][m];
                        placeholder2 = array[n][m + 1];
                        array[n][m] = placeholder2;
                        array[n][m + 1] = placeholder1;
                    }
                }
                if (placeholder1 == -1) {
                    arrayIsArranged = true;
                }
            }
        }
        System.out.println();
        Homework.Arrays2.print2dIntArray(array);
        System.out.println("Finishing task 25");
    }

    public static void taskTwentySix() {
        //Для проверки остаточных знаний учеников после летних каникул, учитель младших классов решил начинать
        // каждый урок с того, чтобы задавать каждому ученику пример из таблицы умножения, но в классе 15 человек,
        // а примеры среди них не должны повторяться. В помощь учителю напишите программу, которая будет выводить
        // на экран 15 случайных примеров из таблицы умножения (от 2*2 до 9*9, потому что задания по умножению на
        // 1 и на 10 — слишком просты). При этом среди 15 примеров не должно быть повторяющихся (примеры 2*3 и 3*2
        // и им подобные пары считать повторяющимися).
        System.out.println("Beginning task 25");
        int[] var1array = new int[15];
        int[] var2array = new int[15];
        // решим задачу в лоб перебором - будем генерить случайные массивы пока не получим нужные
        int repeats = 16;
        while (repeats > 15) {
            repeats = 0;
            var1array = Homework.Arrays.createIntArray(15, 2, 9);
            var2array = Homework.Arrays.createIntArray(15, 2, 9);
            for (int n = 0; n < var1array.length; n++) {
                for (int m = 0; m < var2array.length; m++) {
                    if (((var1array[n] == var1array[m]) && (var2array[n] == var2array[m])) || ((var1array[n] == var2array[m]) && (var2array[n] == var1array[m]))) {
                        repeats++;
                    }
                }
            }
        }
        for (int n = 0; n < var1array.length; n++) {
            System.out.println(var1array[n] + " x " + var2array[n] + " = ?");
        }
        System.out.println("Finishing task 25");
    }

    public static void main(String[] args) {
//        Homework.Arrays2.taskOne();
//        Homework.Arrays2.taskTwo();
//        Homework.Arrays2.taskThree();
//        //используем метод создания случайного массива из прошлого ДЗ
//        Homework.Arrays2.taskFour(Homework.Arrays.createIntArray(10, -5, 5));
//        Homework.Arrays2.taskFive();
//        Homework.Arrays2.taskSix(8);
//        Homework.Arrays2.taskSeven(Homework.Arrays.createIntArray(10, -5, 5));
//        Homework.Arrays2.taskEight();
//        Homework.Arrays2.taskNine();
//        Homework.Arrays2.taskTen();
//        Homework.Arrays2.taskEleven();
//        Homework.Arrays2.taskTwelve();
//        Homework.Arrays2.taskThirteen();
//        Homework.Arrays2.taskFourteen();
//        Homework.Arrays2.taskFifteen();
//        Homework.Arrays2.taskSixteen();
//        Homework.Arrays2.taskSeventeen();
//        Homework.Arrays2.taskEighteen();
//        Homework.Arrays2.taskNineteen();
//        Homework.Arrays2.taskTwenty();
//        Homework.Arrays2.taskTwentyOne();
//        Homework.Arrays2.taskTwentyTwo();
//        Homework.Arrays2.taskTwentyThree();
//        Homework.Arrays2.taskTwentyFour();
        Homework.Arrays2.taskTwentyFive();
//        Homework.Arrays2.taskTwentySix();

    }
}