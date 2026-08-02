class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] b = new boolean[101];
        int not = 100;
        for(int num : nums){
            if(num != 0 && !b[num]){
                not--;
                b[num] = true;
            }
        }
        return 100 - not;
    }
}