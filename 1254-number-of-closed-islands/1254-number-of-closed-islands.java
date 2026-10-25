class Solution {
    int m, n;

    public int closedIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && check(grid, i, j))
                    ans++;
            }
        }
        return ans;
    }

    private boolean check(int[][] grid, int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if (grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        boolean up = check(grid, i - 1, j);
        boolean down = check(grid, i + 1, j);
        boolean left = check(grid, i, j - 1);
        boolean right = check(grid, i, j + 1);
        return up && down && left && right;
    }
}