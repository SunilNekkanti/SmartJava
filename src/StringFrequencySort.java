import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class StringFrequencySort {
    public static String frequencySort(String s) {
	    /*count each characters frequency*/
	    Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        
        /*put characters from map in a heap which is ordered by their frequency using a Comparator as specified in the below lambda. (a,b)-> b-a is descending. (a,b) -> a-b is ascending.*/
        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        q.addAll(map.keySet());
        
       /*pop from queue until its empty and append character to string builder based off the frequency of the character stored in the map. */
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char c = q.poll();
            //int freq = map.get(c);
            //for(int i = 0; i < freq; i++)
                sb.append(c);
        }      
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("hello"));
    }
}