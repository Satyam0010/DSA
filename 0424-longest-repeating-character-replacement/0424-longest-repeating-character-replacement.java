class Solution {
    public int characterReplacement(String s, int k) {
        int[] ch = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;
        for(int right = 0; right < s.length();right++){
            ch[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,ch[s.charAt(right)-'A']);
            int window = right-left+1;
            if(window-maxFreq > k){
                ch[s.charAt(left)-'A']--;
                left++;
            }
            window = right-left+1;
            maxWindow = Math.max(maxWindow,window);
        }
        return maxWindow;
    }
}