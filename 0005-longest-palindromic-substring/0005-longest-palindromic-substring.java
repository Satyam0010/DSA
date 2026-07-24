class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        if(l <= 1) return s; 
        int start = 0; 
        int end = 1; 
        int max = 0; 
        int len = 0; 
        String m = "";
        for(int i = 0; i< l; i++){ 
            for(int j = i;j < l;j++){ 
                int cur = j-i+1; 
                if(cur > max){ 
                    if(check(s,i,j)){ 
                        max = cur; 
                        m = s.substring(i,j+1);
                        } 
                        } 
                        } 
                        } 
                        return m; 
                        } 
        private boolean check(String s,int start,int end){ 
            while(start < end){ 
                if(s.charAt(start) != s.charAt(end)) return false;
                 start++; 
                 end--; 
                 }
                  return true;
    }
}