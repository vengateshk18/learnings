package Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human1 implements Comparable<Human1>{
    public int weight;

    Human1(int weight){
        this.weight=weight;
    }

    public String toString(){
        return ""+this.weight;
    }

    public int compareTo(Human that){
        return this.weight>that.weight?1:-1;
    }

    @Override
    public int compareTo(Human1 o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}

public class ComparableClass {
    public static void main(String[] args) {
        List<Human1> humans=new ArrayList<>();
        humans.add(new Human1(10));
        humans.add(new Human1(1));
        humans.add(new Human1(15));
        humans.add(new Human1(18));

        Collections.sort(humans);
        System.out.println(humans);
    }
}
