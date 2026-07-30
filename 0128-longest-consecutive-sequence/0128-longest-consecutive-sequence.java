class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < len;i++){
            set.add(nums[i]);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int curr = num;
                int currstreak = 1;
            
            while(set.contains(num+1)){
                num++;
                currstreak++;
            }
            ans = Math.max(ans,currstreak);
            }

        }
        return ans;
    }
}