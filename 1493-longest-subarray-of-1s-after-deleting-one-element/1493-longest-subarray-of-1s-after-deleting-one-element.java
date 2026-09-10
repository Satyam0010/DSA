class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        if(nums[0] == 1) prefix[0] = 1;
        if(nums[n-1] == 1) suffix[n-1] = 1;
        for(int i = 1; i < n;i++){
            if(nums[i] == 1) prefix[i] = 1+prefix[i-1];
            else prefix[i] = 0;
        }
        for(int i = n-2; i >= 0;i--){
            if(nums[i] == 1) suffix[i] = 1+suffix[i+1];
            else suffix[i] = 0;
        }
        int ans = 0;
        for(int i = 0; i < n;i++){
            int left = (i == 0) ? 0 : prefix[i-1];
            int right = (i == n-1) ? 0 : suffix[i+1];
            ans = Math.max(ans,left+right);
        }
        return ans;
    }
}