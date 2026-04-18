class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] psum = new int[nums.length];
        psum[0] = nums[0];

        for(int i = 1; i < nums.length;i++){
            psum[i] = psum[i-1]+nums[i];
        } 
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int j = 0; j < nums.length;j++){

            int val = psum[j]-k;

            if(map.containsKey(val)) count += map.get(val);
            
            map.put(psum[j],map.getOrDefault(psum[j],0)+1);
        } return count;
    }
}