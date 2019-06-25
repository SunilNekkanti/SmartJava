import java.util.*;
import javafx.util.Pair;
import java.util.HashMap;

public class DistinctLongestSubString {

//Longest substring with non repeating characters
    public static void main(String[] args) {
        String mystr = "abkwepareqnmh";
        System.out.println(getLongestSubStringDistinctCharacters(mystr));
    }

    private static int getLongestSubStringDistinctCharacters(String givenString) {
        if (givenString.length()==0) return 0;

        // Stores location of every character in a map
        HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();

        // Stores maxLength and the substring
        List<Pair<Integer,String>> maxLengthList = new ArrayList<>();
        int maxLength=0;
        for (int rightPointer=0, leftPointer=0; rightPointer<givenString.length(); ++rightPointer) {
            char currentChar = givenString.charAt(rightPointer);
            if (charIndexMap.containsKey(currentChar)){
                leftPointer = Math.max(leftPointer,charIndexMap.get(currentChar)+1);
            }
            charIndexMap.put(currentChar,rightPointer);
            maxLength = Math.max(maxLength,rightPointer-leftPointer+1);

            if(givenString.substring(leftPointer,rightPointer+1).length()==maxLength) {
                maxLengthList.add(new Pair(maxLength,givenString.substring(leftPointer,rightPointer+1)));
            }
        }
        System.out.println(maxLengthList);
        return maxLength;

    }
}
