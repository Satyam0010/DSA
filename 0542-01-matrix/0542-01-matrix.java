class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] ans = new int[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;
            if(row-1 >= 0 && mat[row-1][col]==1 && ans[row-1][col]==0){
                ans[row-1][col] = ans[row][col] + 1;
                q.add(new Pair(row-1,col));
            }
            if(col-1 >= 0 && mat[row][col-1]==1 && ans[row][col-1]==0){
                ans[row][col-1] = ans[row][col] + 1;
                q.add(new Pair(row,col-1));
            }
            if(row+1 < m && mat[row+1][col]==1 && ans[row+1][col]==0){
                ans[row+1][col] = ans[row][col] + 1;
                q.add(new Pair(row+1,col));
            }
            if(col+1 < n && mat[row][col+1]==1 && ans[row][col+1]==0){
                ans[row][col+1] = ans[row][col] + 1;
                q.add(new Pair(row,col+1));

            }
    }
    return ans;
    }
}