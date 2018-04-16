import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Dhammu {

    public static <K, V> Set<K> getKeys(Map<K, V> map, V value) {
        return map.keySet().stream()
                .filter(key -> value.equals(map.get(key)))
                .collect(Collectors.toSet());
    }

    public static void main(String[] s){
       String phrase = "Jack and jill went up the hill and Jack came rolling down";
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Stream<String> stream = Stream.of(phrase.toLowerCase().split("\\W+"));

//        Map<String, Long> wordFreq = stream
//                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        //System.out.println(wordFreq);


        String[] mystr = phrase.split(" ");
//        List<Integer> li = Stream.of(mystr).map(i -> Collections.frequency(Arrays.asList(mystr), i)).collect(Collectors.toList());
////        System.out.println(li);
//
//        System.out.println(g.getAsInt());
        for(String as: mystr)
        {
           hm.put(as, Collections.frequency(Arrays.asList(mystr), as));


        }






        //Extracting Max Value
        //1
        Integer max = hm.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();

        //2
        int max2 = Collections.max(hm.values());

        System.out.println(max2);

        //Extracting Max value from array
        OptionalInt g = Stream.of(mystr).mapToInt(i -> Collections.frequency(Arrays.asList(mystr), i)).max();

        //3
        Integer[] A = { 6, 8, 3, 5, 1, 9 };

        List<Integer> ints = Arrays.asList(A);

        System.out.println("Min element is " + Collections.min(ints));
        System.out.println("Max element is " + Collections.max(ints));

        //4
        int[] B = { 6, 8, 3, 5, 1, 9 };

        int max23 = IntStream.range(0, A.length)
                .map(i -> B[i])
                .max()
                .getAsInt();

        int min23 = IntStream.range(0, A.length)
                .map(i -> B[i])
                .min()
                .getAsInt();

        System.out.println("Min element is " + min23);
        System.out.println("Max element is " + max23);


        int[] C = { 6, 8, 3, 5, 1, 9 };

        Arrays.sort(C);

        System.out.println("Min element is " + C[0]);
        System.out.println("Max element is " + C[C.length - 1]);

        int[] F = { 6, 8, 3, 5, 1, 9 };

        int max98 = Arrays.stream(F)
                .max()
                .getAsInt();

        int min = Arrays.stream(F)
                .min()
                .getAsInt();

        System.out.println("Min element is " + min);
        System.out.println("Max element is " + max98);

        // primitive integer array
        int[] G = { 6, 8, 3, 5, 1, 9 };

        List<Integer> ints3 = Arrays.stream(G)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Min element is " + Collections.min(ints3));
        System.out.println("Max element is " + Collections.max(ints3));

        HashSet<Long> hashSet = new HashSet<Long>();
        hashSet.add(new Long("00000000005"));
        hashSet.add(new Long("00000000006"));
        hashSet.add(new Long("000000000010"));
        hashSet.add(new Long("00000000008"));
        hashSet.add(new Long("00000000007"));// using collections.max() method
        // the maximum of element is
        // find
        Object obj = Collections.max(hashSet);
        System.out.println("Maximum Element of Java HashSet is : " + obj);
        Object obj1 = Collections.min(hashSet);
        System.out.println("Minmum Element of Java HashSet is : " + obj1);


        List listOfMax = hm.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == Collections.max(hm.values()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(listOfMax);

        //Sorting a Map by Key
     //Ascending
        Map<String, String> country = new HashMap<>();

        country.put("India", "New Delhi");
        country.put("USA", "Washington D.C.");
        country.put("Japan", "Tokyo");
        country.put("China", "Beijing");

        // Sort Map by keys in Java 8
        country = country.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        System.out.println("Sorted Map by Keys :\n" + country);

        Map<String, String> country2 = new HashMap<>();

        country2.put("India", "New Delhi");
        country2.put("USA", "Washington D.C.");
        country2.put("Japan", "Tokyo");
        country2.put("China", "Beijing");

        // Sort Map by keys in Java 8
        Map<String, String> sortedMap = new LinkedHashMap<>();
        country2.entrySet()  					// Set<Entry<String, String>>
                .stream()   					// Stream<Entry<String, String>>
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        System.out.println("Sorted Map by Keys :\n" + sortedMap);
     //Descending

        //Sorting a Map by Value
        Map<String, String> country3 = new HashMap<>();

        country3.put("India", "New Delhi");
        country3.put("USA", "Washington D.C.");
        country3.put("Japan", "Tokyo");
        country3.put("China", "Beijing");

        // Sort Map by Values using Java 8 Streams API
        country3 = country3.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Sorted Map by Values : " + country3);

        Map<String, String> country4 = new HashMap<>();

        country4.put("India", "New Delhi");
        country4.put("USA", "Washington D.C.");
        country4.put("Japan", "Tokyo");
        country4.put("China", "Beijing");

        // Sort Map by Values using Java 8 Streams API
        Map<String, String> sortedMap5 = new LinkedHashMap<>();

        country4.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(entry ->
                        sortedMap5.put(entry.getKey(), entry.getValue()));

        System.out.println("Sorted Map by Values : " + country4);

        Map<String, String> colors = new HashMap<>();

        colors.put("RED", "#FF0000");
        colors.put("BLUE", "#0000FF");
        colors.put("GREEN", "#008000");
        colors.put("YELLOW", "#FFFF00");

        // Sort Map in Java 8 by reverse ordering of its keys
        colors = colors.entrySet()  		// Set<Entry<String, String>>
                .stream()   			// Stream<Entry<String, String>>
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("Sorted Map by Keys :\n" + colors);


// Program to retrieve all Map keys having given value in Java

        Map<String, Integer> hashMap = new HashMap();
        hashMap.put("A", 1);
        hashMap.put("B", 1);
        hashMap.put("C", 2);

        System.out.println(getKeys(hashMap, 1));
//Converting int array to Integer array
int[] arr = {1, 5, 6, 7, 8};
Integer[] boxedarr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

//Converting Integer array to int array
Integer[] arrayo = {3,4};
int[] intArray = Arrays.stream(arrayo).mapToInt(Integer::intValue).toArray();
        //Sorting a List

        //Sorting an array


        //Collector to a Map

        //Collector to a List

        //Collector to an array


        //Collector to a Set

        //Sorting Map based on keys and values


        //Implement BST using streams

// Implement Linked lists using streams

        //Iterate characters with streams

    }

}
