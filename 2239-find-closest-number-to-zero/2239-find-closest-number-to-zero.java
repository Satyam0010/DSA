class Solution {
    public int findClosestNumber(int[] nums) {
        int finalnum = Integer.MAX_VALUE;
        int finaldis = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++){
            int dis = Math.abs(nums[i]);
            if(dis < finaldis){
                finaldis = dis;
                finalnum = nums[i];
            }
            else if(dis == finaldis){
                finalnum = Math.max(finalnum,nums[i]);
            }
        } return finalnum;
    }
}