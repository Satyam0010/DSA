class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        int tab[][] = new int[k+1][n+1];
        for(int i = 0; i <= n; i++){
            tab[0][i] = 1;
        }
        for(int segment = 1; segment <= k; segment++){
            int[] prevSum = new int[n+1];
            for(int position = n-1 ; position >= 0 ; position--){
                prevSum[position] = (int) ((prevSum[position+1] + tab[segment-1][position])%MOD);
            }
            for(int position = n-1; position >= 0; position--){
                long ways = tab[segment][position+1];
                ways += prevSum[position+1];
                tab[segment][position] = (int) (ways%MOD);
            }
        }
        return tab[k][0];
    }
}