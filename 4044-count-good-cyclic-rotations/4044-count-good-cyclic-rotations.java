class Solution {
    public int countGoodRotations(int[] nums) {
        int l = nums.length;
        int part = l/2;
        long sum1 = 0;
        long sum2 = 0;
        int ans = 0;
        for(int i = 0 ; i < part;i++){
            sum1 += nums[i];
        }
        for(int i = part; i < 2*part;i++ ){
            sum2 += nums[i%l];
        }
        if(sum1 > sum2) ans++;
        for(int i = 1; i < l;i++){
            sum1 = sum1 - nums[i-1] + nums[(i + part - 1)%l];
            sum2 = sum2 - nums[(i + part - 1)%l] + nums[(i + 2*part - 1)%l];
            if(sum1 > sum2) ans++;
        }
        return ans;
    }
}