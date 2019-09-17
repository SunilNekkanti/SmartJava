import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStreamsDemo {


    public static void main(String[] args) {

/// Map merge demo

        List<String> team1 = new ArrayList<>();
        List<String> currentValue = new ArrayList<>();
        team1.addAll(Arrays.asList("sunil","mike","pudingi"));
        currentValue.addAll(Arrays.asList("pudingi"));
        Map<String,List<String>> map = new HashMap<>();
        map.put("team1", team1);
        map.merge("team1", currentValue, (existingValue, newValue)-> { existingValue.removeAll(newValue);
            return existingValue;});
        System.out.println(map);

        Map<String, Integer> prices = new HashMap<>();
        System.out.println("Prices map: " + prices);

        // Integer::sum(a,b) is perfect two-argument
        // function (BiFunction)
        prices.merge("fruits", 3, Integer::sum);
        prices.merge("fruits", 5, Integer::sum);
        System.out.println("Prices map: " + prices);

        // null removes mapping for the key:
        prices.merge("fruits", 7, (oldVal, newVal) -> {return null;});
        System.out.println("Prices map: " + prices);

        prices.put("veggies", null);
        System.out.println("Prices map: " + prices);
        // No need to handle initial null value:
        prices.merge("veggies", 42, Integer::sum);
        System.out.println("Prices map: " + prices);

//Collectors.toMap demo

        Map<String,String> somemap = new HashMap<>();
        somemap.put("zebra", "anbeaver");
        somemap.put("elephant", "elephant");
        somemap.put("antelope", "deer");
        LinkedHashMap<String, String> mysortedlinkedhashmap = somemap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap
                        (Map.Entry::getKey, //keymapper
                                Map.Entry::getValue , //valuemapper
                                // BinaryOperator merge function
                                (existingValue, newValue) -> existingValue ,//This merge function is only executed when there are key collisions.  The inputs to this function are the values which belong to the same key.
                                LinkedHashMap::new //mapSupplier - optional A function which provides a new instance of the desired implementation of the Map.
                        )
                );
        System.out.println(mysortedlinkedhashmap);

        String[] strArray = {"apple", "banana", "apricot", "orange", "pineapple",
                "apple", "baaapre"};


        Supplier<Stream<String>> streamSupplier = () -> Stream.of(strArray);

        Stream<String> s = streamSupplier.get();
        Map<Character, String> demoMap = s.collect(
                Collectors.toMap(streamEntry -> streamEntry.charAt(0), //keymapper
                        streamEntry -> streamEntry, //valuemapper
                        (existingValue, newValue) -> { //This merge function is only executed when there are key collisions. The inputs to this function are the values which belong to the same key.
                            System.out.println("existingValue is: "+existingValue);
                            System.out.println("newValue is: "+newValue);
                            System.out.println("Merged value is: "+existingValue.concat(" | "+ newValue));
                            return existingValue.concat(" | "+ newValue); //BinaryOperator merge function - optional to handle key collisions
                        }));

        System.out.println(demoMap);

//Collectors grouping by demo

      //  groupingBy(classifier)
        Map<Integer, List<String>> g1 = streamSupplier.get().collect(
                Collectors.groupingBy(String::length));
        System.out.println("groupingBy(classifier)");
        System.out.println(g1);
     //   groupingBy(classifier, downstream)
        Map<Integer, Long> g2 = streamSupplier.get().collect(
                Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("groupingBy(classifier, downstream)");
        System.out.println(g2);

    //    groupingBy(classifier, mapFactory, downstream)
        ConcurrentHashMap<Integer, Long> g3 = streamSupplier.get().collect(
                Collectors.groupingBy(String::length, //This function returned value is used as map key. Inputs to this function are stream elements.
                        ConcurrentHashMap::new,// mapFactory: This function creates the desired Map implementation.
                        Collectors.counting()) //downstream: This collector transforms the map values to type D.
        );
        System.out.println("groupingBy(classifier, mapFactory, downstream)");
        System.out.println(g3);

    }
}
