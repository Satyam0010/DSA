class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1) return 1;
        if(nums.length == 2) return 2;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int low = 0,high = 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] < min){
                low = i;
                min = nums[i];
            }
            if(nums[i] > max){
                high = i;
                max = nums[i];
            }
        }
        int ans = 0;
        if(low < high){
            int scenario1 = 1 + high;
            int scenario2 = nums.length-low;
            int scenario3 = 1 + low + (nums.length-high);
            return Math.min(scenario1,Math.min(scenario2,scenario3));
        } else {
            int scenario1 = 1 + low;
            int scenario2 = nums.length-high;
            int scenario3 = 1 + high + (nums.length-low);
            return Math.min(scenario1,Math.min(scenario2,scenario3));
        }
    }
}