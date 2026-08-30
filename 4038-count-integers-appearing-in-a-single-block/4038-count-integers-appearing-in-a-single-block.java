class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashSet<Integer> seenBefore = new HashSet<>();
        HashSet<Integer> reject = new HashSet<>();
        for(int i = 0; i < nums.length;i++){
            if(reject.contains(nums[i])) continue;
            if(seenBefore.contains(nums[i]) && nums[i-1] != nums[i]) reject.add(nums[i]);
            else seenBefore.add(nums[i]);
        }
        return seenBefore.size()-reject.size();
    }
}