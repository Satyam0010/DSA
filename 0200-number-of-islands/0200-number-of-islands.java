class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    bfs(grid,i,j,visited,m,n);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void bfs(char[][] grid,int row,int col,boolean[][] visited,int m,int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        visited[row][col] = true;
        while(!q.isEmpty()){
            int[] front = q.remove();
            int r = front[0];
            int c = front[1];
            if(r-1 >= 0 && grid[r-1][c] == '1' && visited[r-1][c] == false){
                visited[r-1][c] = true;
                q.add(new int[]{r-1,c});
            }
            if(c-1 >= 0 && grid[r][c-1] == '1' && visited[r][c-1] == false){
                visited[r][c-1] = true;
                q.add(new int[]{r,c-1});
            }
            if(r+1 < m && grid[r+1][c] == '1' && visited[r+1][c] == false){
                visited[r+1][c] = true;
                q.add(new int[]{r+1,c});
            }
            if(c+1 < n && grid[r][c+1] == '1' && visited[r][c+1] == false){
                visited[r][c+1] = true;
                q.add(new int[]{r,c+1});
            }
        }
    }
}