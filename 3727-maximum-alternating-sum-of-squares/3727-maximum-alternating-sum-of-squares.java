class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long lowSum = 0;
        for(int i = 0; i < n/2;i++){
            lowSum += (nums[i]*nums[i]);
        }
        int i = n/2;
        long highSum = 0;
        while(i < n){
            highSum += (nums[i]*nums[i]);
            i++;
        }
        return highSum - lowSum;
    }
}