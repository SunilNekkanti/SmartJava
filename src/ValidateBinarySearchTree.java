import java.util.*;
import java.util.LinkedList;

public class ValidateBinarySearchTree {


    public static boolean helper(TreeNode node, Integer lowerBound, Integer upperBound) {
        System.out.println("Current Node "+ node + " lowerBound "+  lowerBound + " upperBound " + upperBound);
        if (node == null)
            return true;

        int currentNodeValue = node.data;

        if (lowerBound != null && currentNodeValue <= lowerBound)
            return false;
        if (upperBound != null && currentNodeValue >= upperBound)
            return false;

        if (! helper(node.right, currentNodeValue, upperBound))
            return false;
        if (! helper(node.left, lowerBound, currentNodeValue))
            return false;
        return true;
    }

    public static boolean isValidBSTRecursirve(TreeNode root) {
        return helper(root, null, null);
    }

    public static List<Integer> InorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode currentNode = null;
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            currentNode = stack.pop();
            list.add(currentNode.data);
            root = currentNode.right;
        }

        return list;


    }


    public static List<Integer> InorderTraversalRecursive(TreeNode root, List<Integer> list) {

        if(root==null)
            return list;
        InorderTraversalRecursive(root.left,list);
        list.add(root.data);
        InorderTraversalRecursive(root.right,list);

        return list;
    }


    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode previous = null;
        TreeNode currentNode = null;
        if(root==null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            currentNode = stack.pop();

            System.out.println("currentNode: "+currentNode);
            System.out.println("previousNode: "+previous);
            if(previous!=null && currentNode.data < previous.data)
                return false;
            previous = currentNode;
            root = currentNode.right;
        }

        return true;


    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> processingQueue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null)
            return wrapList;

        processingQueue.offer(root);
        while(!processingQueue.isEmpty()){
            int numberOfNodesAtThisLevel = processingQueue.size();
            List<Integer> nodeListSameLevel = new LinkedList<Integer>();
            for(int i=0; i<numberOfNodesAtThisLevel; i++) {
                if(processingQueue.peek().left != null)
                    processingQueue.offer(processingQueue.peek().left);
                if(processingQueue.peek().right != null)
                    processingQueue.offer(processingQueue.peek().right);
                nodeListSameLevel.add(processingQueue.poll().data);

            }
            wrapList.add(nodeListSameLevel);
        }
        return wrapList;
    }
    
    public static void main(String[] args) {


        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(8);
        tn5.left = tn3;
        tn3.left = tn2;
        tn3.right = tn4;
        tn2.left = tn1;
        tn5.right = tn7;
        tn7.left = tn6;
        tn7.right = tn8;

//        System.out.println(isValidBSTRecursirve(tn5));

        List<Integer> list = new ArrayList<Integer>();
        System.out.println(isValidBST(tn5));






        }
    }
