package by.itstep;

public class MathUtil {

    public static void varTester(double val) {
        double d;
        d = val;
        System.out.println(d);
        d += d;
        System.out.println(d);
    }


    public static void forTester(int num, double val, boolean flag) {
        for (int i = 0; i < num; i++) {
            if (flag) {
                System.out.print((val += val) + " ");
            } else System.out.print((val += val) + ",");
        }
    }


    public static void main(String[] args) {
        System.out.println("Main started");
        varTester(5.55);
        forTester(4, 5, false);
    }
}