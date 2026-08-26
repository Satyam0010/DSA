class Solution {
    private static final int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long evenans = pow(5,even);
        long oddans = pow(4,odd);
        return (int)((evenans*oddans)%mod);
    }
    private long pow(long base , long exp){
        long result = 1;
        base = base%mod;
        while(exp > 0){
            if((exp & 1) == 1)
            result = (result*base)%mod;
            base = (base*base)%mod;
            exp = exp>>1;
        }
        return result;
    }
}