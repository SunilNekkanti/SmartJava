import java.util.*;

class MinWindowSub2 {
    public static String findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
        Map<Character, Integer> targetCharFrequency = new HashMap<>();
        pattern.chars().mapToObj(c->(char)c).forEach(c->targetCharFrequency.merge(c,1,Integer::sum));


        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            //If this is a required character
            if (targetCharFrequency.containsKey(rightChar)) {
                targetCharFrequency.merge(rightChar,-1,Integer::sum);
                // targetCharFrequency contains whatever char count is needed - whatever char count is found
                if (targetCharFrequency.get(rightChar) >= 0) // count every matching of a character
                    matched++;
            }

            // shrink the window if we can, finish as soon as we remove a matched character

            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                //If this is a required character
                if (targetCharFrequency.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when the last occurrence of a matched character is going out of the window

                    // Checking if this is a critical character and removal of it from the window will result in a loss
                    //If it is resulting in a loss then decrement matched count so that this loop will be exited
                    // and also restore the targetFrequency to its original state
                    if (targetCharFrequency.get(leftChar) == 0)
                        matched--;
                    targetCharFrequency.merge(leftChar,1,Integer::sum);
                }
            }
        }

        // minLength is originally initialized to actual string length + 1

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(MinWindowSub2.findPermutation("aa", "cd"));
//        System.out.println(MinWindowSub2.findPermutation("abdabca", "abc"));
//        System.out.println(MinWindowSub2.findPermutation("adcad", "abc"));
    }
}
