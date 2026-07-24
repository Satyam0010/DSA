class Solution {
    public int longestPalindrome(String s) {
        int[] ch = new int[128];
        for(char c : s.toCharArray()){
            ch[c]++;
        }
        int len = 0;
        boolean oddelement = false;
        for(int n : ch){
            if(n%2 == 0) len += n;
            else{
                len += n-1;
                oddelement = true;
            }
        }
        return oddelement ? len+1 : len ;
    }
}