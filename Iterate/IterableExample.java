package Iterate;

import java.util.*;

class Human1 {
    public int weight;

    Human1(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "" + this.weight;
    }
}

class HumanGroup implements Iterable<Human1> {
    private List<Human1> humans = new ArrayList<>();

    public void add(Human1 h) {
        humans.add(h);
    }

    @Override
    public Iterator<Human1> iterator() {
        return humans.iterator();  
    }
}

public class IterableExample {
    public static void main(String[] args) {
        HumanGroup group = new HumanGroup();
        group.add(new Human1(10));
        group.add(new Human1(5));
        group.add(new Human1(20));

        // Using for-each loop (requires Iterable)
        for (Human1 h : group) {
            System.out.println("Weight: " + h.weight);
        }

        // Or manually using iterator
        Iterator<Human1> it = group.iterator();
        while (it.hasNext()) {
            System.out.println("Iterated Weight: " + it.next().weight);
        }
    }
}
