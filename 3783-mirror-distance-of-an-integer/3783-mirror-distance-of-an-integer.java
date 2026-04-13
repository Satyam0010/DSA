class Solution {
    public int mirrorDistance(int n) {
        int temp = n, rev =0;
        while(temp > 0){
            int d = temp%10;
            rev = (rev*10)+d;
            temp /= 10;
        }
        int dist = Math.abs(n-rev);
        return dist;
    }
}