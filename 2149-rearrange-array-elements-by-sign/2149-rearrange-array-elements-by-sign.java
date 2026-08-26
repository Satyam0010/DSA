class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] positive = new int[n/2];
        int[] negative = new int[n/2];
        int i = 0,j = 0;
        for(int num : nums){
            if(num > 0) positive[i++] = num;
            else negative[j++] = num;
        }
        i = 0;
        j = 0;
        for(int k = 0; k < n;k++){
            if(k%2 == 0) nums[k] = positive[i++];
            else nums[k] = negative[j++];
        }
        return nums;
    }
}