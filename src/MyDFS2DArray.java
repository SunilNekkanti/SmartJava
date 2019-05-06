import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

import javafx.util.Pair;

public class MyDFS2DArray {

    public static void main(String[] args) {


        int[][] maze = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {9, 1, 1, 0, 1}
        };
        traverseDFS(maze);

    }

    private static void traverseDFS(int[][] maze) {

        int target = 9;

        Set<Pair<Integer, Integer>> visitedNodes = new LinkedHashSet<>();
        Stack<Pair<Integer, Integer>> dfsVisitStack = new Stack<>();


        int totalRows = maze.length;
        int totalColumns = maze[0].length;

        Pair<Integer, Integer> startPosition = new Pair<>(0, 0);
        dfsVisitStack.push(startPosition);
        visitedNodes.add(startPosition);

        while (!dfsVisitStack.empty()) {

            int row = dfsVisitStack.peek().getKey();
            int column = dfsVisitStack.peek().getValue();

            if (maze[row][column] == 9) {
                System.out.println(dfsVisitStack);
                System.out.println("target found at [" + row + "] [" + column + "]");
                break;
            }
            else {
                Pair<Integer, Integer> neighbour = getValidUnexploredNeighbour(row, column, totalRows, totalColumns, maze, visitedNodes);

                if (neighbour.getKey() != -1 && !visitedNodes.contains(neighbour)) {
                    visitedNodes.add(neighbour);
                    dfsVisitStack.push(neighbour);
                }
                else {
                    dfsVisitStack.pop();
                }

            }

        }
    }

    private static List<Pair<Integer, Integer>> getValidNeighbours(int row, int column, int totalRows, int totalColumns, int[][] maze) {


        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();

        if (row - 1 >= 0 && row - 1 < totalRows && maze[row - 1][column] != 0) //up
            neighbours.add(new Pair(row - 1, column));
        if (column - 1 >= 0 && column - 1 < totalColumns && maze[row][column - 1] != 0) // left
            neighbours.add(new Pair(row, column - 1));
        if (column + 1 >= 0 && column + 1 < totalColumns && maze[row][column + 1] != 0) // right
            neighbours.add(new Pair(row, column + 1));
        if (row + 1 >= 0 && row + 1 < totalRows && maze[row + 1][column] != 0) // down
            neighbours.add(new Pair(row + 1, column));

        return neighbours;
    }

    private static Pair<Integer, Integer> getValidUnexploredNeighbour(int row, int column, int totalRows, int totalColumns, int[][] maze, Set<Pair<Integer, Integer>> visitedNodes) {

        if (row - 1 >= 0 && row - 1 < totalRows && maze[row - 1][column] != 0 && !visitedNodes.contains(new Pair(row - 1, column)))
            return new Pair(row - 1, column);
        if (column - 1 >= 0 && column - 1 < totalColumns && maze[row][column - 1] != 0 && !visitedNodes.contains(new Pair(row, column - 1))) // left
            return new Pair(row, column - 1);
        if (column + 1 >= 0 && column + 1 < totalColumns && maze[row][column + 1] != 0 && !visitedNodes.contains(new Pair(row, column + 1))) // right
            return new Pair(row, column + 1);
        if (row + 1 >= 0 && row + 1 < totalRows && maze[row + 1][column] != 0 && !visitedNodes.contains(new Pair(row + 1, column))) // down
            return new Pair(row + 1, column);
        else
            return new Pair(-1, -1);
    }
}
