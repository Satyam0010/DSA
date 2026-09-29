class Solution {
    int m, n;
    Boolean[][][] memo = new Boolean[101][101][201];

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 != 0)
            return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;
        return solve(0, 0, 0, grid);
    }

    private boolean solve(int i, int j, int count, char[][] grid) {
        count += (grid[i][j] == '(') ? 1 : -1;
        if (count < 0) return false;
        if (memo[i][j][count] != null) return memo[i][j][count];
        if (i == m - 1 && j == n - 1) return memo[i][j][count] = (count == 0);
        if (i + 1 < m) {
            if(solve(i + 1, j, count, grid)) return memo[i][j][count] = true;
        }
        if (j + 1 < n) {
            if (solve(i, j + 1, count, grid)) return memo[i][j][count] = true;
        }
        return memo[i][j][count] = false;
    }
}