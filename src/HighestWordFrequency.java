import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighestWordFrequency {


    public static void main(String[] s){


        String phrase = new String();
        phrase="jack and jill, went up the hill and jack fell down" +
                "ok na" +
                "mari";

        String[] myw = phrase.split(" ");



        Map<String, Integer> fm = new HashMap<String, Integer>();



        for(String so : myw)
        {
            fm.put(so, Collections.frequency(Arrays.asList(myw), so));

        }
        System.out.println(Collections.max(fm.values()));
        int y = Collections.max(fm.values());
        System.out.println(fm.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry<String, Integer>::getValue)))
                .filter(e -> e.getValue()==y)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).toString());

        System.out.println(fm
                .entrySet()
                .stream()
                .filter(e -> e.getValue().equals(Collections.max(fm.values())))
                .map(e -> e.getKey())
                .collect(Collectors.toList()).toString());

//           Stream.of(myw).
//                          forEach(e -> {
//                              if(fm.containsKey(e)){
//                                  fm.put(e, fm.get(e)+1);
//                              }
//                              else{
//                                  fm.put(e, 1);
//                              }
//                          });
//           ArrayList<Integer> af = new ArrayList<Integer>(fm.values());
//              Collections.sort(af);
//              Collections.reverse(af);
//        System.out.println(af.toString());
    }


}
