class Solution {
    public int findGCD(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(max < num) max = num;
            if(min > num) min = num;
        }
        return check(max,min);
    }

    private int check(int a,int b){
        if(b == 0) return a;
        while(b > 0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}