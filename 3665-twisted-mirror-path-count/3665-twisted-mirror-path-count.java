class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        right[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = right[i][j];
                int d = down[i][j];
                if (grid[i][j] == 0) {
                    long ways = ((long) r + d) % MOD;
                    if (j + 1 < n) {
                        right[i][j + 1] = (int) ((right[i][j + 1] + ways) % MOD);
                    }
                    if (i + 1 < m) {
                        down[i + 1][j] = (int) ((down[i + 1][j] + ways) % MOD);
                    }
                } else {
                    if (i + 1 < m) {
                        down[i + 1][j] = (int) ((down[i + 1][j] + (long) r) % MOD);
                    }
                    if (j + 1 < n) {
                        right[i][j + 1] = (int) ((right[i][j + 1] + (long) d) % MOD);
                    }
                }
            }
        }
        return (int) (((long) right[m - 1][n - 1] + down[m - 1][n - 1]) % MOD);
    }
}