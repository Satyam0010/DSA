class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        Integer[][] memo = new Integer[nums.length][nums.length+1];
        return check(0,-1,nums,memo);
    }

    private int check(int currIndex,int prevIndex,int[] nums,Integer[][] memo){
        if(currIndex == nums.length) return 0;
        if(memo[currIndex][prevIndex+1] != null) return memo[currIndex][prevIndex+1];
        int take = 0;
        if(prevIndex == -1 || nums[currIndex] > nums[prevIndex]) take = 1 + check(currIndex+1,currIndex,nums,memo);
        int notTake = check(currIndex+1,prevIndex,nums,memo);
        return memo[currIndex][prevIndex+1] = Math.max(take,notTake);
    }
}