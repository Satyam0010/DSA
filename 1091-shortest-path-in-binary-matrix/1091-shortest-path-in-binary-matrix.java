class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 1;
        int path = 1;
        int[][] choices = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i < size;i++){
                int[] currCell = q.poll();
                int currRow = currCell[0];
                int currCol = currCell[1];
                if(currRow == n-1 && currCol == n-1){
                    return path;
                }
                for(int[] dir : choices){
                    int newRow = currRow+dir[0];
                    int newCol = currCol+dir[1];
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0){
                        grid[newRow][newCol] = 1;
                        q.offer(new int[]{newRow,newCol});
                    }
                }
            }
            path++;
        }
        return -1;
    }
}