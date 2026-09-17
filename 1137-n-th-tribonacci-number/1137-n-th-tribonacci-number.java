class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        Integer[] memo = new Integer[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        return check(n,memo);
    }

    private int check(int n,Integer[] memo){
        if(n == 0) return 0;
        if(memo[n] != null) return memo[n];
        return memo[n] = check(n-1,memo) + check(n-2,memo) + check(n-3,memo);
    }
}