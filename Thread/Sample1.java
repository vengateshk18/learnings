package Thread;

// In this example multi threading is done by extending the Thread class in normal class. 


class SimpleThread extends Thread{
    public void run(){
        System.out.println("Simple thread runs process 1 "+SimpleThread.currentThread().getId());
        System.out.println("Simple thread runs process 2 "+SimpleThread.currentThread().getId());
        System.out.println("Simple thread runs process 3 "+SimpleThread.currentThread().getId());
    }
}

public class Sample1 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            SimpleThread obj=new SimpleThread();
            obj.start();
        }
       // There is a difference between these two method calls;
        for(int i=0;i<5;i++){
            SimpleThread obj=new SimpleThread();
            obj.run();
        }

        
    }
}
