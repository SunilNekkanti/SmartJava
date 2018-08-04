import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighestWordFrequency {

    static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude){

        literatureText = literatureText.replaceAll("[^a-zA-Z0-9\\s]","");
        String[] allwords = literatureText.split("\\s");
        List<String> filteredList = new ArrayList<String>();
        List<String> resultList = new ArrayList<String>();

        for(String word: allwords){
            if(!wordsToExclude.stream().anyMatch(word::equalsIgnoreCase))
                filteredList.add(word);
        }


        Map<String, Long> hm = filteredList.stream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));


        Long max = Collections.max(hm.values());

        for(Map.Entry<String, Long> me: hm.entrySet()){
            if(me.getValue().equals(max)){
                resultList.add(me.getKey());
            }

        }



        return resultList;
    }
    public static void main(String[] s){


        String phrase = new String();
        phrase="Jack and Jill, went up the hill and jack fell down ok na jam jam " +
                "ok na " +
                "mari";
        List<String> wordsToExclude = Arrays.asList("and", "the", "he", "to", "is", "Jack", "Jill");

        System.out.println(retrieveMostFrequentlyUsedWords(phrase, wordsToExclude));

//        String[] myw = phrase.split(" ");
//
//
//
//        Map<String, Integer> fm = new HashMap<String, Integer>();
//
//
//
//        for(String so : myw)
//        {
//            fm.put(so, Collections.frequency(Arrays.asList(myw), so));
//
//        }
//        System.out.println(Collections.max(fm.values()));
//        int y = Collections.max(fm.values());
//        System.out.println(fm.entrySet().stream()
//                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry<String, Integer>::getValue)))
//                .filter(e -> e.getValue()==y)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList()).toString());
//
//        System.out.println(fm
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue().equals(Collections.max(fm.values())))
//                .map(e -> e.getKey())
//                .collect(Collectors.toList()).toString());
//
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
//
}


}
