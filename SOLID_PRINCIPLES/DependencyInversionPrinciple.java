package SOLID_PRINCIPLES;

interface Printer{
    public void print();
}

class ThreeDPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("Printing...");
    }

}

class LaserPrinter implements Printer{

    @Override
    public void print() {
        System.out.println("Printing...");
    }

}

class Computer{
    Printer printer;

    Computer(Printer printer){
        this.printer=printer;
    }

    public void print(){
        printer.print();
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Computer com=new Computer(new LaserPrinter());
        com.print();
    }
}
