import java.util.HashSet;
import java.util.Set;

public class LongestSubStringAlt {

//Easy to understand
//Longest substring with non repeating characters
    public static void main(String[] args) {
        String mystr = "abkwepareqnmh";
        System.out.println(getLongestSubStringAlt(mystr));
    }

    private static int getLongestSubStringAlt(String mystr) {

        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        for(int leftPosition = 0, rightPosition = 0; rightPosition<mystr.length();rightPosition++){
            char rightPositionChar = mystr.charAt(rightPosition);
            char leftPositionChar = mystr.charAt(leftPosition);
            while(charSet.contains(rightPositionChar)){ //Sliding the leftPosition of the window forward
                charSet.remove(leftPositionChar);
                leftPosition++;
                leftPositionChar = mystr.charAt(leftPosition);
            }
            charSet.add(rightPositionChar);
            maxLength = Math.max(maxLength, rightPosition-leftPosition+1);
        }
        return maxLength;

    }
}
