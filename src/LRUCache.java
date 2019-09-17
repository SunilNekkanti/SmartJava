import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int value = map.get(key);
        removeBeforeAdd(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeBeforeAdd(key, value);
            return;
        }

        map.put(key, value);
    }

    private void removeBeforeAdd(int key, int value) {
        map.remove(key);
        map.put(key,value);
    }

    public static void main(String[] args) {

        LRUCache lru = new LRUCache(4);

        lru.put(1,3);
        lru.put(2,5);
        lru.put(3,6);
        lru.put(4,7);
        lru.put(1,9);
        lru.put(2,19);
        lru.get(3);
        lru.get(1);
        lru.get(2);
        System.out.println(lru.map);




    }
}