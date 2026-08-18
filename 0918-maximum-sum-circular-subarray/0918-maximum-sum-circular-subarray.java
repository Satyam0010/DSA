class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int superMax = Integer.MIN_VALUE;
        int max = 0;
        int superMin = Integer.MAX_VALUE;
        int min = 0;
        for(int x : nums){
            total += x;
            max = Math.max(x,max+x);
            superMax = Math.max(superMax,max);
            min = Math.min(x,min+x);
            superMin = Math.min(superMin,min);
        }
        if(superMax < 0) return superMax;
        return Math.max(superMax,total-superMin);
    }
}