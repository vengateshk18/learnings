package Varargs;

class Compute{
    public static int sum(int...nums){ // Varags
        int total=0;
        for(int i:nums){
            total+=i;
        }
        return total;
    }

    public static int product(int...nums){ // Varags
        int total=1;
        for(int i:nums){
            total*=i;
        }
        return total;
    }
}
public class Sample {
    public static void main(String[] args) {
        System.out.println(Compute.sum(1,2,3));
        System.out.println(Compute.product(1,2));
        System.out.println(Compute.sum(1));
    }
}
