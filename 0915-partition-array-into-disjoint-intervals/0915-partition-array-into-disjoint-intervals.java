class Solution {
    public int partitionDisjoint(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        int ans = 0;
        for(int i = 1; i < nums.length ; i++){
            curr = Math.max(nums[i],curr);
            if(nums[i] < max){
                max = curr;
                ans = i;
            }
        } return ans+1;
    }
}