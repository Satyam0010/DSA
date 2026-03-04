class Solution {
    public double myPow(double x, int n) {
        long N = n;
        double result = 1.0;
        if(N<0){
            N = -N;
            x = 1/x;
        }
        while(N>0){
            if((N & 1)==1){
                result *= x;
            }
            x *= x;
            N >>= 1 ;
        }
        return result;
    }
}