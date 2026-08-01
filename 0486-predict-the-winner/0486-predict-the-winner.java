class Solution {
    int[][] dp = new int[20][20];
    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        if(len == 1) return true;
        int total = 0;
        for(int i = 0; i < 20;i++){
            for(int j = 0; j < 20;j++){
                dp[i][j] = -1;
            }
        }
        for(int num : nums){
            total += num;
        }
        int player1 = solve(0,len-1,nums);
        int player2 = total - player1;
        return player1 >= player2;
    }

    private int solve(int i , int j,int[] nums){
        if(i > j) return 0;
        if(i == j) return nums[i];
        if(dp[i][j] != -1) return dp[i][j];
        int take_i = nums[i] + Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums));
        int take_j = nums[j] + Math.min(solve(i,j-2,nums),solve(i+1,j-1,nums));
        return dp[i][j] = Math.max(take_i,take_j);
    }
}