import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DFSTraversal {
    public static void main(String[] args){
        DFSTraversal dfsTraversal = new DFSTraversal();
        PriorityQueue pq = new PriorityQueue();
        List<List<Integer>> list = new ArrayList<>();
        int [] row1 = {1,1,9,1};
        int [] row2 = {0,1,0,0};
        int [] row3 = {0,1,0,1};
        int [] row4 = {0,1,9,1};
        int [] row5 = {0,0,1,1};
        list.add(Arrays.stream(row1).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row2).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row3).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row4).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(row5).boxed().collect(Collectors.toList()));
        int distance = dfsTraversal.removeObstacle(5, 4, list);
        System.out.println(distance);
    }
     int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot){
        Stack<Coordinate> stack = new Stack<Coordinate>();
        boolean [][] visited = new boolean[numRows][numColumns];
         Stream.of(visited).map(Arrays::toString).forEach(System.out::println);
        Coordinate coordinate = new Coordinate(0,0, 0);
        stack.add(coordinate);
        visited[0][0] = true;
        while (!stack.isEmpty()){
            Coordinate current = stack.peek();
            stack.pop();
            int row = current.row;
            int column = current.column;
            int distance = current.distance;
            Stream.of(visited).map(Arrays::toString).forEach(System.out::println);
            System.out.println();
            if(lot.get(row).get(column)==0){
                continue;
            }
            if(lot.get(row).get(column)!=1){
                return distance;
            }
            if(row+1<numRows && !visited[row+1][column]){
                stack.add(new Coordinate(row+1, column, distance+1));
                visited[row+1][column] = true;
            }
            if(row-1>=0 && !visited[row-1][column]){
                stack.add(new Coordinate(row-1, column, distance+1));
                visited[row-1][column] = true;
            }
            if(column+1<numColumns && !visited[row][column+1]){
                stack.add(new Coordinate(row, column+1, distance+1));
                visited[row][column+1] = true;
            }
            if(column-1>=0 && !visited[row][column-1]){
                stack.add(new Coordinate(row, column-1, distance+1));
                visited[row][column-1] = true;
            }
        }
        return -1;
    }
    public class Coordinate{
        public int row;
        public int column;
        public int distance;
        public Coordinate(int row, int column, int distance){
            this.row = row;
            this.column = column;
            this.distance = distance;
        }

    }
}