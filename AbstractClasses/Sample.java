package AbstractClasses;

abstract class Vehicle{
    public boolean isEngineTurnedOn;
    public boolean isLightTurnedOn;

    abstract void turnOnEngine();
    abstract void stopEngine();
    public void turnOnLight(){
        isEngineTurnedOn=false;
        System.out.println("Light turned On");
    }
}

class Car extends Vehicle{
    public void turnOnEngine(){
        this.isEngineTurnedOn=true;
        System.out.println("Engine turned On");
    }

    public void stopEngine(){
        this.isEngineTurnedOn=false;
        System.out.println("Engine turned Off");
    }

}

public class Sample {
    public static void main(String[] args) {
        Vehicle car=new Car();
        car.turnOnEngine();
        car.stopEngine();
    }
}
