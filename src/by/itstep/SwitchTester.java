package by.itstep;

import java.util.Scanner;

public class SwitchTester {

    public static void task1(){
        Scanner sc = new Scanner(System.in);
        int monthNum = sc.nextInt();
        switch (monthNum){
            case 1:
            case 2:
            case 12:
                System.out.println("winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("autumn");
                break;
            default:
                System.out.println("no such month number");
        }
    }{
        Scanner sc = new Scanner(System.in);
        int monthNum = sc.nextInt();
        switch (monthNum){
            case 1:
            case 2:
            case 12:
                System.out.println("winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("autumn");
                break;
            default:
                System.out.println("no such month number");
        }
    }
    public static void task2() {
        System.out.println("Input character");
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);
        if ((letter > 64 && letter < 91) || (letter > 96 && letter < 123)) {
            switch (letter) {
                case 65:
                case 97:
                case 69:
                case 101:
                case 73:
                case 105:
                case 79:
                case 111:
                case 85:
                case 117:
                case 89:
                case 121:
                    System.out.println("Vowel");
                    break;
                default:
                    System.out.println("Consonant");
            }
        } else System.out.println("not a letter!");
    }

    public static void main(String[] args) {
        task2();
//        task1();
//        int num = 1;
//
//        //switch (var) {body with cases}
//
//        switch (num) {
//            case 1:
//                System.out.println("One");
//            case 2:
//                System.out.println("Two");
//                break;
//            default:
//                System.out.println("Not One and Not Two!");
//        }
//
//        //ввести день недели (номер). Вывести в консоль название.
//        System.out.println("Input weekday number");
//        Scanner sc = new Scanner(System.in);
//        int dayNumber = sc.nextInt();
//        switch (dayNumber) {
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            case 7:
//                System.out.println("Sunday");
//                break;
//            default:
//                System.out.println("No weekday w/this number!");
//        }
//
//        System.out.println("Input month number");
//        int monthNumber = sc.nextInt();
//        switch (dayNumber) {
//            case 1:
//                System.out.println("Jan");
//                break;
//            case 2:
//                System.out.println("Feb");
//                break;
//            case 3:
//                System.out.println("Mar");
//                break;
//            case 4:
//                System.out.println("Apr");
//                break;
//            case 5:
//                System.out.println("May");
//                break;
//            case 6:
//                System.out.println("Jun");
//                break;
//            case 7:
//                System.out.println("Jul");
//                break;
//            case 8:
//                System.out.println("Aug");
//                break;
//            case 9:
//                System.out.println("Sep");
//                break;
//            case 10:
//                System.out.println("Oct");
//                break;
//            case 11:
//                System.out.println("Nov");
//                break;
//            case 12:
//                System.out.println("Dec");
//                break;
//            default:
//                System.out.println("No month w/this number!");
//
//        }
//
    }
}
