import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KPathSum {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(new Node(root, list, sum));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            TreeNode treeNode = node.treeNode;
            List<Integer> sol = node.list;
            sol.add(treeNode.val);
            if (treeNode.left == null && treeNode.right == null && treeNode.val == node.sum) {

                result.add(new ArrayList<Integer>(sol));
            } else {
                if (treeNode.right != null) {
                    stack.push(new Node(treeNode.right, new ArrayList<Integer>(sol), node.sum - treeNode.val));
                }
                if (treeNode.left != null) {
                    stack.push(new Node(treeNode.left, new ArrayList<Integer>(sol), node.sum - treeNode.val));
                }
            }

        }
        return result;


    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        // Function to create a new binary tree node having given key
        public TreeNode(int key) {
            val = key;
            left = right = null;
        }
    }

    class Node {
        TreeNode treeNode;
        List<Integer> list;
        int sum;

        Node(TreeNode treeNode, List<Integer> list, int sum) {
            this.treeNode = treeNode;
            this.list = list;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(-2);

        root.right.right.right = new TreeNode(2);

        KPathSum sol = new KPathSum();

        List<List<Integer>> result ;
        result = sol.pathSum(root, 7);

        for (List l : result)
        {
            System.out.println(l.toString());
        }

    }
}
