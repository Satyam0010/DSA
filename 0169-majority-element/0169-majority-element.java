class Solution {
    public int majorityElement(int[] nums) {
        int maxcount = 0;
        int maxele = 0;
        for(int i = 0; i < nums.length;i++){
            if(maxcount == 0){
                maxele = nums[i];
                maxcount = 1;
            } else if(nums[i] ==  maxele){
                maxcount++;
            } else{
                maxcount--;
            }
        }
        return maxele;
    }
}