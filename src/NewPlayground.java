import java.util.Arrays;

public class NewPlayground {


    public static void main(String[] args) {

Integer[] ttt = {1,2,3,4,5};




        System.out.println(Arrays.stream(ttt).mapToInt(e-> e).reduce(Math::max));

    }
}
