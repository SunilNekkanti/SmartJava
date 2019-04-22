import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;

class KLargestMyOwn
{
    // Function to find the K'th largest element in the
    // array using max-heap
    public static int FindKthLargest(List<Integer> ints, int k)
    {
        // create an max-heap using PriorityQueue class from all 
        // elements in the list

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());


        for(int i:ints){

            if(pq.size()<ints.size()-k+1) {

                pq.add(i);

            }
            else{
                pq.add(i);
                pq.poll();
                ///System.out.println(pq);
            }
        }


        return pq.peek();
    }


    public static void main(String[] args)
    {
        int[] given = {87, 42, 7, 3, 9, 1, 6};

        List<Integer> ints  = Arrays.stream(given).boxed().collect(Collectors.toList());
        int k = 3;
      //
        System.out.println(k + " largest element in the array is " +
                FindKthLargest(ints, k)               );
    }
}