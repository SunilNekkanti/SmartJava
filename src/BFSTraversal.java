import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class BFSTraversal {
    public static void main(String[] args){
        BFSTraversal BFSTraversal = new BFSTraversal();
        List<List<Integer>> list = new ArrayList<>();
        int [] row1 = {1,1,1,1};
        int [] row2 = {0,1,1,1};
        int [] row3 = {0,1,0,1};
        int [] row4 = {1,1,9,1};
        int [] row5 = {0,0,1,1};
        list.add(Arrays.stream(row1).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row2).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row3).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row4).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row5).boxed().collect(Collectors.toList()));
        int distance = BFSTraversal.removeObstacle(5, 4, list);
        System.out.println(distance);
    }
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot){
        Queue<Coordinate> queue = new LinkedList<>();
        boolean [][] visited = new boolean[numRows][numColumns];
        Coordinate coordinate = new Coordinate(0,0, 0);
        queue.add(coordinate);
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Coordinate current = queue.peek();
            queue.remove();
            int row = current.row;
            int coloumn = current.coloumn;
            int distance = current.distance;
            if(lot.get(row).get(coloumn)==0){
                continue;
            }
            if(lot.get(row).get(coloumn)!=1){
                return distance;
            }
            if(row+1<numRows && !visited[row+1][coloumn]){
                queue.add(new Coordinate(row+1, coloumn, distance+1));
                visited[row+1][coloumn] = true;
            }
            if(row-1>=0 && !visited[row-1][coloumn]){
                queue.add(new Coordinate(row-1, coloumn, distance+1));
                visited[row-1][coloumn] = true;
            }
            if(coloumn+1<numColumns && !visited[row][coloumn+1]){
                queue.add(new Coordinate(row, coloumn+1, distance+1));
                visited[row][coloumn+1] = true;
            }
            if(coloumn-1>=0 && !visited[row][coloumn-1]){
                queue.add(new Coordinate(row, coloumn-1, distance+1));
                visited[row][coloumn-1] = true;
            }
        }
        return -1;
    }
    public class Coordinate{
        public int row;
        public int coloumn;
        public int distance;
        public Coordinate(int row, int coloumn, int distance){
            this.row = row;
            this.coloumn = coloumn;
            this.distance = distance;
        }

    }
}