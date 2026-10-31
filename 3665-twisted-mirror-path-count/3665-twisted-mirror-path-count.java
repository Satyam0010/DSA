class Solution {
    private final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int[][] right = new int[totalRows][totalCols];
        int[][] down = new int[totalRows][totalCols];
        //lets enter from the right direction so
        right[0][0] = 1;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                int r = right[i][j]; //Number of paths from right till [i][j] cell
                int d = down[i][j]; //Number of paths from down till [i][j] cell

                if (grid[i][j] == 0) {
                    long ways = ((long) r + d) % MOD; //total ways
                    if (j + 1 < totalCols) {
                        right[i][j + 1] = (int) ((right[i][j + 1] + ways) % MOD);
                    }
                    if (i + 1 < totalRows) {
                        down[i + 1][j] = (int) ((down[i + 1][j] + ways) % MOD);
                    }
                } else {
                    if (i + 1 < totalRows) {
                        down[i + 1][j] = (int) ((down[i + 1][j] + (long) r) % MOD); // total ways from right
                    }
                    if (j + 1 < totalCols) {
                        right[i][j + 1] = (int) ((right[i][j + 1] + (long) d) % MOD); //total ways from down
                    }
                }
            }
        }
        return (int) ((right[totalRows - 1][totalCols - 1] + down[totalRows - 1][totalCols - 1]) % MOD);
    }
}