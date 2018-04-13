import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorOldWay {
  static List<Employee> employeeList = 
      Arrays.asList(new Employee("Tom Jones", 45), 
        new Employee("Harry Major", 35),
        new Employee("Harry Major", 25), 
        new Employee("Ethan Hardy", 65), 
        new Employee("Nancy Smith", 15),
        new Employee("Deborah Sprightly", 29));
 
  public static void main(String args[]) {

    Comparator<Employee> agewise = (Employee e1, Employee e2) -> {

      return e1.getAge().compareTo(e2.getAge());
    };

    Collections.sort(employeeList,  Comparator.comparing(Employee::getAge));
    employeeList.forEach(System.out::println);
  }
}