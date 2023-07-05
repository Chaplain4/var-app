package by.itstep.oop.model;

public class CoffeeMachine {
    private static int machinesCreated = 0;
    private String model;
    private int cupCount;
    private double waterCount;
    private double milkCount;
    private double coffeeCount;
    private double sugarCount;
    private double garbageCount;
    private int currentWaterTemp;
    private boolean isBusy = false;
    private boolean isOn = false;
    private boolean nonOperational = false;
    private boolean serviceRequired = false;
    private final double MAXWATER = 2000;
    private final double MAXMILK = 1000;
    private final double MAXCOFFEE = 1000;
    private final double MAXSUGAR = 500;
    private final double MAXGARBAGE = 95;
    private final double MINWATER = 249;
    private final double MINMILK = 49;
    private final double MINCOFFEE = 4;
    private final double MINSUGAR = 4;


    public void addWaterCount(double waterCount) {
        if (getWaterCount() + waterCount < MAXWATER) {
            this.waterCount = getWaterCount() + waterCount;
        } else this.waterCount = MAXWATER;
    }

    public void addMilkCount(double milkCount) {
        if (getMilkCount() + milkCount < MAXMILK) {
            this.milkCount = getMilkCount() + milkCount;
        } else this.milkCount = MAXMILK;
    }

    public void addCoffeeCount(double coffeeCount) {
        if (getCoffeeCount() + coffeeCount < MAXCOFFEE) {
            this.coffeeCount = getCoffeeCount() + coffeeCount;
        } else this.coffeeCount = MAXCOFFEE;
    }

    public void addSugarCount(double sugarCount) {
        if (getSugarCount() + sugarCount < MAXSUGAR) {
            this.sugarCount = getSugarCount() + sugarCount;
        } else this.sugarCount = MAXSUGAR;
    }

    public void removeGarbage() {
        this.garbageCount = 0;
    }

    public void checklist() {
        if (!isBusy && isOn && garbageCount < MAXGARBAGE && waterCount > MINWATER && milkCount > MINMILK
                && coffeeCount > MINCOFFEE && sugarCount > MINSUGAR && !serviceRequired) {
        } else nonOperational = true;
        if (isBusy) {
            System.out.println("Already busy!");
        }
        if (!isOn) {
            System.out.println("Machine is off!");
        }
        if (garbageCount >= MAXGARBAGE) {
            System.out.println("Remove garbage!");
        }
        if (waterCount <= MINWATER) {
            System.out.println("Add water!");
        }
        if (milkCount <= MINMILK) {
            System.out.println("Add milk!");
        }
        if (coffeeCount <= MINCOFFEE) {
            System.out.println("Add coffee!");
        }
        if (sugarCount <= MINSUGAR) {
            System.out.println("Add sugar!");
        }
        if (serviceRequired) {
            System.out.println("Service required!");
        }
    }

    public void serviceMachine() {
        serviceRequired = false;
    }

    public static int getMachinesCreated() {
        return machinesCreated;
    }

    public String getModel() {
        return model;
    }

    public int getCupCount() {
        return cupCount;
    }

    public double getWaterCount() {
        return waterCount;
    }

    public double getMilkCount() {
        return milkCount;
    }

    public double getCoffeeCount() {
        return coffeeCount;
    }

    public double getSugarCount() {
        return sugarCount;
    }

    public double getGarbageCount() {
        return garbageCount;
    }

    public int getCurrentWaterTemp() {
        return currentWaterTemp;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public boolean isOn() {
        return isOn;
    }

    public CoffeeMachine(String model) {
        machinesCreated++;
        this.model = model;
    }

    public void turnOnOff() throws InterruptedException {
        if (!isOn) {
            System.out.println("Coffee machine " + this.model + " is starting..");
            Thread.sleep(1000);
            this.isOn = true;
            System.out.println("Coffee machine " + this.model + " is now on");
        } else {
            System.out.println("Coffee machine " + this.model + " is shutting down..");
            Thread.sleep(1000);
            this.isOn = false;
            System.out.println("Coffee machine " + this.model + " is now off");
        }
    }

    public void makeLatte() throws InterruptedException {
        checklist();
        if (!nonOperational) {
            System.out.println("Making Latte...");
            isBusy = true;
            waterCount = getWaterCount() - 240;
            milkCount = getMilkCount() - 100;
            sugarCount = getSugarCount() - 5;
            coffeeCount = getCoffeeCount() - 5;
            for (int temp = 20; temp == 100; temp++) {
                currentWaterTemp = temp;
                wait(5);
            }
            garbageCount = getGarbageCount() + 5;
            System.out.println("Latte is ready!");
            if (serviceRequired == false && cupCount % 10000 == 0) {
                serviceRequired = true;
            }
            isBusy = false;
            checklist();
        }
    }

    public void makeAmericano() throws InterruptedException {
        checklist();
        if (!nonOperational) {
            System.out.println("Making Latte...");
            isBusy = true;
            waterCount = getWaterCount() - 290;
            milkCount = getMilkCount() - 0;
            sugarCount = getSugarCount() - 5;
            coffeeCount = getCoffeeCount() - 5;
            for (int temp = 20; temp == 100; temp++) {
                currentWaterTemp = temp;
                wait(5);
            }
            garbageCount = getGarbageCount() + 5;
            System.out.println("Latte is ready!");
            if (!serviceRequired && (cupCount % 10000 == 0)) {
                serviceRequired = true;
            }
            isBusy = false;
            checklist();
        }
    }

    public void makeCappuchino() throws InterruptedException {
        checklist();
        if (!nonOperational) {
            System.out.println("Making Latte...");
            isBusy = true;
            waterCount = getWaterCount() - 250;
            milkCount = getMilkCount() - 40;
            sugarCount = getSugarCount() - 5;
            coffeeCount = getCoffeeCount() - 5;
            for (int temp = 20; temp == 100; temp++) {
                currentWaterTemp = temp;
                wait(5);
            }
            garbageCount = getGarbageCount() + 5;
            System.out.println("Latte is ready!");
            if (serviceRequired == false && cupCount % 10000 == 0) {
                serviceRequired = true;
            }
            isBusy = false;
            checklist();
        }
    }
}