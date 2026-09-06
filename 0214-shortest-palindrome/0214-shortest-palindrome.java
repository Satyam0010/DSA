class Solution {
    public String shortestPalindrome(String s) {
        int l = s.length();
        int i = 0;
        for(int j = 0; j < l;j++){
            if(s.charAt(i) == s.charAt(l-1-j)) i++;
        }
        if(i == l) return s;
        String left = s.substring(i);
        String reverse = new StringBuilder(left).reverse().toString();
        return reverse + shortestPalindrome(s.substring(0,i)) + left;
    }
}