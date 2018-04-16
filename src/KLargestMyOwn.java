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

        PriorityBlockingQueue<Integer> pq_reverse = new PriorityBlockingQueue<Integer>( k+1, Comparator.reverseOrder());

        PriorityBlockingQueue<Integer> pq_natural = new PriorityBlockingQueue<Integer>( k+1, Comparator.naturalOrder());
        for(int t: ints){

                if(pq_reverse.size() == k) {
                    pq_reverse.offer(t);
                    pq_natural.offer(t);
                    pq_reverse.remove(pq_natural.poll());
                }
                else {
                  pq_reverse.offer(t);
                  pq_natural.offer(t);
                }
        }

         k = pq_reverse.size();
        while (--k >= 1) {
            pq_reverse.poll();

        }

        // return the root of max-heap
        return pq_reverse.peek();
    }


    public static void main(String[] args)
    {
        int[] given = {7, 3, 9, 1, 6, 87, 42};
        List<Integer> ints  = Arrays.stream(given).boxed().collect(Collectors.toList());
        int k = 3;
      //
        System.out.println(k + " largest element in the array is " +
                FindKthLargest(ints, k)               );
    }
}