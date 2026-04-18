class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int[] ans = new int[n];
        lmax[0] = nums[0];
        rmax[n-1] = nums[n-1];
        for(int j = 1; j < n ; j++) lmax[j] = lmax[j-1]*nums[j];
        for(int j = n-2;j > -1 ; j--) rmax[j] = rmax[j+1]*nums[j];

        for(int i = 0; i < n ; i++){
            if(i == 0) ans[0] = rmax[1];
            else if(i == n-1) ans[n-1] = lmax[n-2];
            else {
                ans[i] = lmax[i-1]*rmax[i+1];
            }
        } return ans;
    }
}