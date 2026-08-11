class Solution {
    public int missingInteger(int[] nums) {
        boolean[] check = new boolean[52];
        for(int num : nums){
            check[num] = true;
        }
        int sum = nums[0];
        for(int i = 1; i < nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                sum += nums[i];
            } else break;
        }
        if(sum > 50) return sum;
        for(int i = sum; i <= 52;i++){
            if(!check[i]) return i;
        }
        return 0;
    }
}