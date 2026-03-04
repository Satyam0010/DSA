class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long start = 1;
        long end = (long)n*Math.min(a,b);
        long lcm = (long)a/gcd(a,b)*b;
        long mod = 1000000007;
        while(start < end){
            long mid = start+(end-start)/2;
            long count = (mid/a)+(mid/b)-(mid/lcm);
            if(count < n){
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return (int)(start%mod);
    }

    private long gcd(long a , long b){
        while(b != 0){
            long temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}