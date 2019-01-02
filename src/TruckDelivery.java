import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;

public class TruckDelivery {


    public static void main(String[] args) {

        Pair<String, String> ps = new Pair<>("emara", "okna");

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(1,1,0));
        list.add(Arrays.asList(1,1,1));
        list.add(Arrays.asList(1,9,0));
        //minimumDistance(3,3, list);
        getNeighbours("00", 3 ,3);
    }

//    static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area){
//
//        Queue<String> visitedGrids = new LinkedList<String>();
//        Map<String,Boolean> traversedNodes = new HashMap<String, Boolean>();
//        int currentRow = 0;
//        int currentColumn = 0;
//        String currentNode = getNode(currentRow, currentColumn);
//        visitedGrids.add(currentNode);
//        traversedNodes.put(currentNode, true);
//
//        while(!visitedGrids.isEmpty()){
//              String node = visitedGrids.poll();
//              List<String> neighbours = getNeighbours(node);
//              // add node to visited in the map
//              // add all neighbours to queue
//
//
//
//        }
//
//
//
//        return -1;
//    }

    private static List<String> getNeighbours(String node, int numRows, int numColumns) {
        List<String> result = new ArrayList<String>();
        String[] p = node.split("");
        int row = Integer.parseInt(p[0]);
        int column = Integer.parseInt(p[1]);

        String left, right, up, down;

        left = column-1 < 0 ? "NA" : String.valueOf(row)+String.valueOf(column-1);
        right = column+1 >= numColumns ? "NA" : String.valueOf(row)+String.valueOf(column+1);
        up = row-1 < 0 ? "NA" : String.valueOf(row-1)+String.valueOf(column);
        down = row+1 >= numRows? "NA" : String.valueOf(row+1)+String.valueOf(column);

        System.out.println(left);
        System.out.println(right);
        System.out.println(up);
        System.out.println(down);

        return result;
    }

    static int getDataForStringNode(String node,List<List<Integer>> area){

        return 0;

    }

    static String getNode(int row, int column){
        return  String.valueOf(row)+String.valueOf(column);
    }
}
