package Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human{
    public int weight;

    Human(int weight){
        this.weight=weight;
    }

    public String toString(){
        return ""+this.weight;
    }

}

public class ComparatorClass {
    public static void main(String[] args) {
        List<Human> humans=new ArrayList<>();
        humans.add(new Human(10));
        humans.add(new Human(1));
        humans.add(new Human(15));
        humans.add(new Human(18));

        Comparator<Human> com=new Comparator<Human>(){

            public int compare(Human i,Human j){
                return i.weight>=j.weight?1:-1;
            }
        };

        Collections.sort(humans,com);
        System.out.println(humans);
    }
}
