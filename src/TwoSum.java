import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if(map.containsKey(target-numbers[i])){
               int[] result = new int[2];
               result[1] = i;
               result[0] = map.get(target-numbers[i]);
               return result;
			}
			map.put(numbers[i],i);


		}
		return new int[]{0, 0};
	}


	public static void main(String[] args) {

		int[] intarray = {2,4,5,6,1,7,78,89};

		System.out.println(Arrays.toString(twoSum(intarray, 9)));

	}
}