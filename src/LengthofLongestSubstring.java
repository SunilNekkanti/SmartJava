import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LengthofLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Deque<Character> deq = new ArrayDeque<>();
        // while string doesn't contain next letter, add next letter, track length
        for (char nextChar : s.toCharArray()) {
            while (deq.contains(nextChar)) {
                deq.removeFirst();
            }
            deq.addLast(nextChar);
            maxLength = Math.max(deq.size(), maxLength);
        }
        // if same letter found, iterate until letter is found and reduce string as it goes, track length
        // continue till finish
        System.out.println(maxLength);
        return maxLength;
    }

    public static void main(String[] args) {


        LengthofLongestSubstring lls = new LengthofLongestSubstring();

        lls.lengthOfLongestSubstring("sunil");

        if (lls.hashCode() == 223) {


        }






    }
}
