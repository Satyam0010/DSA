class Solution {
    public int change(int amount, int[] coins) {
        // int[][] memo = new int[coins.length+1][amount+1];
        // for(int row[]: memo){
        //     Arrays.fill(row,-1);
        // }
        
        // return check(coins,amount,coins.length,memo);
        return checkTab(amount,coins);
    }
    // private int check(int[] coins,int sum,int n,int[][] memo){
    //     if(sum == 0) return 1;
    //     if(sum < 0) return 0;
    //     if(n == 0 && sum > 0) return 0;
    //     if(memo[n][sum] != -1) return memo[n][sum];
    //     return memo[n][sum] = check(coins,sum,n-1,memo)+check(coins,sum-coins[n-1],n,memo);
    // }

    private int checkTab(int amount, int[] coins){
        int n = coins.length;
        int[][] tab = new int[n+1][amount+1];
        for(int i = 0; i <= n;i++){
            tab[i][0] = 1;
        }
        for(int i = 1; i <= n;i++){
            for(int j = 1; j <= amount;j++){
                int exclude = tab[i-1][j];
                int include = 0;
                if (coins[i - 1] <= j) {
                include = tab[i][j - coins[i - 1]]; 
                }
                tab[i][j] = exclude+include;
            }
        }
        return tab[n][amount];
    }
}