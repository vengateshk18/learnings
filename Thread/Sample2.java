package Thread;


class SimpleThread2 implements Runnable{
    public void run(){
        System.out.println("Simple thread runs process 1 "+Thread.currentThread().getId());
        System.out.println("Simple thread runs process 2 "+Thread.currentThread().getId());
        System.out.println("Simple thread runs process 3 "+Thread.currentThread().getId());
    }
}

public class Sample2 {
    public static void main(String[] args) {
        SimpleThread runnableThread=new SimpleThread();
        Thread obj=new Thread(runnableThread);
        obj.start();
    }
}
