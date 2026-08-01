class Solution {
    public long perfectPairs(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int left = 0;
        long ans = 0;
        for(int right = 0; right < len ;right++){
            while(nums[right] > 2L* nums[left]) left++;
            ans += right-left;
        }
        return ans;
    }
}