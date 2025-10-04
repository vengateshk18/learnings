package Interfaces;



interface Printer{
    abstract String print();
}

class ThreeDPrinter implements Printer{
    @Override
    public String print() {
        return "Print 3D";
    }
}

class LaserPrinter implements Printer{
    @Override
    public String print() {
        return "Print laser";
    }
}

class Binder{
    Printer printer;

    Binder(Printer printer){
        this.printer=printer;
    }

    public void bind(){
        System.out.println(printer.print());
        System.out.println("Binded");
    }
}



public class DeCoupling {
    public static void main(String[] args) {
        Printer printer=new ThreeDPrinter();
        Printer laser=new LaserPrinter();
        Binder bidn=new Binder(printer);
        bidn.bind();
        Binder bidn1=new Binder(laser);
        bidn1.bind();
    }
}
