import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {


    static String minimumWindowSubstring(String actual, String sub){

        char[] actualChars = actual.toCharArray();

        int windowSize = sub.length();

//       for (int i=0; i<actual.length();i++){
//
//           if(i+windowSize <= actual.length())
//           System.out.println(actual.substring(i, i+windowSize));
//
//
//       }

        System.out.println(checkStripHasChars(actual.substring(0,3), sub));


        return "";
    }

    static boolean checkStripHasChars(String strip, String charset){
//        Set<Character> cc = charset.chars()
//                .mapToObj(ch -> Character.valueOf((char) ch))
//                .collect(Collectors.toSet());
//
//        Set<Character> stripChars = strip.chars()
//                .mapToObj(ch -> Character.valueOf((char) ch))
//                .collect(Collectors.toSet());
//
//        stripChars.retainAll(cc);
//
//        if(stripChars.size()>0)
//            return true;
//        else
//            return false;

        char[] charsetArray = charset.toCharArray();
        char[] stripArray = strip.toCharArray();

        Object[] ff = strip.chars().filter( x -> charset.chars().anyMatch(y-> y== x) ).toArray(c -> new char[]);


        System.out.println(Arrays.toString(ff));




        return false;

    }


    public static void main(String[] args) {

        String actual = "bdcwerfgopomnzxcfbcazxssert";

        String sub = "abc";


        minimumWindowSubstring(actual,sub);

    }
}
