
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class RoadRepair {

    // Disjoint-set
    private int[] treeRoots;

    class Road {
        int cityA;
        int cityB;
        int cost;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Road road = (Road) o;
            return (cityA == road.cityA && cityB == road.cityB) || (cityA == road.cityB && cityB == road.cityA);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cityA, cityB);
        }

        public Road(int cityA, int cityB, int cost) {
            this.cityA = cityA;
            this.cityB = cityB;
            this.cost = cost;


        }
    }

    int getMinimumCostToRepair(int numTotalAvailableCities,
                               int numTotalAvailableRoads,
                               List<List<Integer>> roadsAvailable,
                               int numRoadsToBeRepaired,
                               List<List<Integer>> costRoadsToBeRepaired) {
        // city number is from 1 .. n
        treeRoots = new int[numTotalAvailableCities+1];
        for(int i = 1; i < numTotalAvailableCities+1; i++) {
            treeRoots[i] = i;
        }

        PriorityQueue<Road> minHeap = sortRoadsByCost(roadsAvailable, costRoadsToBeRepaired);
        int minCost = 0;

        // kruskal's algorithm
        while(!minHeap.isEmpty()) {
            Road road = minHeap.remove();

            if (findRoot(road.cityA) != findRoot(road.cityB)) {
                union(road.cityA, road.cityB);
                minCost += road.cost;
            }
        }

        return minCost;
    }

    private PriorityQueue<Road> sortRoadsByCost(List<List<Integer>> roadsAvailable, List<List<Integer>> costRoadsToBeRepaired) {
        Set<Road> allRoads = new HashSet<>();
        for(List<Integer> road : roadsAvailable) {
            allRoads.add(new Road(road.get(0), road.get(1), 0));
        }

        for(List<Integer> damaged : costRoadsToBeRepaired) {
            Road road = new Road(damaged.get(0), damaged.get(1), damaged.get(2));
            if (allRoads.contains(road)) {
                allRoads.remove(road);
                allRoads.add(road);
            }
        }

        PriorityQueue<Road> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        minHeap.addAll(allRoads);

        return minHeap;
    }

    private int findRoot(int node) {
        if (treeRoots[node] == node) return node;
        return findRoot(treeRoots[node]);
    }

    private void union(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);

        treeRoots[root1] = root2;
    }

//    public static int getMinimumCostToRepair(int numTotalAvailableCities,
//                                             int numTotalAvailableRoads,
//                                             List<List<Integer>> roadsAvaialble,
//                                             int numRoadsToBeRepaired,
//                                             List<List<Integer>> costRoadsToBeRepaired){
//
//        List<List<Integer>> goodRoads = new ArrayList<>();
//        List<List<Integer>> badRoads = new ArrayList<>();
//        for(List<Integer> road: costRoadsToBeRepaired){
//            badRoads.add(Arrays.asList(road.get(0), road.get(1)));
//        }
////        badRoads = costRoadsToBeRepaired.stream().map(road -> Arrays.asList(road.get(0), road.get(1))).collect(Collectors.toList());
//        goodRoads = roadsAvaialble.stream().filter(o -> !badRoads.contains(o)).map(ArrayList::new).collect(Collectors.toList());
//
//        Set<Integer> allCities = roadsAvaialble.stream().flatMap(x -> x.stream()).collect(Collectors.toSet());
//        List<Integer> cityList = new ArrayList(allCities);
//
//        for(List<Integer> gr : goodRoads){
//            gr.add(0);
//        }
//        costRoadsToBeRepaired.addAll(goodRoads);
//
//        findMinimumCostPath(cityList, numRoadsToBeRepaired, costRoadsToBeRepaired);
//
//
//
//      return 0;
//    }
//
//    private static void findMinimumCostPath(List<Integer> cityList,
//                                            int numRoadsToBeRepaired,
//                                            List<List<Integer>> costRoadsToBeRepaired) {
//
//        int city_1 = cityList.get(0);
//        cityList.remove(0);
//
//        for (int city_2: cityList){
//            //check if city_1 and city_2 exists as a pair in costRoadsToBeRepaired
//            for(List<Integer> route:costRoadsToBeRepaired){
//                System.out.println(route.get(0) + " to " + route.get(1) + ": costs "+ route.get(2) );
//
//                if((city_1 == route.get(0) && city_2 == route.get(1))||(city_1 == route.get(1) && city_2 == route.get(2)))
//                {
//                    System.out.println(route.get(0) + " to " + route.get(1) + ": costs "+ route.get(2) );
//
//                }
//                else {
//                    //unreachable nodes
//
//                }
//
//
////                System.out.println("Compute cost from "+ city_1 + " to " + city_2);
//
//
//            }
//
//
//
//        }
//
//
//    }

    public static void main(String[] args) {

    int numTotalAvailableCities=5, numTotalAvailableRoads=5, numRoadsToBeRepaired = 3;

        List<List<Integer>> roadsAvaialble = new ArrayList<>();
        roadsAvaialble.add(Arrays.asList(1,2));
        roadsAvaialble.add(Arrays.asList(2,3));
        roadsAvaialble.add(Arrays.asList(3,4));
        roadsAvaialble.add(Arrays.asList(4,5));
        roadsAvaialble.add(Arrays.asList(1,5));

        List<List<Integer>> costRoadsToBeRepaired = new ArrayList<>();
        costRoadsToBeRepaired.add(Arrays.asList(1,2,12));
        costRoadsToBeRepaired.add(Arrays.asList(3,4,30));
        costRoadsToBeRepaired.add(Arrays.asList(1,5,8));

        Deque<Integer> ll = new LinkedList<Integer>();

        ll.add(4);



        RoadRepair rr = new RoadRepair();
        int mincost = rr.getMinimumCostToRepair(numTotalAvailableCities, numTotalAvailableRoads,
                roadsAvaialble, numRoadsToBeRepaired, costRoadsToBeRepaired);
        System.out.println(mincost);







    }
}
