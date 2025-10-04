package Interfaces;


interface Vehicle{ // Interface
    abstract void startEngine();
    abstract void stopEngine();
    abstract void turnOnLight();
}

class Bike implements Vehicle{
    private boolean isEngineTurnedOn;
    private boolean isLightOn;

    Bike(){
        this.isEngineTurnedOn=false;
        this.isLightOn=false;
    }

    public void startEngine(){
        isEngineTurnedOn=true;
    }

    public void stopEngine(){
        isEngineTurnedOn=false;
    }

    public void turnOnLight(){
        isLightOn=true;
    }
}

class Car implements Vehicle{
    private boolean isEngineTurnedOn;
    private boolean isLightOn;

    Car(){
        this.isEngineTurnedOn=false;
        this.isLightOn=false;
    }

    public void startEngine(){
        isEngineTurnedOn=true;
    }

    public void stopEngine(){
        isEngineTurnedOn=false;
    }

    public void turnOnLight(){
        isLightOn=true;
    }
}

public class Sample {
    public static void main(String[] args) {
        Vehicle vehicle=new Bike();
        vehicle.startEngine();

        Vehicle car=new Car();
        car.startEngine();
    }
}
