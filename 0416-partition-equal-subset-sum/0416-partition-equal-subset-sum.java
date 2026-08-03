class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum%2 != 0) return false;
        int target = sum/2;
        Boolean[][] memo = new Boolean[nums.length][target+1];
        return check(nums,target,0,memo);
    }

    private boolean check(int[] nums,int sum,int i,Boolean[][] memo){
        if(i == nums.length) return false;
        if(sum == 0) return true;
        if(memo[i][sum] != null) return memo[i][sum];
        if(nums[i] > sum){
            return check(nums,sum,i+1,memo);
        }
        memo[i][sum] = check(nums,sum,i+1,memo) || check(nums,sum-nums[i],i+1,memo);
        return memo[i][sum];
    }
}