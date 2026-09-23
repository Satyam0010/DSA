class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int targetSum = totalSum - x;

        if (targetSum < 0) {
            return -1;
        }
        
        if (targetSum == 0) {
            return nums.length;
        }

        int maxLength = -1;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > targetSum && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == targetSum) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}
