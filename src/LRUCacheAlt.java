import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheAlt {
    Map<Integer, Integer> map = new HashMap();
    LinkedList<Integer> ll = new LinkedList();
    int capacity;
    public LRUCacheAlt(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            ll.remove((Integer)key);
            ll.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ll.remove((Integer)key);
            map.put(key, value);
            ll.add(key);
        }
        else   {
            if(map.size()== capacity){
                int removedKey = ll.removeFirst();
                System.out.println(removedKey);
                map.remove((Integer)removedKey);
            }
            map.put(key, value);
            ll.add(key);
        }
    }


    public static void main(String[] args) {
        LRUCacheAlt lru = new LRUCacheAlt(4);

        lru.put(1,3);
        lru.put(2,5);
        lru.put(3,6);
        lru.put(4,7);
        lru.put(1,9);
        lru.put(2,19);

        System.out.println(lru.map);


    }
}