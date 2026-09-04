class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(String s : strs){
            int zeroes = 0;
            int ones = 0;
            char[] ch = s.toCharArray();
            for(char c : ch){
                if(c == '0') zeroes++;
                else ones++;
            }
            for(int i = m; i >= zeroes;i--){
                for(int j = n; j >= ones;j--){
                    memo[i][j] = Math.max(memo[i][j],memo[i-zeroes][j-ones]+1);
                }
            }
        }
        return memo[m][n];
    }
}