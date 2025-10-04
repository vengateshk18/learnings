package Modifiers;

public final class BehavirolModifiers { // can't be inherited as it is final 

    public volatile int data=10; // Changes are immediately visible to threads
    int v=1; // default modifier
    public synchronized static void main(String[] args) { // synchronized so it is thread safe and static so no object needed.
        
    }
}


abstract class MyAbstractClass {}        // Abstract modifier


interface InnerBehavirolModifiers { // interface modifier
}