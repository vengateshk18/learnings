package Thread;


class Counter{
    int data=0;

    public synchronized void increase(){
        data+=1;
    }
}

class NumberThread implements Runnable{

    Counter counter;

    NumberThread(Counter counter){
        this.counter=counter;
    }

    public void run(){
        for(int i=0;i<5;i++){
            counter.increase();
            System.out.println("Increase my Thread "+Thread.currentThread().getId()+" Value "+counter.data);
        }
    }
}

public class OddEvenThread {
    public static void main(String[] args) {
        Counter counter=new Counter();
        Thread thread1=new Thread(new NumberThread(counter));
        Thread thread2=new Thread(new NumberThread(counter));
        thread1.start();
        thread2.start();
    }
}
