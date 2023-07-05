package by.itstep;

import java.util.Arrays;

public class ArraysUtil {

    public static void printArray(int[] array) {
        for (int counter = 0; counter < array.length; counter++) {
            System.out.println("array [" + counter + "] = " + array[counter]);
        }
    }

    public static void printArrayInOneLine(int[] array) {
        for (int counter = 0; counter < array.length; counter++) {
            System.out.print("array [" + counter + "] = " + array[counter] +"\t");
        }
        System.out.println();
    }

    // arr = {1 , 2 , 3}

    public static void printArrayInOneLinev2(int[] array) {
        System.out.print("arr = {");
        for (int counter = 0; counter < array.length; counter++) {
            if (counter ==array.length -1) {
                System.out.print(array[array.length-1]+"}\n");
            } else {
                System.out.print(array[counter] +", ");
            }
        }
    }

    public static int[] randomArray (int length, int minValue, int maxValue) {
        int [] result = new int[length];
        for (int counter = 0; counter < length; counter++) {
            result[counter]= (int) (Math.random() * (maxValue - minValue + 1) - minValue);
        }
        return result;
    }

    public static void main(String[] args) {
        //Arrays declaration
        //single dimension

        int arr[];
        int[] arr2;
        double[] dArr;
        boolean[] flags;

        //two-dimension

        int[][] arr3;
        int[] arr4[];

        //multi-dimension

        int[][] arr5[][][][][];


        // Arrays initialization
        // 0  1  2
        int[] arr10 = {1, 2, 3};
        //  0  1  2   3   4
        int[] arr100 = {5, 0, 3, -9, 671};
        // {0, 1, 2, 3, 4}
        // {0, 0, 0, 0, 0}
        int[] arr11 = new int[5];
        int[] arr14 = new int[500]; // 500 нулей

        //  0   1
        arr = new int[]{12, 2};


        // size
        int arr100Size = arr100.length;
        System.out.println("number of elements is " + arr100Size);
        System.out.println("number of elements is " + arr14.length);

        // GET ELEMENT FROM ARRAY
        int val = arr100[4];
        int x = 4;
        val = arr100[x];
        System.out.println("value is " + val);
        for (int i = 0; i < 500; i++) {
            System.out.print(arr14[i]);
        }
        System.out.println();

        // index
        // 0   1   2    3            4
        int array[] = {34, 33, 0, -800, Integer.MAX_VALUE};
        int index = 0;
        System.out.println("First element = " + array[index]);

        int lastIndex = array.length - 1;
        System.out.println("Last element = " + array[lastIndex]);

        int i = array.length - 1;
        System.out.print("Element = " + array[i]);

        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(chars[chars.length - 1]);

        // SET ELEMENT INTO ARRAY
        int[] arr1000 = new int[100];
        arr1000[0] = -100;
        arr1000[1] = Integer.MIN_VALUE;
        arr1000[99] = (int) (Math.random() * 101);
        System.out.println("Last element = " + arr1000[arr1000.length - 1]);


        int a[] = new int[5];
        a[0] = 22;
        a[1] = 123;
        a[2] = 10;
        a[3] = -99;
        a[4] = 0;

        int[] aCopy = new int[a.length + 3];

        for (int counter = 0; counter < a.length; counter++) {
            aCopy[counter] = a[counter];
        }

        for (int counter = 0; counter < 4; counter++) {
            aCopy[5] = aCopy[5] + aCopy[counter];
        }

        aCopy[6] = aCopy[0] * 100;

        aCopy[7] = aCopy.length;

        printArray(aCopy);
        printArrayInOneLine(aCopy);
        printArrayInOneLinev2(aCopy);
        randomArray(5,0,9);
        printArray(randomArray(5,0,9));
    }
}