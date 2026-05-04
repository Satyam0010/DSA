class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max = 0;
        for(int fre : map.values()){
            max = Math.max(max,fre);
        }
        int count = 0;
        for(int f : map.values()){
            if(f == max){
                count++;
            }
        }
        return count*max;
    }
}