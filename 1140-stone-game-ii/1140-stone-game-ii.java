class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] suffix = new int[len+1];
        for(int i = len-1; i >=0;i--){
            suffix[i] = suffix[i+1]+piles[i];
        }
        int[][] memo = new int[len][len+1];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return check(0,1,suffix,piles,memo);
    }
    private int check(int index,int m,int[] suffix,int[] piles,int[][] memo){
        if(index >= piles.length) return 0;
        if(index+2*m >= piles.length) return suffix[index];
        if(memo[index][m] != -1) return memo[index][m];
        int max = 0;
        for(int x = 1; x <= 2*m;x++){
            int bob = check(index+x,Math.max(m,x),suffix,piles,memo);
            int curr = suffix[index]-bob;
            max = Math.max(curr,max);
        }
        return memo[index][m] = max;
    }
}