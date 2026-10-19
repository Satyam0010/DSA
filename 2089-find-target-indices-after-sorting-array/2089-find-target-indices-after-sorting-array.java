class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int start = 0, count = 0;
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            if(num == target) count++;
            else if(num < target) start++;
        }
        for(int i = start; i < start+count ; i++){
            ans.add(i);
        }
        return ans;
    }
}