class Node{
    int row;
    int col;
    int val;
    int time;
    Node(int row,int col,int val,int time){
        this.row = row;
        this.col = col;
        this.val = val;
        this.time = time;
    }
}
class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        int[][] time = new int[n][m];
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> {
        if (a.time != b.time) {
            return a.time - b.time;
        }
        return b.val - a.val;
    }
);
        for(int i = 0; i < n; i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }
        for(int[] src : sources){
            int row = src[0];
            int col = src[1];
            int color = src[2];
            grid[row][col] = color;
            time[row][col] = 0;
            q.add(new Node(row,col,color,0));
        }
        int[] r = {-1,0,1,0};
        int[] c = {0,-1,0,1};
        while(!q.isEmpty()){
            Node node = q.remove();
            int row = node.row;
            int col = node.col;
            int val = node.val;
            int timee = node.time;

            for(int k = 0 ; k < 4;k++){
                int nr = row + r[k];
                int nc = col + c[k];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                if(time[nr][nc] > timee + 1){
                    time[nr][nc] = timee+1;
                    grid[nr][nc] = val;
                    q.add(new Node(nr,nc,val,timee+1));
                }else if(time[nr][nc] == timee+1){
                    grid[nr][nc] = Math.max(grid[nr][nc],val);
                }
            }
            
        }
        return grid;
    }
}