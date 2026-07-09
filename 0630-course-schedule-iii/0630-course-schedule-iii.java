class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int n = courses.length;
        Arrays.sort(courses,(a,b)-> Integer.compare(a[1],b[1]));
        int coursecompleteddays = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(courses[i][0] + coursecompleteddays <= courses[i][1]){
                coursecompleteddays += courses[i][0];
                ans += 1;
                max.offer(courses[i][0]);
            }
            else if(!max.isEmpty() && max.peek() > courses[i][0]){
                int nn = max.poll();
                coursecompleteddays -= nn;
                coursecompleteddays += courses[i][0];
                max.offer(courses[i][0]);
            }
        }
        return ans;
    }
}