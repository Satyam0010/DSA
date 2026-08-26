class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1,high = Integer.MIN_VALUE;
        for(int num : piles){
            if(num > high) high = num;
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high-low)/2;
            long sum = 0;
            for(int num : piles){
                sum += (num +mid-1)/mid;
            }
            if(sum <= h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}