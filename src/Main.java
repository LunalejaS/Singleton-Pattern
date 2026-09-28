public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("*** CHOCOLATE BOILER CONTROL ***");

        Thread threadOne = new Thread(() -> {
            Boiler boiler = Boiler.getInstance();
            System.out.println(boiler.getStatus());
        });
        Thread threadTwo = new Thread(() -> {
            Boiler boiler = Boiler.getInstance();
            boiler.fill();
            System.out.println(boiler.getStatus());
        });
        Thread threadThree = new Thread(() -> {
            Boiler boiler = Boiler.getInstance();
            boiler.startMixing();
            System.out.println(boiler.getStatus());
        });
        Thread threadFour = new Thread(() -> {
            Boiler boiler = Boiler.getInstance();
            boiler.turnOnHeater();
            boiler.drain();
            System.out.println(boiler.getStatus());
        });

        threadOne.start(); threadOne.join();
        threadTwo.start(); threadTwo.join();
        threadThree.start(); threadThree.join();
        threadFour.start(); threadFour.join();
    }
}