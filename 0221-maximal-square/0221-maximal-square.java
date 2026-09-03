class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = dp.length-1;i >= 0;i--){
            for(int j = dp[0].length-1; j >= 0;j--){
                if(i == dp.length-1 && j == dp[0].length-1){
                    dp[i][j] = matrix[i][j] -'0';
                }else if(i == dp.length-1){
                    dp[i][j] = matrix[i][j]-'0';
                }else if (j == dp[0].length-1){
                    dp[i][j] = matrix[i][j]-'0';
                }else{
                    if(matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i+1][j+1]))+1;
                        
                    }
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
}