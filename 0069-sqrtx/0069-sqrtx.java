class Solution {
    public int mySqrt(int x) {
        double n = x, y =1.0,e=0.0000001;
        while(n-y>e){
            n=(n+y)/2;
            y=x/n;
        }
        return (int)n;
    }
}