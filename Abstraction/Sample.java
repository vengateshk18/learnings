package Abstraction;


abstract class shape{
    double radius;
    abstract double getArea();
}

class circle extends shape{
    circle(double radius ){
        this.radius=radius;
    }

    public double getArea(){
        return  Math.PI * radius * radius;
    }
}

public class Sample {
    public static void main(String[] args) {
        shape d=new circle(10.1);
        System.out.println(d.getArea()); 
    }
}
