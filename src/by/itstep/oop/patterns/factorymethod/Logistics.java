package by.itstep.oop.patterns.factorymethod;

public abstract class Logistics {
    abstract void planDelivery();
    abstract Transport createTransport();
}

class SeaLogistics extends Logistics {

    @Override
    void planDelivery() {
        System.out.println("Sea delivery plan");
    }

    @Override
    Transport createTransport() {
        return new Ship();
    }
}

class AirLogistics extends Logistics {

    @Override
    void planDelivery() {
        System.out.println("Air delivery plan");
    }

    @Override
    Transport createTransport() {
        return new Plane();
    }
}

class LandLogistics extends Logistics {

    @Override
    void planDelivery() {
        System.out.println("Land delivery plan");
    }

    @Override
    Transport createTransport() {
        return new Truck();
    }
}

class LogisticsProvider {
    public static Logistics chooseLogistics(String type){
        switch (type) {
            case "Air":
                return new AirLogistics();
            case "Sea":
                return new SeaLogistics();
            case "Road":
                return new LandLogistics();
            default:
                System.out.println("default");
                return new LandLogistics();
        }
    }
}

class LogisticsClient {
    public static void main(String[] args) {
        Logistics logistics = LogisticsProvider.chooseLogistics("Air");
        logistics.planDelivery();
        logistics.createTransport().deliver();
    }
}