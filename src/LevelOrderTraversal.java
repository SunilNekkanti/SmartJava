import java.util.ArrayDeque;
import java.util.Queue;
import java.util.*;
public class LevelOrderTraversal {

    public static void levelOrderTraversal(Node root)
    {
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();

        List<Node> ll = new ArrayList<Node>();
        queue.add(root);
        ll.add(root);

        // pointer to store current node
        Node curr;

        // run till queue is not empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their
            // non-empty left and right child to queue
            curr = queue.poll();


            //	System.out.print(curr.key + " ");

            if (curr.left != null) {
                queue.add(curr.left);
                ll.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
                ll.add(curr.right);
            }
        }

        System.out.println(ll);
    }

    // main function
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        levelOrderTraversal(root);
    }
}
