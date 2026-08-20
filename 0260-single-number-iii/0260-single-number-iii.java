class Solution {
    public int[] singleNumber(int[] nums) {
        int x = nums[0];
        for(int i = 1; i < nums.length;i++){
            x ^= nums[i];
        }
        int k = x & (~(x-1));
        int result1 = 0;
        int result2 = 0;
        for(int num : nums){
            if((num & k) != 0) result1 ^= num;
            else result2 ^= num;
        }
        return new int[]{result1,result2};
    }
}