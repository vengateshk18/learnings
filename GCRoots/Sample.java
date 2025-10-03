package GCRoots;

public class Sample {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String[] args){
        Node head=new Node(1);
        head.next=new Node(2);

        // Now head itself set to null which is also a gc root, not the objects are eligible for gc collection.
        head=null;


        System.gc();
    }
}
