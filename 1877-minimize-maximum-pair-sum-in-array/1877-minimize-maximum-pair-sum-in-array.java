class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0 , j = nums.length-1;
        int[] max = new int[nums.length/2];
        while(i < j){
            max[i] = nums[i]+nums[j];
            i++;
            j--;
        }
        Arrays.sort(max);
        return max[max.length-1];
    }
}