import java.util.ArrayList;
import java.util.Arrays;

public class CommonElementsFromSortedArrays {


    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 5, 6, 7}, arr2 = {3, 6, 7, 8, 20};

        ArrayList<Integer> result = new ArrayList<>();

        int idx1 =0, idx2 =0;
        int lookupindex1 = 0, lookupindex2 = 0;
        while (idx1 < arr1.length-1 && idx2< arr2.length-1  ){
            if(arr1[idx1] == arr2[idx2]){
                result.add(arr1[idx1]);

                idx1++;
                idx2++;
            }
            else if(arr1[idx1] < arr2[idx2]){
                //advance arr1 and continue search
                lookupindex1 = Arrays.binarySearch(arr1, arr2[idx2]);
                if(lookupindex1 < 0){
                    idx1 = Math.abs(lookupindex1) - 1;
                    continue;
                }
                else if (arr1[lookupindex1] == arr2[idx2]){
                    result.add(arr1[lookupindex1]);
                    idx1 = lookupindex1 + 1;
                    idx2++;
                }
            }
            else{
                // advance arr2 and continue search
                lookupindex2 = Arrays.binarySearch(arr2, arr1[idx1]);
                if(lookupindex2 < 0){
                    idx2 = Math.abs(lookupindex2) - 1;
                    continue;
                }
                else if (arr2[lookupindex2] == arr1[idx1]){
                    result.add(arr2[lookupindex2]);
                    idx1++;
                    idx2 = lookupindex2 + 1;
                }
            }


        }


        System.out.println(Arrays.toString(result.toArray()));
    }
}
