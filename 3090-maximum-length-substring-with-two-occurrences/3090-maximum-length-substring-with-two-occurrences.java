class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int max = 0;
        int[] ch = new int[26];
        for(int i = 0; i < s.length();i++){
            ch[s.charAt(i)-'a']++;
            while(ch[s.charAt(i)-'a'] > 2){
                ch[s.charAt(left)-'a']--;
                left++;
            }
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}