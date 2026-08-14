class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        int ans = check(0,0,m-1,n-1,grid,memo);
        return ans;
    }

    private int check(int currentRow,int currentColumn,int totalRow,int totalColumn,int[][] grid,Integer[][] memo){
        if(currentRow == totalRow && currentColumn == totalColumn) return grid[currentRow][currentColumn];
        if(memo[currentRow][currentColumn] != null) return memo[currentRow][currentColumn];
        int row = Integer.MAX_VALUE;
        int col = Integer.MAX_VALUE;
        if(currentRow+1 <= totalRow) row = grid[currentRow][currentColumn] + check(currentRow+1,currentColumn,totalRow,totalColumn,grid,memo);
        if(currentColumn+1 <= totalColumn) col = grid[currentRow][currentColumn] + check(currentRow,currentColumn+1,totalRow,totalColumn,grid,memo);
        return memo[currentRow][currentColumn] = Math.min(row,col);
    }
}