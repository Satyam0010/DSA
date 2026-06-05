class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            if(board[i][0] == 'O' && visited[i][0] == false){
                bfs(i,0,board,visited,m,n);
            }
            if(board[i][n-1] == 'O' && visited[i][n-1] == false){
                bfs(i,n-1,board,visited,m,n);
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(board[0][i] == 'O' && visited[0][i] == false){
                bfs(0,i,board,visited,m,n);
            }
            if(board[m-1][i] == 'O' && visited[m-1][i] == false){
                bfs(m-1,i,board,visited,m,n);
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n;j++){
                if(board[i][j] == 'O' && visited[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void bfs(int row,int col,char[][] board,boolean[][] visited,int m,int n){
        visited[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        while(!q.isEmpty()){
            Pair node = q.remove();
            int r = node.row;
            int c = node.col;
            if(r-1 >= 0 && board[r-1][c] == 'O' && visited[r-1][c] == false){
                visited[r-1][c] = true;
                q.add(new Pair(r-1,c));
            }
            if(c-1 >= 0 && board[r][c-1] == 'O' && visited[r][c-1] == false){
                visited[r][c-1] = true;
                q.add(new Pair(r,c-1));
            }
            if(r+1 < m && board[r+1][c] == 'O' && visited[r+1][c] == false){
                visited[r+1][c] = true;
                q.add(new Pair(r+1,c));
            }
            if(c+1 < n && board[r][c+1] == 'O' && visited[r][c+1] == false){
                visited[r][c+1] = true;
                q.add(new Pair(r,c+1));
            }
        }
    }
}