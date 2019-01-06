import java.util.*;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class TruckDelivery {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(1,1,1));
        list.add(Arrays.asList(0,0,1));
        list.add(Arrays.asList(1,9,1));
        minimumDistance(3,3, list);
    }

    static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area){

        Queue<String> unvisitedGrids = new LinkedList<String>();

        Set<String> visitedGrids = new HashSet<String>();

        Set<Pair<String, String>> parentChildSet = new HashSet<Pair<String, String>>();

        List<String> neighbours = new ArrayList<String>();

        String startNode = "00";

        String destNode = "";

        unvisitedGrids.add(startNode);
        boolean destNotFound = true;

        while(destNotFound && !unvisitedGrids.isEmpty()){

            String currentNode = unvisitedGrids.poll();
            visitedGrids.add(currentNode);

            if (getData(currentNode,area) == 9) {
                destNode = currentNode;
                destNotFound = false;
                break;
            }
            else{
                neighbours = getNeighbours(currentNode,numRows, numColumns);

                for(String node: neighbours){
                    if(!visitedGrids.contains(node) && getData(node,area)!=0) {
                        parentChildSet.add(new Pair(currentNode, node));
                        unvisitedGrids.add(node);
                    }
                }
            }
        }

        backTrackPath(destNode, startNode, parentChildSet, area);

        return -1;


    }

    public static String backTrackPath(String destNode, String startNode, Set<Pair<String, String>> parentChildSet, List<List<Integer>> area){

            boolean pathMapped = false;
            StringBuilder sb = new StringBuilder(destNode);
            StringBuilder datasb = new StringBuilder(String.valueOf(getData(destNode,area)));
            String parent = "";
            String endNode = destNode;

            while(!pathMapped) {
                parent = getParent(parentChildSet, endNode);
                sb.append("-> "+parent);
                datasb.append("-> "+String.valueOf(getData(parent,area)));
                if(parent.equals(startNode)){
                    pathMapped=true;
                }
                endNode = parent;

            }
        System.out.println(sb.toString());
        System.out.println(datasb.toString());
          return sb.toString();
    }

    private static String getParent(Set<Pair<String, String>> parentChildSet,String node){

        return parentChildSet.stream().filter(f -> f.getValue().equals(node)).map(Pair::getKey).findAny().get();
    }

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

        result.add(left);
        result.add(right);
        result.add(up);
        result.add(down);

        return result.stream().filter(isBlank()).collect(Collectors.toList());
    }


    public static Predicate<String> isBlank()
    {
        return data -> !data.equals("NA");
    }


    static int getData(String node,List<List<Integer>> area){
        String[] p = node.split("");
        int row = Integer.parseInt(p[0]);
        int column = Integer.parseInt(p[1]);

        int data = area.get(row).get(column);
        return data;

    }

}
