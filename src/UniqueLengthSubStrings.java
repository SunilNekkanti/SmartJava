import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueLengthSubStrings {


    public static void main(String[] args) {

        String mystr = "awagkljihgpoqraestnu";

        System.out.println(substringsWithKDistinctCharacters(mystr, 4));

    }

    public static List<String> substringsWithKDistinctCharacters(String input, int k) {

        List<String> allSubStringList = generateSubStrings(input, k);

        List<String> resultList = new ArrayList<String>();

        HashSet<String> sortedsubstrings = new HashSet<String>();

        for (String e : allSubStringList) {
            if (hasUniqueCharacters(e)) {

                if (!sortedsubstrings.contains(sortStringCharacters(e))) {
                    sortedsubstrings.add(sortStringCharacters(e));
                    resultList.add(e);
                }
            }
        }

        return resultList;
    }

    private static boolean hasUniqueCharacters(String input) {


        if (input.length() == input.chars().mapToObj(i -> (char) i).map(Character::toLowerCase).distinct().count()) {
            return true;
        } else {
            return false;
        }

    }

    private static String sortStringCharacters(String input) {
        return Stream.of(input.split(""))
                .sorted()
                .collect(Collectors.joining());


    }

    private static List<String> generateSubStrings(String input, int k) {
        List<String> substringList = new ArrayList<String>();

        for (int i = 0; i < input.length(); i++) {

            if (i + k <= input.length())
                substringList.add(input.substring(i, i + k));
        }

        return substringList;
    }
}



