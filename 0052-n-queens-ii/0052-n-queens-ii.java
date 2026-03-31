class Solution {

    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        int count = queens(board,0,ans);
        return count;
    }

    static int queens(boolean[][] board,int row, List<List<String>> ans){


        if(row == board.length){
            display(board,ans);
            return 1;
        }

        int count = 0;

        for(int col = 0; col < board.length; col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board,row+1,ans);
                board[row][col] =  false;
            }
        }
        return count;
    }


        private static boolean isSafe(boolean[][] board, int row, int col){
        for(int i = 0; i < row ; i++){
            if(board[i][col]){
                return false;
            }
        }

        int maxLeft = Math.min(row,col);
        for(int i = 1; i <= maxLeft; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }


        int maxRight = Math.min(row,board.length-col-1);
        for(int i = 1; i <= maxRight; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board, List<List<String>> ans){

        List<String> single = new ArrayList<>();

        for(boolean[] row : board){
            
            StringBuilder s = new StringBuilder();
            for(boolean element : row){
                if(element){
                    s.append("Q");
                }else{
                    s.append(".");
                }
            }
            single.add(s.toString());
        }

          ans.add(single);
    }
}