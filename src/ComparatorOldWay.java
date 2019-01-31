import java.util.*;
import java.util.stream.Stream;

public class ComparatorOldWay {
  static List<Employee> employeeList = 
      Arrays.asList(new Employee("Tom Jones", 45), 
        new Employee("Harry Major", 35),
        new Employee("Harry Major", 25), 
        new Employee("Ethan Hardy", 65), 
        new Employee("Nancy Smith", 15),
        new Employee("Deborah Sprightly", 29));
 
  public static void main(String args[]) {

    String f = "omuddupettavejigeluraani";
    char[] op = f.toCharArray();

      f.chars()
              .mapToObj(i-> (char) i)
              .forEach(System.out::println);

  }
}