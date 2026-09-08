class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0 ; i < nums.length;i++){
            nums[i] %= 2;
        }
        return check(nums,k)-check(nums,k-1);
    }
    private int check(int[] nums,int k){
        if(k < 0) return 0;
        int sum = 0, j = 0,ans = 0;
        for(int i = 0; i < nums.length;i++){
            sum += nums[i];
            while(sum > k){
                sum -= nums[j];
                j++;
            }
            ans += i - j + 1;
        }
        return ans;
    }
}