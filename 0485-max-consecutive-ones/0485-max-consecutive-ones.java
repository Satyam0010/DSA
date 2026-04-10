class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int pre = 0;
        int max = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 1){
                pre++;
            } else {
                max = Math.max(max,pre);
                 pre = 0;
            }
            
        }
        max = Math.max(max,pre);
        return max;
    }
}