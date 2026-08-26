class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1,high = Integer.MIN_VALUE,ans = high;
        for(int num : nums){
            if(num > high) high = num;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            int sum = 0;
            for(int num : nums){
                sum += (num+mid-1)/mid;
            }
            if(sum > threshold){
                low = mid+1;
            }else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}