import java.util.*;
import java.util.stream.Collectors;

public class SteakHouses {

    public static void main(String[] args) {

        int totalSteakHouses = 3;
        int numSteakHouses = 2;

        List<List<Integer>> allLocations = new ArrayList<>();
        allLocations.add(new ArrayList<>(Arrays.asList(1, 2)));
        allLocations.add(new ArrayList<>(Arrays.asList(3, 4)));
        allLocations.add(new ArrayList<>(Arrays.asList(1, -1)));
        allLocations.add(new ArrayList<>(Arrays.asList(3, 3)));
        nearestXSteakHouses(totalSteakHouses, allLocations, numSteakHouses);

    }


    public static List<List<Integer>> nearestXSteakHouses(int totalSteakHouses,
                                                          List<List<Integer>> allLocations,
                                                          int numSteakHouses) {

        List<List<Integer>> locDist = new ArrayList<>();
        List<List<Integer>> nearestLocs = new ArrayList<>();
        for (List<Integer> l : allLocations) {
            int distance = (int) Math.pow(l.get(0), 2) + (int) Math.pow(l.get(1), 2);
            locDist.add(new ArrayList<Integer>(Arrays.asList(l.get(0), l.get(1), distance)));
        }

        Comparator<List<Integer>> revOrder = (e1, e2) -> e2.get(2).compareTo(e1.get(2));
        //Comparator<List<Integer>> naturalOrder = Comparator.comparing(List::indexOf(2));
        Collections.sort(locDist, revOrder);

        nearestLocs = locDist.stream().
                limit(numSteakHouses).
                map(e -> new ArrayList<>(Arrays.asList(e.get(0), e.get(1)))).
                collect(Collectors.toList());

        System.out.println(nearestLocs);

        return nearestLocs;


    }
}
