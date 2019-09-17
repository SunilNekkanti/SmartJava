
import java.util.*;
import java.util.LinkedList;

class binarySearchTree {

	class Node{

		//Variables
		private  int data;
		private  Node leftChild;
		private  Node rightChild;

		//Constructor
		Node(int value){
			this.data=value;
			leftChild=null;
			rightChild=null;
		}

		//Getter-Setter
		public Node getLeftChild(){return leftChild;}
		public Node getRightChild(){return rightChild;}
		public int  getData(){return data;}
		public void setData(int value){this.data=value;}
		public void setLeftChild(Node left){this.leftChild=left;}
		public void setRightChild(Node right){this.rightChild=right;}
	}

	private Node root;

	public Node getRoot() {
		return root;
  }
    
	public void setRoot(Node root) {
		this.root = root;
	}

	//Iterative Function to insert a value in BST
	public boolean add(int value) {

		//If Tree is empty then insert Root with the given value inside Tree   
		if (isEmpty()) {
			root = new Node(value);
			return true;
		}

		//Starting from root
		Node currentNode = root;

		//Traversing the tree untill valid position to insert the value
		while (currentNode != null) {

			Node leftChild = currentNode.getLeftChild();
			Node rightChild = currentNode.getRightChild();

			//If the value to insert is less than root value then move to left subtree
			//else move to right subtree of root
			//and before moving check if the subtree is null, if it's then insert the value.
			if (currentNode.getData() > value) {
				if (leftChild == null) {
					leftChild = new Node(value);
					currentNode.setLeftChild(leftChild);
					return true;
				}
				currentNode = leftChild;
			} else {
				if (rightChild == null) {
					rightChild = new Node(value);
					currentNode.setRightChild(rightChild);
					return true;
				}
				currentNode = rightChild;
			} //end of else
		} //end of while
		return false;
	}

	//Function to check if Tree is empty or not  
	public boolean isEmpty() 
  {
		return root == null; //if root is null then it means Tree is empty
	}

	//Just for Testing purpose 
	public List<Integer> Inorder(Node root)
  {
	  List<Integer> list = new ArrayList<>();
	  if(root == null)
	  	return list;
	  Stack<Node> stack = new Stack<>();
	  while(root != null || !stack.empty()){
		  while(root != null){
			  stack.push(root);
			  root = root.getLeftChild();
		  }
		  root = stack.pop();
		  list.add(root.getData());
		  root = root.getRightChild();

	  }
	  return list;
  }

	public List<List<Integer>> levelOrder(Node root) {
		Queue<Node> queue =  new LinkedList<Node>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if(root == null) return wrapList;

		queue.offer(root);
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for(int i=0; i<levelNum; i++) {
				if(queue.peek().leftChild != null) queue.offer(queue.peek().leftChild);
				if(queue.peek().rightChild != null) queue.offer(queue.peek().rightChild);
				subList.add(queue.poll().getData());
			}
			wrapList.add(subList);
		}
		return wrapList;
	}



	public static void main(String args[]) 
  {
		binarySearchTree bsT = new binarySearchTree();

		bsT.add(6);
		bsT.add(4);
		bsT.add(9);
		bsT.add(5);
		bsT.add(2);
		bsT.add(8);
		bsT.add(12);
		bsT.add(10);
		bsT.add(14);

	  System.out.println(bsT.Inorder(bsT.getRoot()));
	}
}


