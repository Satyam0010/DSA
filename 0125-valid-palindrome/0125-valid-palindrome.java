class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        int n = s.length();
        String fs = "", rs = "";
        for(int i = 0 ; i < n;i++){
            char c = s.charAt(i);
            if((c>64&&c<91)||(c>96&&c<122)||(c>47&&c<58)){
                fs += c;
            }
        }
        for(int i = n-1 ; i >= 0;i--){
            char c = s.charAt(i);
            if((c>64&&c<91)||(c>96&&c<122)||(c>47&&c<58)){
                rs += c;
            }
        }
        int nn = fs.length();
        for(int j = 0;j < nn ;j++){
            if(fs.charAt(j) != rs.charAt(j)){
            return false;
        }
        }
        return true;
    }
}