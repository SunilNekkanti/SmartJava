import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class TruckSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int truckSpace01 = 110;
		ArrayList<Integer> ts01 = new ArrayList<Integer>();
		ts01.add(20);
		ts01.add(90);
		ts01.add(80);
		ts01.add(30);
		ts01.add(60);
		ts01.add(110);
		System.out.println(getPackageIds(truckSpace01, ts01));

		int truckSpace02 = 250;
		ArrayList<Integer> ts02 = new ArrayList<Integer>();
		ts02.add(100);
		ts02.add(180);
		ts02.add(40);
		ts02.add(120);
		ts02.add(10);
		System.out.println(getPackageIds(truckSpace02, ts02));
	}
	
	public static ArrayList<Integer> getPackageIds(int truckSpace, ArrayList<Integer> items){
		
		int fillSpace = truckSpace - 30;
		
		ArrayList<Integer> fillAl = new ArrayList<Integer>();
		ArrayList<Integer> finalAl = new ArrayList<Integer>();
		for(int i=0; i < items.size(); i++) {	
			for(int j=i+1; j < items.size()-1; j++) {
				int size = items.get(i) + items.get(j);
				if (size == fillSpace) {
					fillAl.add(i);
					fillAl.add(j);
				} else {
						
				}
			}
		}
		
		// Creating an empty HashMap 
        HashMap<Integer, Integer> hash_map = new HashMap<Integer, Integer>(); 
		for(int i=0; i < fillAl.size(); i++) {
			hash_map.put(fillAl.get(i), items.get(fillAl.get(i)));
		}
		
		int maxValueInMap=(Collections.max(hash_map.values()));
        for (Entry<Integer, Integer> entry : hash_map.entrySet()) {
            if (entry.getValue()==maxValueInMap) {
                int maxKey = entry.getKey();
                finalAl.add(maxKey);
                for(int i=0; i < fillAl.size(); i++) {
                	if(i != maxKey) {
                		if(items.get(i) + items.get(maxKey) == fillSpace) {
                			finalAl.add(i);
                		}
                	}
                }
            }
        }
        Collections.sort(finalAl);
		return finalAl;
		
	}
}