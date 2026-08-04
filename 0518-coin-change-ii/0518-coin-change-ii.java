class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo = new int[coins.length+1][amount+1];
        for(int row[]: memo){
            Arrays.fill(row,-1);
        }
        
        return check(coins,amount,coins.length,memo);
    }
    private int check(int[] coins,int sum,int n,int[][] memo){
        if(sum == 0) return 1;
        if(sum < 0) return 0;
        if(n == 0 && sum > 0) return 0;
        if(memo[n][sum] != -1) return memo[n][sum];
        return memo[n][sum] = check(coins,sum,n-1,memo)+check(coins,sum-coins[n-1],n,memo);
    }
}