class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer>[] list = new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            int num = entry.getKey();
            if(list[freq] == null) list[freq] = new ArrayList<>();
            list[freq].add(num);
        }
        int[] ans = new int[k];
        int index = 0;

        for(int i = nums.length; i >= 1 && index < k; i--){

            if(list[i] == null) continue;

               for(int num : list[i]){
                ans[index++] = num;

               if(index == k)
                  break;
                 }
        }
        return ans;
    }
}