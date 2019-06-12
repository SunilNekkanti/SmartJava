import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringCharFrequency {

    public static void main(String[] args) {

        String mystr = "aaabbbccccddeefffffff";
        Map<Character,Integer> map = new HashMap<>();

        Map<Character,Long> maplong = mystr.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character,Integer> mapint = mystr.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        Map<Character,Integer> mapint2 = mystr.chars().mapToObj(c -> (char)c).collect(Collectors.toMap(Function.identity(), c -> 1, Math::addExact));
        mystr.chars().mapToObj(c -> (char)c).forEach(e->map.put(e, map.getOrDefault(e, 0) + 1));
        System.out.println(map);

    }

}
