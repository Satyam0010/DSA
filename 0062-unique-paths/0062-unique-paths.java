class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        int ans = check(0,0,m-1,n-1,memo);
        return ans;
    }
    private int check(int currentRow,int currentColumn,int totalRow,int totalColumn,Integer[][] memo){
        if(currentRow == totalRow && currentColumn == totalColumn) return 1;
        if(memo[currentRow][currentColumn] != null) return memo[currentRow][currentColumn];
        int row = 0;
        int col = 0;
        if(currentRow+1 <= totalRow) row = check(currentRow+1,currentColumn,totalRow,totalColumn,memo);
        if(currentColumn+1 <= totalColumn) col = check(currentRow,currentColumn+1,totalRow,totalColumn,memo);
        return memo[currentRow][currentColumn] = row+col;
    }
}