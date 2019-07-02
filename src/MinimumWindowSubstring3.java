import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring3 {


    public static void main(String[] args) {

        String wholeString = "brochevarevarura";
        String pattern = "hreau";
        System.out.println(getMinimumWindowSubString(wholeString,pattern));

    }

    private static String getMinimumWindowSubString(String fullString, String target) {
        //Sliding window approach

        if (fullString==null||target==null){
            return null;
        }

        if(fullString.length()==0 && target.length()==0){
            return "";
        }
        if (fullString.length()<target.length()){
            return"";
        }

        HashMap<Character, Integer> needToFindChars=new HashMap<Character, Integer>();
        HashMap<Character, Integer> alreadyFoundChars=new HashMap<Character, Integer>();

        target.chars().mapToObj(c->(char)c).forEach(c->needToFindChars.merge(c,1,Integer::sum));
        target.chars().mapToObj(c->(char)c).forEach(c->alreadyFoundChars.put(c,0));

        int minStart=-1;
        int minEnd=fullString.length();
        int windowStart=0;
        int charMatchedCount=0;
        for (int windowEnd=0; windowEnd<fullString.length(); windowEnd++){
            char currentWindowEndChar = fullString.charAt(windowEnd);
            char currentWindowStartChar = fullString.charAt(windowStart);

            // If this is a required character
            if (alreadyFoundChars.containsKey(currentWindowEndChar)){
                alreadyFoundChars.merge(currentWindowEndChar,1,Integer::sum); // Increment counter

                // If we reached the required count of this character or still in short of this character
                if (alreadyFoundChars.get(currentWindowEndChar)<=needToFindChars.get(currentWindowEndChar)){
                    charMatchedCount++;
                }

                //shrink window
                if (charMatchedCount==target.length()){
                    //checking if this is a useless character(that we need not find) or a character we found in excess
                    while (!needToFindChars.containsKey(currentWindowStartChar)
                            || alreadyFoundChars.get(currentWindowStartChar)>needToFindChars.get(currentWindowStartChar)){

                    // If this is a character in excess or useless character, decrement the already found chars for moving the window forward
                        if (needToFindChars.containsKey(currentWindowStartChar)) {
                            alreadyFoundChars.put(currentWindowStartChar, alreadyFoundChars.get(currentWindowStartChar)-1);
                        }
                        //moving the window forward
                        windowStart++;
                        currentWindowStartChar = fullString.charAt(windowStart);
                    } //while end
                    if (windowEnd-windowStart<minEnd-minStart){
                        minStart=windowStart;
                        minEnd=windowEnd;
                    }

                }
            }
        }
        if (minStart==-1){
            return "";
        }
        return fullString.substring(minStart, minEnd+1);

    }
}
