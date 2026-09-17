class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length , sum = 0, ans = Integer.MAX_VALUE, currBest = Integer.MAX_VALUE;
        int[] b = new int[n];
        Arrays.fill(b,Integer.MAX_VALUE);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0 ; i < n; i++){
            sum += arr[i];
            if(map.containsKey(sum-target)){
                int j = map.get(sum - target);
                int l = i - j;
                if(j >= 0 && b[j] != Integer.MAX_VALUE){
                    ans = Math.min(ans,l+b[j]);
                }
                currBest = Math.min(currBest,l);
            }
            b[i]=currBest;
            map.put(sum,i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}