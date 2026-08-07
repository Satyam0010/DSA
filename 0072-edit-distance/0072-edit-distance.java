class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1 == 0 && l2 == 0) return 0;
        int[][] memo = new int[l1+1][l2+1];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return check(word1,word2,l1,l2,memo);
        
    }
    private int check(String s1, String s2, int n1, int n2,int[][] memo){
        if(n1 == 0) return n2;
        if(n2 == 0) return n1;
        if(memo[n1][n2] != -1) return memo[n1][n2];
        if(s1.charAt(n1-1) == s2.charAt(n2-1)) return memo[n1][n2] = check(s1,s2,n1-1,n2-1,memo);
        return memo[n1][n2] = 1 + Math.min(check(s1,s2,n1,n2-1,memo),Math.min(check(s1,s2,n1-1,n2,memo),check(s1,s2,n1-1,n2-1,memo)));
    }
}