class Solution {
    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        TreeSet<Integer> set = new TreeSet<>();
        int temp = length , j = 0;
        while(temp > 0){
            for(int i = 0; i < length ; i++){
                if(nums[i] == -1 || set.contains(nums[i])) continue;
                else{
                    set.add(nums[i]);
                    nums[i] = -1;
                }
            }
            while(!set.isEmpty()){
                temp--;
                ans[j++] = set.pollFirst();
            }
        }
        return ans;
    }
}