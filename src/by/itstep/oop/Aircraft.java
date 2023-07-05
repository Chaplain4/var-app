package by.itstep.oop;

import java.util.Scanner;

public class Aircraft {
    double speed;
    double thrust;
    double stallSpeed;
    double neverExceedSpeed;
    double alphaAngle;
    double maxAlpha;
    double heading;
    double altitude;
    double bankAngle;
    double climbAngle;
    boolean hasCrashed;



    Scanner sc = new Scanner(System.in);

    double calculateSpeed(double speed, double alphaAngle, double thrust, double neverExceedSpeed, double stallSpeed) {
        double nextSpeed = speed * Math.sin(alphaAngle) + (thrust * (neverExceedSpeed / speed));
        if ((nextSpeed >= neverExceedSpeed) || (nextSpeed <= stallSpeed)) {
            hasCrashed = true;
        }
        return nextSpeed;
    }

    double calculateAlpha(double climbAngle, double alphaAngle, double speed, double maxAlpha) {
        alphaAngle = alphaAngle + (climbAngle / speed);
        if (alphaAngle <= maxAlpha) {
            hasCrashed = true;
        }
        return alphaAngle;
    }

    double calculateHeading(double heading, double bankAngle) {
        double newHeading = heading + ((bankAngle / 90) * (speed / 100));
        if (newHeading < 0) {
            newHeading = 360 - newHeading;
        } else if (newHeading > 360) {
            newHeading = newHeading - 360;
        }
        return newHeading;
    }

    double calculateAltitude(double altitude, double alphaAngle, double speed, double climbAngle) {
        altitude = altitude + (alphaAngle*speed);
        if (altitude < 0) {
            hasCrashed = true;
        }
        return altitude;
    }


    double changeThrust() {
        System.out.println("Select thrust level (0.0 .. 1.0)");
        double Thrust = sc.nextDouble();
        return Thrust;
    }

    double changeBankAngle() {
        System.out.println("Select bank angle (-90.0 .. +90.0)");
        double BankAngle = sc.nextDouble();
        return BankAngle;
    }

    double changeClimbAngle() {
        System.out.println("Select climb angle (-90.0 .. +90.0)");
        double ClimbAngle = sc.nextDouble();
        return ClimbAngle;
    }

    void flightParameters(double speed, double alphaAngle, double heading, double altitude) {
        do {
            changeThrust();
            changeBankAngle();
            changeClimbAngle();
            calculateAlpha(climbAngle, alphaAngle, speed, maxAlpha);
            calculateSpeed(speed, alphaAngle, thrust, neverExceedSpeed, stallSpeed);
            calculateAltitude(altitude, alphaAngle, speed, climbAngle);
            calculateHeading(heading, bankAngle);

            System.out.println("Speed = " + speed);
            System.out.println("Heading = " + heading);
            System.out.println("Alpha angle = " + alphaAngle);
            System.out.println("Altitude = " + altitude);
        } while (true);
    }

}

class Test {
    public static void main(String[] args) {
        Aircraft f16 = new Aircraft();
        f16.altitude = 5000;
        f16.maxAlpha = 30;
        f16.neverExceedSpeed = 2700;
        f16.heading = 180;
        f16.stallSpeed = 150;
        f16.speed = 340;
        f16.alphaAngle = 0;
        f16.bankAngle = 0;
        f16.hasCrashed = false;
        f16.flightParameters(f16.speed, f16.alphaAngle, f16.heading, f16.altitude);
    }
}