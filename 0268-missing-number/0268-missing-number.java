class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = 0,sum2=0;
        for(int i = 0;i<=n;i++){
            sum1 += i;
        }
        for(int j = 0;j<n;j++){
            sum2 += nums[j];
        }
        return sum1 - sum2;
    }
}