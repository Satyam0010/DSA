class Solution {
    public int digitFrequencyScore(int n) {
        int[] num = new int[10];
        while(n > 0){
            int d = n%10;
            num[d]++;
            n /= 10;
        }
        int ans = 0;
        for(int i = 0 ; i < num.length;i++){
            if(num[i] != 0) ans += i*num[i];
        }
        return ans;
    }
}