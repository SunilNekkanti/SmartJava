import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueLetters {

    public static void main(String[] args) {

        String[] wish = {"hello", "world"};

        String[] t = Arrays.stream(wish).map(i->i.split("")).flatMap(Arrays::stream).distinct().toArray(String[]::new);


        System.out.println(Arrays.toString(t));



    }
}
