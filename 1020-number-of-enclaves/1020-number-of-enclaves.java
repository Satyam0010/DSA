class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ;j++){
                if(grid[i][j] == 1 && (i==0 || j == 0 || i==m-1 || j==n-1 )){
                    grid[i][j] = -1;
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];
            if(row-1 >= 0 && grid[row-1][col]==1){
                grid[row-1][col] = -1;
                q.add(new int[]{row-1,col});
            }
            if(col-1 >= 0 && grid[row][col-1]==1){
                grid[row][col-1] = -1;
                q.add(new int[]{row,col-1});
            }
            if(row+1 < m && grid[row+1][col]==1){
                grid[row+1][col] = -1;
                q.add(new int[]{row+1,col});
            }
            if(col+1 < n && grid[row][col+1]==1){
                grid[row][col+1] = -1;
                q.add(new int[]{row,col+1});
            }
        }
        int ans = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ;j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
}