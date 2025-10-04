package Enum;

enum Human{
    VENKY(1,2),JOHN(1,2),DAVID(3,4);

    public final int height;
    public final int weight;

    Human(int height, int weight){
        this.height=height;
        this.weight=weight;
    }

    public int getData(){
        return height;
    }
}

public class Sample2 {
    public static void main(String[] args) {
        System.out.println(Human.VENKY.getData());
    }
}
