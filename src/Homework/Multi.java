package interesting;

public class Multi {
    public static void multiplication() {
        System.out.println("                                 ТАБЛИЦА УМНОЖЕНИЯ");
        System.out.println();
        for (int num1 = 1, num2 = 1, result = 4, rowCount = 1, stackCount = 1, barCount = 1; barCount < 3; barCount++) {
            rowCount = 1;
            for (; rowCount < 11; rowCount++) {
                stackCount = 1;
                for (; stackCount < 6; stackCount++, num1++) {
                    result = num1 * num2;
                    if (result > 9 && num1 > 9 && num2 > 9) {
                        System.out.print(num1 + " x " + num2 + " = " + result + "      ");
                    } else if (result > 9 && (num1 > 9 || num2 > 9)) {
                        System.out.print(num1 + " x " + num2 + " = " + result + "       ");
                    } else if (result > 9) {
                        System.out.print(num1 + " x " + num2 + " = " + result + "        ");
                    } else System.out.print(num1 + " x " + num2 + " = " + result + "         ");
                }
                System.out.println();
                num1 = num1 - 5;
                num2++;
            }
            System.out.println();
            num2 = num2-10;
            num1 = num1+5;
        }
    }

    public static void main(String[] args) {
        multiplication();
    }
}
