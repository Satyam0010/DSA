class Solution {
    public String[] createGrid(int m, int n) {
        char[][] ch = new char[m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                ch[i][j] = '#';
            }
        }
        for(int i = 0; i < n;i++){
            ch[0][i] = '.';
        }
        for(int i = 0; i < m;i++){
            ch[i][n-1] = '.';
        }
        String[] ans = new String[m];
        for(int i = 0; i < m;i++){
            ans[i] = new String(ch[i]);
        }
        return ans;
    }
}