import java.util.Map;
import java.util.PriorityQueue;

public class hashmapplayground {


    public static void main(String[] args) {

        Map emptymap = Map.of(1, "one", "t", "dfdf");

        System.out.println(emptymap);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        System.out.println(pq);

    }
}
