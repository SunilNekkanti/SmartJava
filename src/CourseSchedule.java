import java.util.LinkedList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == course){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {

       CourseSchedule cs = new CourseSchedule();

        System.out.println(cs.canFinish(2,new int[][]{{0,1}, {1,2}}));

    }
}