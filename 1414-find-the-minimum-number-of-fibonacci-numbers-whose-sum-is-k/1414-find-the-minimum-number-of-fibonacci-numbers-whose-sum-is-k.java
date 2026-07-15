class Solution {
    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int prev2 = 0,prev = 1;
        list.add(0);
        list.add(1);
        int curr = 0;
        while(curr <= k){
            curr = prev2 + prev;
            list.add(curr);
            prev2 = prev;
            prev = curr;
        }
        int ans = 0;
        int i = list.size() - 1;
        while(i >= 0){
            if(k == 0) return ans;
            else if(list.get(i) <= k){
                k -= list.get(i);
                ans += 1;
            }
            if(list.get(i) > k) i--;
        }
        return ans;
    }
}