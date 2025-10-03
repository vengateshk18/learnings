package JVM;

public class Test{
    public static void main(String args[]){
        Sample obj1=new Sample(10); // stored in heap memory
        System.out.println(obj1.getData());
    }
}


class Sample{ // method area: class information will be stored like class name, access specifiers, super class name default(java.lang.Object).
    public static int data=10; // method area: static variable information will be stored like access specifier, class name, data type, variable name, and value.
    public int value;// method area: variable data will be stored along side the access specifier, varibale name.
    public final String name="data"; // method area: this will be stored in runtime constant pool

    Sample(int value){ // method area: constructor informatioin will be stored like name, access specifier, and arguments.
        this.value=value; 
    }

    public int getData(){ // method area: method information will be stored like access specifier, signature(input value to method, output value to the method), method name and byte code instructions that implements method.
        return this.value;
    }

    public int getRecursiveData(int data){
        if(data<=1){
            return 1;
        }
        return data+this.getRecursiveData(data-1);  // method area: stored in stack memory
    }
}