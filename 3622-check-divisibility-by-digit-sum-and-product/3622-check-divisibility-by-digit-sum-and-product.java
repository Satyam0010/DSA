class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int num = n;
        while(n > 0){
            int d = n%10;
            sum += d;
            pro *= d;
            n /= 10;
        }
        if(num%(sum+pro) == 0) return true;
        return false;
    }
}