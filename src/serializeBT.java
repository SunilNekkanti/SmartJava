

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class serializeBT{
  private static final int MARKER = Integer.MIN_VALUE;

  public static void serialize(Node node,
      ObjectOutputStream stream)
          throws java.io.IOException {
    if (node == null) {
      stream.writeInt(MARKER);
      return;
    }

    stream.writeInt(node.data);
    serialize(node.left, stream);
    serialize(node.right, stream);

  }

  public static Node deserialize(
      ObjectInputStream stream) throws java.io.IOException {
    int val = stream.readInt();


    if (val == MARKER) {
      return null;
    }

    Node node = new Node(val);
    node.left = deserialize(stream);
    node.right = deserialize(stream);
    return node;
  }
  public static void main(String[] args) {
  try{

    Node root = new Node(15);
    root.left = new Node(10);
    root.right = new Node(20);
    root.left.left = new Node(8);
    root.left.right = new Node(12);
    root.right.left = new Node(16);
    root.right.right = new Node(25);


    ByteArrayOutputStream baostream = new ByteArrayOutputStream();
    ObjectOutputStream stream = new ObjectOutputStream(baostream);
    serialize(root, stream);
    stream.close();

    ByteArrayInputStream baistream = new ByteArrayInputStream(
      baostream.toByteArray());
    ObjectInputStream  istream = new ObjectInputStream(baistream);

    Node root_deserialized = deserialize(istream);

    System.out.println("\nResult");


  }
  catch(Exception ex){
    ex.printStackTrace();
  }
}
}  