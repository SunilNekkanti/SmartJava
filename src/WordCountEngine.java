import java.util.Arrays;
import java.util.*;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCountEngine {
    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice !";

        String[][] output=wordCountEngine(document);

        Arrays.stream(output).forEach(arr->{
            System.out.println(arr[0]+"->"+arr[1]);
        });

   }

    static String[][] wordCountEngine(String doc) {

        String convertDoc = doc.replaceAll("[^a-zA-Z\\s]","").toLowerCase();

        String[] docarray = convertDoc.split("\\s");
        List<String> li = Arrays.asList(docarray);



        Map<String,Integer> wordFrequencyMap = li.stream().filter(x->!x.isEmpty()).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x->1)));

        Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return li.indexOf(o1.getKey()) - li.indexOf(o2.getKey());
                }
                else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        };

        LinkedHashMap<String,Integer> sortedMap = new LinkedHashMap<>();

        wordFrequencyMap.entrySet().stream().sorted(cmp).forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        String[][] result = new String[sortedMap.size()][2];
        int resultIndex = 0;
        for(Map.Entry<String,Integer> entry:sortedMap.entrySet()){
            result[resultIndex][0] = entry.getKey();
            result[resultIndex][1] = String.valueOf(entry.getValue());
            resultIndex++;
        }

        return result;
    }
}