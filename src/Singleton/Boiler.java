package Singleton;

public final class Boiler {

    public enum StateBoiler { EMPTY, FULL }

    private static volatile Boiler instance;

    private StateBoiler stateBoiler = StateBoiler.EMPTY;  
    private boolean heaterOn = false;

    private Boiler() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static Boiler getInstance() {
        if (instance == null) {
            synchronized (Boiler.class) {
                if (instance == null) {
                    instance = new Boiler();
                }
            }
        }
        return instance;
    }

    
    public synchronized boolean fill() {
        if (stateBoiler == StateBoiler.EMPTY && !heaterOn) {
            stateBoiler = StateBoiler.FULL;
            System.out.println(" -> STATE: The boiler is filled with the chocolate and milk mixture.");
            return true;
        }
        System.out.println(" -> Cannot be filled: it must be empty and the heating element turned off.");
        return false;
    }

    // Solo si está lleno y la resistencia apagada
    public synchronized boolean startMixing() {
        if (stateBoiler == StateBoiler.FULL && !heaterOn) {
            stateBoiler = StateBoiler.FULL;
            System.out.println(" -> STATE: The boiler begins the mixing process.");
            return true;
        }
        System.out.println(" -> Cannot mix: must be full and with the heating element turned off.");
        return false;
    }

    public synchronized boolean drain() {
        if (stateBoiler != StateBoiler.EMPTY && heaterOn) {
            stateBoiler = StateBoiler.EMPTY;
            System.out.println(" -> STATE: The boiler drains.");
            return true;
        }
        System.out.println(" -> Cannot be emptied: it must not be empty, and the heating element must be on.");
        return false;
    }

    public synchronized void turnOnHeater() {
        heaterOn = true;
        System.out.println(" -> STATE: Heate ON");
    }

    public synchronized void turnOffHeater() {
        heaterOn = false;
        System.out.println(" -> STATE: Heate OFF");
    }

    public synchronized String getStatus() {
        return "State Boiler: " + stateBoiler + " and Heate: " + (heaterOn ? "ON" : "OFF");
    }
}