class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int num = n;
            int pro = 1;
            while(num > 0){
                int d = num%10;
                pro *= d;
                num /= 10;
            }
            if(pro % t == 0) return n;
            n++;
        }
    }
}