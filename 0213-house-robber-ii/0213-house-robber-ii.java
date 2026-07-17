class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 1) return nums[0];
        int[] num1 = new int[l-1];
        int[] num2 = new int[l-1];
        for(int i = 0; i < l-1;i++){
            num1[i] = nums[i+1];
            num2[i] = nums[i];
        }
        return Math.max(check(num1),check(num2));
    }

    private int check(int[] nums){
        int l = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i < l; i++){
            int take = nums[i];
            if(i > 1) take += prev2;
            int nottake = 0+prev;
            int curr = Math.max(take,nottake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}