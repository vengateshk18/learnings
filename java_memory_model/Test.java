package java_memory_model;


// Learning java Threads because it is a pre-requesite.

class One extends Thread{
    public void run(){
        for(int index=0;index<10;index++){
            System.out.println("Test One on: "+index);
        }
    }
}

class Two extends Thread{
    public void run(){
        for(int index=0;index<10;index++){
            System.out.println("Test Two on: "+index);
        }
    }
}


public class Test {
    public static void main(String[] args) {
        One obj1=new One();
        Two obj2=new Two();

        obj1.start();
        obj2.start();
    }

}



