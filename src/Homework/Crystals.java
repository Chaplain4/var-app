package Homework;

import java.time.LocalDate;
import java.util.Scanner;

public class Crystals {
    public static void crystalRandom() {
        int[][] presentStudents = new int[13][2];
        for (int i = 0; i < 13; i++) {
            presentStudents[i][0] = i + 1;
        }
        int[] absentStudents = new int[13];
        int absentStudentsCount = 0;
        String[] studentNames = {"Азаренок Александр Юрьевич", "Аускерн Артур Леонидович", "Гарбар Александр Дмитриевич",
                "Гацура Евгений Валерьевич", "Клевко Артемий Сергеевич", "Купреева Татьяна Сергеевна",
                "Липницкий Артем Андреевич", "Малашевич Алексей Владимирович", "Михайлова Елена Витальевна",
                "Овсянникова Юлия Валерьевна", "Хрущ Кирилл Андреевич", "Шкред Ника Николаевна", "Шкутник Ольга Александровна"};
        Scanner sc = new Scanner(System.in);
        int input = -1;
        while (!(input == 0)) {
            for (int i = 0; i < 13; i++) {
                if (absentStudents[i] == 0) {
                    System.out.println("#" + presentStudents[i][0] + " - " + studentNames[i]);
                } else
                    System.out.println("#" + presentStudents[i][0] + " - " + studentNames[i] + " - absent :(");
            }
            System.out.println("Are there any absent students? Input absent student number or type 0 if everyone is already accounted for");
            input = sc.nextInt();
            if (input == 0) {
                break;
            } else if ((input > 0) && (input < 14)) {
                absentStudents[input - 1] = 1;
                absentStudentsCount++;
            } else System.out.println("Wrong input!");
        }
        System.out.println("======== Date of lessons: " + LocalDate.now() + " ===========");
        if (absentStudentsCount == 13) {
            System.out.println("No students present to allocate crystals for :(");
        } else if (absentStudentsCount == 12) {
            for (int i = 0; i < absentStudents.length; i++) {
                if (absentStudents[i] == 0) {
                    for (int j = 0; j < 6; j++) {
                        System.out.println("---------> #" + presentStudents[i][0] + " - " + studentNames[i] + " LUCKY WINS THE CRYSTAL !");
                        presentStudents[i][1]++;
                    }
                }
            }
        } else {
            for (int counter = 0; counter < 10; ) {
                input = (int) (Math.random() * 13);
                if (presentStudents[input][1] == 6) {
                    System.out.println("#" + presentStudents[input][0] + " - " + studentNames[input] + " - Max 6 crystals. However, you should be happy already!");
                } else if (absentStudents[input] == 0) {
                    System.out.println("---------> #" + presentStudents[input][0] + " - " + studentNames[input] + " LUCKY WINS THE CRYSTAL !");
                    presentStudents[input][1]++;
                    counter++;
                } else
                    System.out.println("#" + presentStudents[input][0] + " - " + studentNames[input] + " - absent :(");
            }
        }
        System.out.println();
        System.out.println("============== TOTAL REPORT ===============");
        for (int i = 0; i < 13; i++) {
            if (presentStudents[i][1] > 0) {
                System.out.print("---------> #" + presentStudents[i][0] + " - " + studentNames[i] + " - " + presentStudents[i][1] + " crystal");
                if (presentStudents[i][1] == 1) {
                    System.out.println();
                } else {
                    System.out.print("s");
                    System.out.println();
                }
            }
        }
        System.out.println("============== END =================");
    }

    public static void main(String[] args) {
        Homework.Crystals.crystalRandom();
    }
}