class Solution {
    public int lengthOfLastWord(String s) {
        int k = 0;
        s = s.trim();
        for(int i = (s.length()-1); i >= 0;i--){
            char c = s.charAt(i);
            if(c == ' ')
                  return k ;
            else if((c>=65&&c<=90)||(c>=97&&c<=122)){
                  k++;
            }
        }
        return k;
    }
}