class Solution {
    int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
       int[] ch = new int[26];
       long ans = 0;
       for(int i = 0; i < s.length();i++){
        int c = s.charAt(i)-'a';
        long n = (ans+1) % MOD;
        ans = (ans + n - ch[c] + MOD) % MOD;
        ch[c] = (int)n;
       } 
       return (int)ans;
    }
}