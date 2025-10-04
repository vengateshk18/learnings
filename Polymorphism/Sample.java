package Polymorphism;

class D1{
    public static int getId(int a, int b){
        return 1;
    }

    public static double getId(double a, double b){ // overloading
        return 1.1;
    }
}

class D2 extends D1{
    public static int getId(int a, int b){
        return a+b;
    }
}

public class Sample {
    public static void main(String[] args) {
       D2 one=new D2();
       System.out.println(one.getId(1, 0));
    }
}
