package Modifiers;

public class AccessModifiers { // public is a access modifier where it can be accessed anywhere.

    public int data=10; // Public Access for variable
    public static void main(String args[]){ // Public Access for method.
        System.out.println("null");
    }
}


class Data1{
    private int value=10; // private modifier for varibale which means only accessible inside the class
    private int getData(){ // private modifer for method which means only accessible inside the class
        return value;
    }
}

class Data2{
    protected int value=10; // protected modifier for viariable which means only accessible inside the class and its subclass

    protected int getData(){ // protected modifer for method which means only accessible inside the class and its subclass
        return value;
    }
}

class MyClass {
    private int a;           // Accessible only inside this class
    protected int b;         // Accessible in this class and subclasses
    public int c;            // Accessible everywhere
    int d;                   // Default - accessible within the same package
}


