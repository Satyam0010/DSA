class Solution {
    private Integer[][] dp = new Integer[20][20];
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        if(len == 1) return true;
        return solve(0,len-1,nums) >= 0;
    }

    private int solve(int i , int j,int[] nums){
        if(i > j) return 0;
        if(i == j) return nums[i];
        if(dp[i][j] != null) return dp[i][j];
        int take_i = nums[i] - solve(i+1,j,nums);
        int take_j = nums[j] - solve(i,j-1,nums);
        return dp[i][j] = Math.max(take_i,take_j);
    }
}