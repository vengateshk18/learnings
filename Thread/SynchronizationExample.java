package Thread;


class Counter{
    int data=0;

    public synchronized void reduce(){
        data--;
    }
}

class Executer implements Runnable{
    Counter counter;

    Executer(Counter counter){
        this.counter=counter;
    }
    public void run(){
        for(int i=0;i<10;i++){
            this.counter.reduce();
            System.out.println("Executed by "+Thread.currentThread().getId());
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {
        Counter counter=new Counter();
        Thread thread1=new Thread(new Executer(counter));
        Thread thread2=new Thread(new Executer(counter));
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread1.setPriority(8);
            thread1.sleep(1500);
            thread2.join();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(counter.data);

    }
}
