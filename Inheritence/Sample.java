package Inheritence;


interface  v1{
    abstract void print();
} 

interface v2{    
    abstract void print1();
}

abstract class v3{
    int k=10;

    abstract void print2();
}

class data extends v3 implements v1,v2{ // multiple inheritence and hybrid inheritence
    public void print(){
        System.out.println("a");
    }

    public void print1(){
        System.out.println("daa");
    }

    public void print2() {
        System.out.println("aa");
    }
}

class d1 extends data{ // hierarchical inheritence
    public int getData(){
        return 1;
    }
}

class d2 extends data{ // multi inheritence.
    public int getData(){
        return 1;
    }
}

public class Sample {
    public static void main(String[] args) {
        d1 obj=new d1();
        obj.print1();
    }
}
