import java.util.*;

public class AmazonMinimumCostToRepairRoad {

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

        AmazonMinimumCostToRepairRoad amazonMinimumCostToRepairRoad = new AmazonMinimumCostToRepairRoad();
        int minCost = amazonMinimumCostToRepairRoad.getMinimumCostToRepair(
            numTotalAvailableCities,
            numTotalAvailableRoads,
            roadsAvailable,
            numRoadsToBeRepaired,
            costRoadsToBeRepaired
        );

        System.out.println(minCost); // 20
    }
}