import java.util.*;
import java.util.LinkedList;

class FlightTicketsOrder {
    private static final String INITIAL_AIRPORT = "JFK";

    public static List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0)
            return new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>(String::compareTo));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        System.out.println(graph);
        LinkedList<String> result = new LinkedList<>();
        topologicalSort(INITIAL_AIRPORT, graph, result);

        return result;
    }

    private static void
    topologicalSort(String vertex, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {

        PriorityQueue<String> queue = graph.get(vertex);

        while (queue != null && !queue.isEmpty()) {
            String nextAirPort = queue.poll();
            topologicalSort(nextAirPort, graph, result);

        }
        result.addFirst(vertex);
        //System.out.println(result);
    }

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("JFK","KUL");
        List<String> list2 = Arrays.asList("JFK","NRT");
        List<String> list3 = Arrays.asList("NRT","JFK");
      //  List<String> list4 = Arrays.asList("LHR", "SFO");
        List<List<String>> tickets = new ArrayList<List<String>>();
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
      //  tickets.add(list4);
        System.out.println(findItinerary(tickets));


    }
}