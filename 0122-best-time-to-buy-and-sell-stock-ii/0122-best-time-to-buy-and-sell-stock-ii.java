class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l-1;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] > prices[i+1]){
                ans += prices[i] - min;
                min = prices[i];
            }
            if(i == l-2 && (min < prices[l-1]))
            ans += prices[l-1] - min;
        }
        return ans;
    }
}