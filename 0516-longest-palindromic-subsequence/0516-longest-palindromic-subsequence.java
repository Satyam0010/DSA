class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int l = s.length();
        int[][] memo = new int[l + 1][l + 1];
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1))
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                else
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[l][l];
    }
}