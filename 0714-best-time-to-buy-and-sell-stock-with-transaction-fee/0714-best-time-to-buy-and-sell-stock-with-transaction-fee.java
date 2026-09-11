class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int profit = 0;
        int ebuyprice = prices[0];
        for(int i = 1; i < n;i++){
            profit = Math.max(profit,prices[i] - ebuyprice - fee);
            ebuyprice = Math.min(ebuyprice,prices[i]-profit);
        }
        return profit;
    }
}