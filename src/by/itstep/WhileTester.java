package by.itstep;

import java.util.Scanner;

public class WhileTester {
    public static void main(String[] args) throws InterruptedException {
        int num = 0;
        while (num < 10) {
            int studentNumber = ((int) (Math.random() * 13)) + 1;
            System.out.println(studentNumber);
            num++;
        }

    }


//        int t = 23;
//        double volume = 0;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("how many liters do you like to boil?");
//
//        double desiredVolume = sc.nextInt();
//        if (desiredVolume <= 0.1 || desiredVolume >= 2.5) {
//
//
//            while (desiredVolume <= 0.1 || desiredVolume >= 2.5) {
//                System.out.println("incorrect volume!");
//                System.out.println("how many liters do you like to boil?");
//                desiredVolume = sc.nextInt();
//            }
//
//        }
//        while (volume <= desiredVolume) {
//            System.out.println("pouring..");
//            volume += (Math.random()*1/2);
//            System.out.println("current volume = " + volume);
//        }
//
//
//        final int max = 100; //константа
//        while (t <= max) {
//            System.out.println("working..");
//            Thread.sleep(500/ (long) volume);
//            int x = (int) (Math.random() * 6) + 5;
//            t += x; // t = t+x;
//            System.out.println("current temp = " + t);
//        }
//    }
}
