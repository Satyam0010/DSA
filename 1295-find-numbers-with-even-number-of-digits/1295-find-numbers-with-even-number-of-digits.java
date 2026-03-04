class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length;i++){
            int num = nums[i];
            int count = 0;
            while(num>0){
                count++;
                num /= 10;
            }
            if(count%2 == 0)
            total++;
        }
        return total;
    }
}