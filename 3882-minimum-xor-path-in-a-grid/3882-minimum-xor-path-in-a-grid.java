class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxVal = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxVal = Math.max(maxVal, grid[i][j]);
            }
        }
        int maxXor = 1;
        while (maxXor <= maxVal) {
            maxXor <<= 1;
        }
        
        boolean[][][] dp = new boolean[m][n][maxXor];
        
        dp[0][0][grid[0][0]] = true;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                
                
                if (i == 0 && j == 0) continue;
                
                for (int k = 0; k < maxXor; k++) {
                    if (i > 0 && dp[i - 1][j][k ^ x]) {
                        dp[i][j][k] = true;
                    }
                    if (j > 0 && dp[i][j - 1][k ^ x]) {
                        dp[i][j][k] = true;
                    }
                }
            }
        }
        
        for (int k = 0; k < maxXor; k++) {
            if (dp[m - 1][n - 1][k]) {
                return k;
            }
        }
        
        return 0;
    }
}
