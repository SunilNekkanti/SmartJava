import java.util.Map;
import java.util.Set;
import java.util.*;

class NonOverlapping {
  static class timePoint{
    int id;
    int type;
    int cur_time;
    timePoint(int id, int type, int cur_time){
      this.id = id;
      this.type = type;
      this.cur_time = cur_time;
    }
  }

  public static int startType = 0;
  public static int endType = 1;
  public static void main(String[] args) {
     
    int[][] times = new int[][] {{1, 150, 300}, {2, 100, 200},{3, 300, 350}};
//            { { 1, 10, 30 }, { 2, 20, 40 }, { 3, 30, 60 }, { 4, 40, 50 }, { 5, 20, 30 }, { 6, 5, 70 } };
//

    Map<Integer, int[]> res = findexclusiveTime(times);

    for(int key: res.keySet()){
         System.out.println(key+" "+res.get(key)[1]+" ");
    }
     
  
  }


  public static Map<Integer, int[]> findexclusiveTime(int[][] times){
       List<timePoint> list = new ArrayList<>();
       for(int[] time: times){
           list.add(new timePoint(time[0], startType, time[1]));
           list.add(new timePoint(time[0], endType, time[2]));
       }


       Collections.sort(list, new Comparator<timePoint>(){
               public int compare(timePoint a, timePoint b){
                 return a.cur_time - b.cur_time;
               }
       });


       Set<Integer> set = new HashSet<>();
       timePoint pre = null;
       Map<Integer, int[]> map = new HashMap<>();
       for(timePoint curPoint: list){
          if(set.size()==1){
              int get_id = set.iterator().next();
              int duration = curPoint.cur_time - pre.cur_time;

              if(map.containsKey(get_id)==false){
                  map.put(get_id, new int[]{get_id, 0});
              }
              int[] val = map.get(get_id);
              val[1] += duration;
          }

          if(curPoint.type == startType){
            set.add(curPoint.id);
          }else{
            set.remove(curPoint.id);
          }
          pre = curPoint;
       }

       return map;
  }


}