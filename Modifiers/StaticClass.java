package Modifiers;

public class StaticClass {
    public static void main(String[] args) {
        Outer.StaticInner inner=new Outer.StaticInner();
    }
}


class Outer {
    int x = 10;
    static int y = 20;

    static class StaticInner {
        void display() {
            System.out.println("y = " + y);  
        }
    }

    static class StaticInner2{
        void display(){
            System.out.println(y);
        }
    }
}
