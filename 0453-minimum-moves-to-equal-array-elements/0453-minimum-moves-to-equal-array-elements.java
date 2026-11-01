class Solution {
    public int minMoves(int[] nums) {
        int totalSum = 0;
        int min = nums[0];
        for(int num : nums){
            if(num < min) min = num;
            totalSum += num;
        }
        return totalSum - (min*nums.length);
    }
}