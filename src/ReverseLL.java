

public class ReverseLL {

    private Node head;

    private static class Node{


        private int data;
        private Node next;

        public Node(int value){
            this.data = value;
        }
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public void addToTheLast(Node node) {

        if(head == null){
            head = node;
        }
        else {
            Node temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = node;
        }

    }

    public void printlist(Node n1){

        Node temp = n1;

        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void addToTheFirst(Node node) {

        if(head == null){
            head = node;
        }
        else {
            Node temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = node;
        }

    }

    public Node reverseOrder(){

        Node currentNode = head;
        Node previousNode = null;

        while(currentNode!=null)
        {
                Node nextNode = currentNode.getNext();

                currentNode.setNext(previousNode);
                previousNode = currentNode;
                currentNode = nextNode;


        }
        Node revListHead = previousNode;

        while(revListHead!=null){
            System.out.print(revListHead.data+" ");
            revListHead = revListHead.next;
        }

        return revListHead;
    }



    public static void main(String[] args) {

        ReverseLL originalList = new ReverseLL();

        Node head = new Node(0);

        originalList.addToTheLast(head);
        originalList.addToTheLast(new Node(1));
        originalList.addToTheLast(new Node(2));
        originalList.addToTheLast(new Node(3));
        originalList.addToTheLast(new Node(4));
        originalList.addToTheLast(new Node(5));
        originalList.addToTheLast(new Node(6));
        originalList.addToTheLast(new Node(7));
        originalList.addToTheLast(new Node(8));


     //   originalList.printlist(head);

        Node tail = originalList.reverseOrder();










    }


}
