import java.util.*;
import java.util.LinkedList;

public class MazeShortestPath {


    public static void main(String[] args) {
int[][] maze = {{0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,9}};
// 0 is path
// 1 is wall
        System.out.println(hasPath(maze));



    }

    public static boolean hasPath(int[][] maze) {
        int[] startPoint = {0,0,0};
        int maxRowSize = maze.length;
        int maxColumnSize = maze[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((firstIntegerArray,secondIntegerArray)->firstIntegerArray[0]-secondIntegerArray[0]);
        queue.offer(startPoint);
        pq.offer(startPoint);
        while (!queue.isEmpty()) {
            int[] currentPoint =  queue.poll();
            int currentValue = maze[currentPoint[0]][currentPoint[1]];
            if(currentValue==9){
                for(int[] t:pq){
                    System.out.println(Arrays.toString(t));
                }
                return true;
            }
            else{
                if(currentValue==1){
                    //this is a wall

                    continue;
                }
                else if(currentValue!=-1 ){
                    // mark it as visited
                    maze[currentPoint[0]][currentPoint[1]]=-1;

                    // add neighbours to the queue
                    queue.addAll(getValidUnexploredNeighbours(maze, currentPoint));
                    pq.addAll(getValidUnexploredNeighbours(maze, currentPoint));
                }
            }

        }



        return false;
    }


    private static ArrayList<int[]>  getValidUnexploredNeighbours(int[][] maze, int[] point) {
        int[][] moves = { {0, 1, 1}, {1, 0, 1}, {-1, 0, 1}, {0, -1, 1}};
        ArrayList<int[]> neighbours = new ArrayList<int[]>();
       // Stream.of(maze).map(Arrays::toString).forEach(System.out::println);
       // System.out.println();
        for(int[] move:moves){
            int[] neighbour = new int[3];
            Arrays.setAll(neighbour, index -> point[index] + move[index]);
            if(neighbour[0]<maze.length && neighbour[0]>=0
                    && neighbour[1]<maze[0].length && neighbour[1]>=0) {

                int neighbourValue = maze[neighbour[0]][neighbour[1]];
                if (neighbourValue == 0 || neighbourValue == 9 ) {
                    neighbours.add(neighbour);
                }
            }
        }

        return neighbours;
    }
}

