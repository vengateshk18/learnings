package java_memory_model;


// Java memory model 

class Writer extends Thread {
    private volatile boolean flag = false; 

    public void run() {
        System.out.println("Writer thread started.");
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {}
        flag = true;  // change the flag after some time
        System.out.println("Writer thread set flag to true.");
    }

    public boolean getFlag() {
        return flag;
    }
}

class Reader extends Thread {
    private Writer writer;

    public Reader(Writer writer) {
        this.writer = writer;
    }

    public void run() {
        System.out.println("Reader thread started.");
        // Loop until writer thread sets the flag to true
        while (!writer.getFlag()) {
            System.out.println(writer.getFlag());
        }
        System.out.println("Reader thread detected flag = true!");
    }
}

public class Main {
    public static void main(String[] args) {
        Writer writer = new Writer();
        Reader reader = new Reader(writer);

        reader.start();
        writer.start();
    }
}
