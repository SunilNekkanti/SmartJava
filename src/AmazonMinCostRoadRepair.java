

import java.util.*;

public class AmazonMinCostRoadRepair {

    // Disjoint-set union
    private int[] parents;

    class Road {
        final int cityA;
        final int cityB;
        final int cost;

        public Road(int cityA, int cityB, int cost) {
            this.cityA = cityA;
            this.cityB = cityB;
            this.cost = cost;
        }

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
    }

    int getMinimumCostToRepair(int numTotalAvailableCities,
                               int numTotalAvailableRoads,
                               List<List<Integer>> roadsAvailable,
                               int numRoadsToBeRepaired,
                               List<List<Integer>> costRoadsToBeRepaired)
    {
        parents = new int[numTotalAvailableCities+1];
        for(int i = 1; i < numTotalAvailableCities+1; i++) {
            parents[i] = i;
        }

        // minHeap based on cost
        PriorityQueue<Road> minHeap = roads(roadsAvailable, costRoadsToBeRepaired);
        int minCost = 0;

        // kruskal's algorithm
        while(!minHeap.isEmpty()) {
            Road road = minHeap.remove();

            int cityA = road.cityA;
            int cityB = road.cityB;
            int cost = road.cost;

            if (findParent(cityA) != findParent(cityB)) {
                connect(cityA, cityB);
                minCost += cost;
            }
        }

        return minCost;
    }

    private int findParent(int x){
        if(parents[x] == x){
            return x;
        }
        return findParent(parents[x]);
    }

    private void connect(int cityA, int cityB){
        int parentForCityA = findParent(cityA);
        int parentForCityB = findParent(cityB);
        parents[parentForCityA] = parentForCityB;
    }

    private PriorityQueue<Road> roads(List<List<Integer>> roadsAvailable, List<List<Integer>> costRoadsToBeRepaired) {
        Set<Road> roads = new HashSet<>();
        for (List<Integer> r : roadsAvailable) {
            Integer cityA = r.get(0);
            Integer cityB = r.get(1);
            Road road = new Road(cityA, cityB, 0);
            roads.add(road);
        }

        // Overwrite broken roads with the actual cost
        for(List<Integer> c: costRoadsToBeRepaired) {
            Integer cityA = c.get(0);
            Integer cityB = c.get(1);
            Integer cost = c.get(2);
            Road road = new Road(cityA, cityB, cost);

            if (roads.contains(road)) {
                roads.remove(road);
                roads.add(road);
            }
        }

        PriorityQueue<Road> minHeap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        minHeap.addAll(roads);

        return minHeap;
    }

    public static void main(String[] args) {
        List<List<Integer>> roadsAvailable = new ArrayList<>();
        roadsAvailable.add(Arrays.asList(1, 2));
        roadsAvailable.add(Arrays.asList(2, 3));
        roadsAvailable.add(Arrays.asList(3, 4));
        roadsAvailable.add(Arrays.asList(4, 5));
        roadsAvailable.add(Arrays.asList(1, 5));

        List<List<Integer>> costRoadsToBeRepaired = new ArrayList<>();
        costRoadsToBeRepaired.add(Arrays.asList(1, 2, 12));
        costRoadsToBeRepaired.add(Arrays.asList(3, 4, 30));
        costRoadsToBeRepaired.add(Arrays.asList(1, 5, 8));

        int numTotalAvailableCities = 5;
        int numTotalAvailableRoads = 5;
        int numRoadsToBeRepaired = 3;

        AmazonMinCostRoadRepair amazonMinCostRoadRepair = new AmazonMinCostRoadRepair();
        int minCost = amazonMinCostRoadRepair.getMinimumCostToRepair(
            numTotalAvailableCities,
            numTotalAvailableRoads,
            roadsAvailable,
            numRoadsToBeRepaired,
            costRoadsToBeRepaired
        );

        System.out.println(minCost); // 20

    }

}