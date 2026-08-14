class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        int ans = check(0,0,m-1,n-1,grid,memo);
        return ans;
    }

    private int check(int currRow,int currCol,int totalRow,int totalCol,int[][] grid,Integer[][] memo){
        if(grid[currRow][currCol] == 1) return 0;
        if(currRow == totalRow && currCol == totalCol) return 1;
        if(memo[currRow][currCol] != null) return memo[currRow][currCol];
        int row = 0;
        int col = 0;
        if(currRow+1 <= totalRow && grid[currRow+1][currCol] == 0) row = check(currRow+1,currCol,totalRow,totalCol,grid,memo);
        if(currCol+1 <= totalCol && grid[currRow][currCol+1] == 0) col = check(currRow,currCol+1,totalRow,totalCol,grid,memo);
        return memo[currRow][currCol] = row+col;
    }
}