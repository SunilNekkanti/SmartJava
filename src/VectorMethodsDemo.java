import java.util.*;

public class VectorMethodsDemo
{

  public static void main(String args[]){

  Vector<Integer> vectorObject = new Vector<Integer>(4);

  vectorObject.add(3);

  vectorObject.add(5);

  vectorObject.add(4);

  vectorObject.add(1);

  Iterator fg = vectorObject.iterator();

  while(fg.hasNext()){
      System.out.println(fg.next());
  }
  vectorObject.addElement(6);
  System.out.println("Values in Vecor object" +vectorObject);

  vectorObject.addElement(2);

  System.out.println("Values in Vecor object" +vectorObject);

    System.out.println(vectorObject.remove((Integer) 2));

      System.out.println(vectorObject);

  }

}