class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int totalRow = maze.length;
        int totalCol = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0],entrance[1],0});
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];
            maze[row][col] = '+';
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newRow < totalRow && newCol >= 0 && newCol < totalCol && maze[newRow][newCol] == '.'){
                    if(newRow == 0 || newCol == 0 || newRow == totalRow - 1 || newCol == totalCol - 1) return steps+1;
                    maze[newRow][newCol] = '+';
                    q.offer(new int[]{newRow,newCol,steps+1});
                }
            }
        }
        return -1;
    }
}