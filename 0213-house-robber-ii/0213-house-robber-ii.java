class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 1) return nums[0];
        return Math.max(check(nums,1,l-1),check(nums,0,l-2));
    }

    private int check(int[] nums,int start,int end){
        int prev = nums[start];
        int prev2 = 0;
        for(int i = start+1; i <= end; i++){
            int take = nums[i];
            if(i > 1) take += prev2;
            int nottake = 0+prev;
            int curr = Math.max(take,nottake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}