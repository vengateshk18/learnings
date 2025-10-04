package AnonymousClass;
import java.util.*;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> data=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        data.sort((a,b) -> b.compareTo(a));
        data.removeIf(n-> n%2==0);
        data.replaceAll(n-> n*n);
        System.out.println(data);
    }
}
