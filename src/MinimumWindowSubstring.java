import java.util.*;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {


    static String minimumWindowSubstring(String actual, String sub){

        char[] actualChars = actual.toCharArray();

        List<String> results = new ArrayList<>();

        int windowSize = sub.length();

       for (int i=0; i<actual.length();i++){
           int minWindow = i+windowSize;

           while(minWindow <= actual.length()) {
               String strip = actual.substring(i, minWindow);

               if(checkStripHasSomeChars(strip, sub)){

                   if(checkStripHasAllChars(strip, sub)){
                       results.add(strip);
                       break;
                   }
                   else {
                    //expand window
                       minWindow++;
                       continue;
                   }
               }
               else{
                   //move to next window
                   break;
               }
           }


       }
        results.sort(Comparator.comparing(String::length));



        return results.get(0);
    }

    static boolean checkStripHasSomeChars(String strip, String charset){

        char[] charsetArray = charset.toCharArray();
        char[] stripArray = strip.toCharArray();

        char[] rs = strip.chars().filter( x -> charset.chars().anyMatch(y-> y==x) )
                                 .mapToObj(c -> new Character((char) c))
                                 .map(String::valueOf)
                                 .collect(Collectors.joining())
                                 .toCharArray();

        if(rs.length > 0)
            return true;
        else
            return false;

    }

    static boolean checkStripHasAllChars(String strip, String charset){
        Set<Character> neededChars = charset.chars()
                .mapToObj(ch -> Character.valueOf((char) ch))
                .collect(Collectors.toSet());

        Set<Character> actualChars = strip.chars()
                .mapToObj(ch -> Character.valueOf((char) ch))
                .collect(Collectors.toSet());

        return actualChars.containsAll(neededChars);

    }



    public static void main(String[] args) {

        String actual = "bdcwerfgopomnzxcfbcazxssert";

        String sub = "abc";

        System.out.println(minimumWindowSubstring(actual,sub));

    }
}
