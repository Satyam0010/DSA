class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c) return mat;
        int[][] ans = new int[r][c];
        int x = 0;
        int y = 0;
        for(int i = 0; i < r ; i++){
            for(int j = 0; j < c;j++){
                ans[i][j] = mat[x][y];
                if(y < n-1){
                    y++;
                }else{
                    y = 0;
                    x++;
                }
            }
        }
        return ans;
    }
}