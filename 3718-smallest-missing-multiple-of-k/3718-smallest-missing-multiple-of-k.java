class Solution {
    public int missingMultiple(int[] nums, int k) {
        for(int i = 1; i < 101;i++){
            int num = k*i;
            boolean present = false;
            for(int n : nums){
                if(n == num){
                    present = true;
                    break;
                }
            }
            if(!present) return num;
        }
        return 101;
    }
}