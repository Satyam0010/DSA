class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        Arrays.sort(nums);
        int gap = nums[1]-nums[0];
        for(int i = 2; i < n;i++){
            gap = Math.max(gap,Math.abs(nums[i]-nums[i-1]));
        }
        return gap;
    }
}