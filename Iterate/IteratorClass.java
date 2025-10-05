package Iterate;

import java.util.*;

class Human1 implements Comparable<Human1> {
    public int weight;

    Human1(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "" + this.weight;
    }

    @Override
    public int compareTo(Human1 that) {
        return Integer.compare(this.weight, that.weight);
    }
}

public class IteratorClass {
    public static void main(String[] args) {
        List<Human1> humans = new ArrayList<>();
        humans.add(new Human1(10));
        humans.add(new Human1(1));
        humans.add(new Human1(15));
        humans.add(new Human1(18));

        // Sorting
        Collections.sort(humans);

        // Using Iterator
        Iterator<Human1> iterator = humans.iterator();
        while (iterator.hasNext()) {
            Human1 h = iterator.next();
            System.out.println("Weight: " + h.weight);
        }
    }
}
