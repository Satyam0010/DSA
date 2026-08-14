class Solution {
    public int minimumDifference(int[] nums, int k) {
        int len = nums.length;
        if(k == 1) return 0;
        if(len == 1) return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= len-k;i++){
            for(int j = i+1; j < len;j++){
                if(j-i+1 == k){
                int curr = Math.abs(nums[i]-nums[j]);
                ans = Math.min(ans,curr);
                }
            }
        }
        return ans;
    }
}