class Solution {
    public int maximumWidth(int[] planks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int plank : planks){
            map.put(plank,map.getOrDefault(plank,0)+1);
        }
        List<int[]> keys = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            keys.add(new int[]{e.getKey(),e.getValue()});
        }
        int n = keys.size();
        for(int i = 0; i < n;i++){
            int key1 = keys.get(i)[0];
            int count1 = keys.get(i)[1];
            map.put(2*key1,map.getOrDefault(2*key1,0)+count1/2);
            for(int j = i+1;j < n;j++){
                int key2 = keys.get(j)[0];
                int count2 = keys.get(j)[1];
                int sum = key1+key2;
                map.put(sum,map.getOrDefault(sum,0)+Math.min(count1,count2));
            }
        }
        int max = 0;
        for(int count : map.values()){
            max = Math.max(max,count);
        }
        return max;
    }
}