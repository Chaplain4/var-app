package by.itstep;

public class IfTester {

    public static void main(String[] args) {
        System.out.println("Begin");

        int t = -30;
        //if(<condition>) {<body>}, where <condition> can be either TRUE or FALSE!
        //if <condition> is TRUE -> <body>
        if (t > 20) {
            System.out.println("T-shirt");
        }

        if (t < -15) {
            System.out.println("Ice Jacket");
        }

        int mathMark = 7, chemistryMark = 5, englishMark = 9, biologyMark = 8, historyMark = 10;
        double average = (mathMark + chemistryMark + englishMark + biologyMark + historyMark) / (double) 5;
        System.out.println("Average mark = " + average);
        if (average >= 9) {
            System.out.println("Отличник");
        } else if (average >= 7) {
            System.out.println("Хорошист");
        } else System.out.println("Троечник");

        int a = 3, b = 4, c = 5;
        if (a + b > c) {
            if (b + c > a) {
                if (c + a > b) {
                    System.out.println("Δ is valid");
                }
            }
        } else System.out.println("Δ is invalid");


        if (a + b > c && b + c > a && c + a > b) {
            System.out.println("Δ is valid");
        } else System.out.println("Δ is invalid");
        System.out.println("End.");

        boolean flag = true;
        flag = false;

        int age =29, cash = 1134500, iq = 185;
        boolean marriage = false;
        if (age < 30) {
            {
                if (cash > 1000000) {
                    if (iq >120) {
                        marriage = true;
                    }
                }
            }
        } else marriage = false;
        System.out.println(marriage);
    }
}