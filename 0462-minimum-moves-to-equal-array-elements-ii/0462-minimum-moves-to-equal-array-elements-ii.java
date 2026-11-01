class Solution {
    public int minMoves2(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }
        return ans;
    }
}