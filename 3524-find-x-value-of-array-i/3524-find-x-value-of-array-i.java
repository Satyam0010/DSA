class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        for(int num : nums){
            long[] next = new long[k];
            int mod = num%k;
            next[mod] = 1;
            for(int i = 0; i < k ; i++){
                if(dp[i] > 0){
                    int nextMod = (int)((1L*i*mod)%k);
                    next[nextMod] += dp[i];
                }
            }
            for(int i = 0; i < k; i++){
                result[i] += next[i];
            }
            dp = next;
        }
        return result;
    }
}