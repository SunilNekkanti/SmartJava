import java.util.HashMap;

public class Random {


    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("a",1);
        hm.put("b",2);
        hm.put("c",3);
        hm.put("d",4);

        hm.replace("c", 10);
        System.out.println(hm);

        System.out.println(hm.computeIfPresent("c", (x,y) -> Integer.valueOf(x+y)));



    }
}
