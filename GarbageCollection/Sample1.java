package GarbageCollection;


class Demo{
    String data;

    Demo(String data){
        this.data=data;
    }
}

public class Sample1 {
    public static void main(String[] args) {
        Demo data=new Demo("data");
        data=null;
        System.gc();
        
    }
}
