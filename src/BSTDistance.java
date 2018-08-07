import java.util.*;

public class BSTDistance
{ 
    public static void main(String args[]) {
            int[] input = new int[]{5,6,3,1,2,4};
            int result = bstDistance(input, 6, 2, 4);
            System.out.println(result);
    }
    
	public static int bstDistance(int[] values, int n, int node1, int node2)
	{
        Node tree = createBST(values);
        List<Node> pathToNode1 = getPath(tree, node1);
        List<Node> pathToNode2 = getPath(tree, node2);
        return getDiffDistance(pathToNode1, pathToNode2);
	}

    private static int getDiffDistance(List<Node> path1, List<Node> path2) {
        int count = 0;
        int closestParent = 0;

        if (path1 == null || path2 == null) {
            return -1;
        }
        
        for (int i = 0; i < path1.size(); i++) {
            if (i < path2.size()) {
                if (path1.get(i) == path2.get(i)) {
                    closestParent = i; // Same parents
                } else {
                    count++;  // Different parents so add to counter
                }
            } else {
                count++;  // Count deeper path
            }
        }

        for (int i = closestParent; i < path2.size(); i++) {
            count++;  // Add any deeper in second path
        }

        return count - 1;
    }
	
	private static Node createBST(int[] values) {
	    Node root = new Node(values[0]); // Place root node
	    for (int i = 1; i < values.length; i++) {
	        Node current = root;
	        while(current != null) {
    	        if (values[i] < current.data) {
    	            // Send to left
    	            if (current.left == null) {
    	                Node insertMe = new Node(values[i]);
    	                current.left = insertMe;
                        break;
    	            }
    	            current = current.left;
    	        } else {
    	            // Send to right
    	            if (current.right == null) {
    	                Node insertMe = new Node(values[i]);
    	                current.right = insertMe;
                        break;
    	            }
    	            current = current.right;
    	        }    
	        }
	    }   
        return root;
	}

    private static List<Node> getPath(Node root, int value) {
        Node current = root;
        List<Node> path = new ArrayList<Node>();
        while(current != null) {
            path.add(current);
            if (value < current.data) {
                current = current.left;
            } 
            else if (value > current.data){
                current = current.right;
            } else {
                break;
            } 
        }
        if (current == null) {
            return null;
        }
        return path;
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
