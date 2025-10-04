package AnonymousClass;


interface Data{
    abstract String getData();
}


public class Sample {
    public static void main(String[] args) {
        Data d=new Data() {
            public String getData(){
                return "data";
            }
            

        };

        System.out.println(d.getData());
    }
}
