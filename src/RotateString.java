import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RotateString {

    public static void main(String[] args) {

        String s = "abcdefghi";
        List<Character> lc = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Collections.rotate(lc, 4);
        System.out.println(lc.stream().map(e -> e.toString()).collect(Collectors.joining()));
    }
}
