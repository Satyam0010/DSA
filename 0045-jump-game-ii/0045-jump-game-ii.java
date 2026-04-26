class Solution {
    public int jump(int[] nums) {
        int jump = 0, l=0, r=0, n = nums.length;
        while(r < n-1){
            int far = 0;
            for(int i = l ; i <= r ; i++){
                far = Math.max(far,nums[i]+i);
            }
            l = r + 1;
            r = far; 
            jump++;
        }
        return jump;
    }
}