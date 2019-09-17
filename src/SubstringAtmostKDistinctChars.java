import java.util.LinkedHashMap;
import java.util.Map;

public class SubstringAtmostKDistinctChars {


    public static void main(String[] args) {

       String givenString = "ecebaaak";
       int k = 3;

       AtmostKDistinct(givenString, k);


    }

    private static int AtmostKDistinct(String givenString, int k) {

        int max = 0;

        LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<Character,Integer>(){

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > k;
            }
        };

        lhm.put(givenString.charAt(0),1);
        for(int start = 0, end = 0; end < givenString.length()-1;){

            end++;
            lhm.merge(givenString.charAt(end),1,Integer::sum);

            if(lhm.size()==k){


            }


        }


        System.out.println(lhm);
        return max;
    }
}
