class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while(a > 0 || b > 0 || c > 0){
            int b1 = a & 1;
            int b2 = b & 1;
            int b3 = c & 1;
            if(b3 == 1){
                if(b1 == 0 && b2 == 0) count++;
            } else {
                count += b1 + b2;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}