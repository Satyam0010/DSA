class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));

        int originalcolor = image[sr][sc];
        while(!q.isEmpty()){
            Pair Node = q.remove();
            int row = Node.row;
            int col = Node.col;
            image[row][col] = color;
            visited[row][col] = true;
            if(row-1 >= 0 && image[row-1][col] == originalcolor && visited[row-1][col] == false){
                q.add(new Pair(row-1,col));
            }
            if(col-1 >= 0 && image[row][col-1] == originalcolor && visited[row][col-1] == false){
                q.add(new Pair(row,col-1));
            }
            if(row+1 < m && image[row+1][col] == originalcolor && visited[row+1][col] == false){
                q.add(new Pair(row+1,col));
            }
            if(col+1 < n && image[row][col+1] == originalcolor && visited[row][col+1] == false){
                q.add(new Pair(row,col+1));
            }
        }
        return image;
    }
}