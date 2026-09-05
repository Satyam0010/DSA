class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0, left = 0, sum = 0,startingZero = 0;
        for(int right = 0; right < nums.length;right++){
            sum += nums[right];
            while(left < right && sum > goal){
                startingZero = 0;
                sum -= nums[left];
                left++;
            }
            while(left < right && nums[left] == 0){
                startingZero++;
                left++;
            }
            if(sum == goal){
                ans += 1 + startingZero;
            }
        }
        return ans;
    }
}