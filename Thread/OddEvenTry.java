package Thread;

// sample two



class Counter{
    int data=1;
    int finalvalue;

    Counter(int finaldata){
        this.finalvalue=finaldata;
    }

    public synchronized void printOdd(){
        while(data<finalvalue){
            if(data%2==1){
                System.out.println("Odd Value "+data);
                data+=1;
                notify();
            }
            else{
                try{
                    wait();
                }
                catch(Exception e){
                    System.out.println(e.toString());
                }
                printOdd();
            }
        }
    }
    public synchronized void printEven(){
        while(data<finalvalue){
            if(data%2==0){
                System.out.println("Even Value "+data);
                data+=1;
                notify();
            }
            else{
                try{
                    wait();
                }
                catch(Exception e){
                    System.out.println(e.toString());
                }
                printEven();
            }
        }
    }

}

class Tr1 extends Thread{
    Counter counter;

    Tr1(Counter counter){
        this.counter=counter;
    }

    public void run(){
        this.counter.printOdd();
    }
}

class Tr2 extends Thread{
    Counter counter;

    Tr2(Counter counter){
        this.counter=counter;
    }

    public void run(){
        this.counter.printEven();
    }
}

public class OddEvenTry {

    public static void main(String[] args) {
        Counter counter=new Counter(10);
        Tr1 t1=new Tr1(counter);
        Tr2 t2=new Tr2(counter);
        t1.start();
        t2.start();
    }
}
