class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[] rows = { -1, 1, 0, 0 };
        int[] cols = { 0, 0, 1, -1 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    long totalSum = 0;
                    Queue<int[]> q = new LinkedList<>();
                    totalSum += grid[i][j];
                    grid[i][j] = 0;
                    q.offer(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int currRow = current[0];
                        int currCol = current[1];

                        for (int x = 0; x < 4; x++) {
                            int nextRow = currRow + rows[x];
                            int nextCol = currCol + cols[x];
                            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
                                    && grid[nextRow][nextCol] != 0) {
                                totalSum += grid[nextRow][nextCol];
                                grid[nextRow][nextCol] = 0;
                                q.offer(new int[] { nextRow, nextCol });
                            }
                        }
                    }
                    if (totalSum % k == 0)
                        ans++;
                }
            }
        }
        return ans;
    }
}