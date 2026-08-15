class Solution {
    public int longestSubsequence(int[] nums) {
        int len = nums.length;
        int sum = 0;
        boolean nonZero = false;
        for(int num : nums){
            sum ^= num;
            nonZero |= num>0;
        }
        if(sum > 0) return len;
        if(nonZero) return len-1;
        return 0;
    }
}