class Solution {
    public int subtractProductAndSum(int n) {
        long pro = 1;
        long sum = 0;
        while(n>0){
            int d = n%10;
            pro *= d;
            sum += d;
            n /= 10;
        }
        return (int)(pro-sum);
    }
}