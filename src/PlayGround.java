import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayGround {

    public static void main(String[] p){

        String s1 = "grapo";
        String s2 = "program";
        List<Character> s1ch = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> s2ch = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Map<Character, Integer> s1map = s1.chars().distinct().mapToObj(i -> (char) i).collect(Collectors.toMap(u->u, m->Collections.frequency(s1ch,m)));
        Map<Character, Integer> s2map = s2.chars().distinct().mapToObj(i -> (char) i).collect(Collectors.toMap(u->u, m->Collections.frequency(s2ch,m)));


        StringBuilder sb = new StringBuilder();
        for(char cs1: s1.toCharArray()){

            if(s2map.containsKey(cs1)==true){
                sb.append(Stream.generate(() ->  String.valueOf(cs1)).limit(s2map.get(cs1)).collect(Collectors.joining()));
            }

        }

        System.out.println(sb.toString());
    }
}
