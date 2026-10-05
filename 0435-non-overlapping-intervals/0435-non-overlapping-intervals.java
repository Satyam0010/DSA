class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int prevEndTime = Integer.MIN_VALUE;
        for(int[] curr : intervals){
            if(curr[0] < prevEndTime) ans++;
            else prevEndTime = curr[1];
        }
        return ans;
    }
}