package Generics;


class List<T>{
    private Object[] data;
    private int index;

    List(){
        this.data=new Object[100];
        this.index=0;
    }

    public T getData(int index){
        return (T) data[index];
    }

    public int size(){
        return this.index;
    }

    public void set(T da){
        data[this.index++]=da;
    }
}

public class Sample {
    public static void main(String[] args) {
        List<String> data=new List();

        data.set("data");
        System.out.println(data.getData(0)+" "+data.size());
    }
}
