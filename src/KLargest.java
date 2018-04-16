import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

class KLargest
{
    // Function to find the K'th largest element in the
    // array using max-heap
    public static int FindKthLargest(List<Integer> ints, int k)
    {
        // create an max-heap using PriorityQueue class from all 
        // elements in the list

        PriorityBlockingDeque<Integer> pq = new PriorityBlockingDeque<Integer>( Comparator.reverseOrder(), k+1);
                                    // or pass Comparator.reverseOrder()
        //pq.addAll(ints);

        for(int t: ints){

                if(pq.size() == k)
                {
                  pq.offer(t);
                  pq.pollLast();
                }
                else {
                  pq.offer(t);
                }


        }

        System.out.println(pq);
//        // pop from max-heap exactly (k-1) times
//        while (pq.size() > 1) {
//            System.out.println(pq.peek());
//
//        }

        // return the root of max-heap
        return pq.peek();
    }


    public static void main(String[] args)
    {
        List<Integer> ints  = Arrays.asList(7, 3, 9, 1, 6, 87, 42);
        int k = 3;
      //
        System.out.println("K'th largest element in the array is " +
                FindKthLargest(ints, k)               );
    }
}