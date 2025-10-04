package Thread;

// sample one 1;
class Counter{
    int data;
    Counter(int data){
        this.data=data;
    }

    public synchronized void checkOdd(){
        if(data%2==1){
            System.out.println("Data is Odd....");
            data+=1;
            notify();
        }
        else{
            try{
                System.out.println("data is even so waiting");
                wait();
            }
            catch(Exception e){ }
            checkOdd();
        }
    } 

    public synchronized void load(){
        this.data=1;
        notify();
    }

    public synchronized void checkEven(){
        if(data%2==0){
            System.out.println("Data is Even....");
            data+=1;
            notify();
        }
        else{
            try{
                System.out.println("data is odd so waiting");
                wait();
            }
            catch(Exception e){ }
            checkEven();
        }
    } 
}

class T1 extends Thread{
    Counter counter;

    T1(Counter counter){
        this.counter=counter;
    }
    public void run(){
        counter.checkOdd();
    }
}
class T2 extends Thread{
    Counter counter;

    T2(Counter counter){
        this.counter=counter;
    }
    public void run(){
        counter.checkEven();
    }
}
public class WaitInThread {
    public static void main(String[] args) {
        Counter counter=new Counter(1);
        T1 obj1=new T1(counter);
        T2 obj2=new T2(counter);

        obj1.start();
        obj2.start();
    }
}
