package ObjectWrappers;

public class Sample {
    public static void main(String[] args) {
        int i=0;
        Integer ii=1;
        Integer k=new Integer("1");
        k.toBinaryString(i);
        System.out.println(k.bitCount(i));

        float f=1.1f;
        Float ff=1.1f;
        Float fff=new Float("1.1");
        System.out.println(fff.toString());


        boolean b=false;
        Boolean bb=false;
        Boolean bbb=new Boolean("false");
        System.out.println(bbb.toString());

        long l=100;
        Long ll=(long) 100;
        Long lll=new Long("100");
        System.out.println(lll.toString(i));
    }
}
