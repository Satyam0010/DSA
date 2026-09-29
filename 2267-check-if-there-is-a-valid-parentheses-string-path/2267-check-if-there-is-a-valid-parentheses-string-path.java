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
        //return solve(0, 0, 0, grid);

        //tabulation

        for(int i = m-1; i >= 0; i--){

            for(int j = n-1; j >= 0; j--){

                for(int count = 0; count <= i+j+1 ; count++){
                    if(i == m-1 && j == n-1){
                        memo[i][j][count] = (count==0);
                        continue;
                    }

                    memo[i][j][count] = false;

                    if(i + 1 < m){
                        int newCount = (grid[i+1][j] == '(') ? count+1 : count-1;
                        if(newCount >= 0 && memo[i+1][j][newCount] == true){
                            memo[i][j][count] = true;
                        }
                    }

                    if(j + 1 < n){
                        int newCount = (grid[i][j+1] == '(') ? count+1 : count-1;
                        if(newCount >= 0 && memo[i][j+1][newCount] == true){
                            memo[i][j][count] = true;
                        }
                    }

                }
            }
        }

        return memo[0][0][1];
    }
    //memo approach
    // private boolean solve(int i, int j, int count, char[][] grid) {
    //     count += (grid[i][j] == '(') ? 1 : -1;
    //     if (count < 0) return false;
    //     if (memo[i][j][count] != null) return memo[i][j][count];
    //     if (i == m - 1 && j == n - 1) return memo[i][j][count] = (count == 0);
    //     if (i + 1 < m) {
    //         if(solve(i + 1, j, count, grid)) return memo[i][j][count] = true;
    //     }
    //     if (j + 1 < n) {
    //         if (solve(i, j + 1, count, grid)) return memo[i][j][count] = true;
    //     }
    //     return memo[i][j][count] = false;
    // }
}