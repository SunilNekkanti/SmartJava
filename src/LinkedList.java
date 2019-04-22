public class LinkedList<S> {
 
	private Node head;
 
	private static class Node {
		private int value;
		private Node next;
 
		Node(int value) {
			this.value = value;
 
		}
	}
 
	public void addToTheLast(Node node) {
 
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
 
			temp.next = node;
		}
	}
 
 
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
 
	// This function will find middle element in linkedlist
	public Node findMiddleNode(Node head)
	{
		Node slowPointer, fastPointer; 
		slowPointer = fastPointer = head; 
 
		while(fastPointer !=null) { 
			fastPointer = fastPointer.next; 
			if(fastPointer != null && fastPointer.next != null) { 
				slowPointer = slowPointer.next; 
				fastPointer = fastPointer.next;

				//System.out.println("fastpointer "+fastPointer.value);
				//System.out.println("slowpointer "+ slowPointer.value);
			} 
		} 
 
		return slowPointer; 
 
	}
 
	public static void main(String[] args) {
		LinkedList<Node> list = new LinkedList<Node>();
		// Creating a linked list
		Node head=new Node(0);
		list.addToTheLast(head);
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(4));
        list.addToTheLast(new Node(5));
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(8));
 
		list.printList();
		// finding middle element
		Node middle= list.findMiddleNode(head);
		System.out.println("Middle node will be: "+ middle.value);
 
	}
 
}