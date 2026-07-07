class Solution {
    public boolean isGoodArray(int[] nums) {
        int g = nums[0];
        for(int num : nums){
            g = gcd(g,num);
            if(g == 1) return true;
        }
        return false;
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}