class Solution {
    long MOD = 1000000007;
    public int numTilings(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 5;
        long current = 0;
        long f1 = 1;
        long f2 = 2;
        long f3 = 5;
        for(int i = 4; i <= n; i++){
            current = (2 *f3+f1) % MOD;
            f1 = f2;
            f2 = f3;
            f3 = current;
        }
        return (int)f3;
    }
}