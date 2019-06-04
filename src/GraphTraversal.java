import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import javafx.util.Pair;



public class GraphTraversal {
    static Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    static Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    //Does a DFS and detects cycle
    static Set<String> detectCycleinGraph(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<Pair<String, String>> stack = new Stack<Pair<String, String>>(); //vertex, parent
        stack.push(new Pair(root, root));
        while (!stack.isEmpty()) {
            Pair<String,String> vertex = stack.pop();
            String currentVertex =  vertex.getKey();
            String parentVertex =  vertex.getValue();
            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);
                for (Graph.Vertex v : graph.getAdjVertices(currentVertex)) {
                    stack.push(new Pair(v.label,currentVertex));
// here v is one of the adjacent vertices
// if v is in the visited set and v is not the parentVertex then cycle is detected
                    if(visited.contains(v.label) && !v.label.equals(parentVertex)){
                        System.out.println("Cycle detected");
                    }
                }

            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        depthFirstTraversal(graph,"Bob");



    }
}