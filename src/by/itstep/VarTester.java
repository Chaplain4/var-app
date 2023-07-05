package by.itstep;

import java.util.Arrays;

public class VarTester {



    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println("My name is Arthur");
        System.out.print("Current t = -2\n");
        System.out.print("Tomorrow t= -6\n");

        //variable declaration - объявление переменной
        // <type> <var_name>;
        int temp;

        //variable initialisation - инициализация переменной, ввод данных в переменную
        //<var_name> = <value>;
        temp = -2;
        double avg;
        avg = 9.9;

        //variable declaration & initialisation in single line
        //<type> <var_name> = <value>;
        int age = 31;
        int height = 168;


        int tempTomorrow = -4;
        System.out.println("temp today = " + temp);
        System.out.println("temp tomorrow = " + tempTomorrow);

        // <type> <var_name> = <value>, ...;
        int a = 15, b = 30;
        int mathMark = 7, chemistryMark = 6, englishMark = 9, biologyMark = 8;

        System.out.println("math mark = " + mathMark);
        System.out.println("chemistry mark = " + chemistryMark);
        System.out.println("english mark = " + englishMark);
        System.out.println("biology mark = " + biologyMark);

    }


}
