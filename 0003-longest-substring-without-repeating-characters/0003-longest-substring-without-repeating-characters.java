class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int ans = 0;
        int left = 0;
        int[] ch = new int[128];
        Arrays.fill(ch,-1);
        for(int right =  0; right < s.length();right++){
            int c = s.charAt(right);
            if(ch[c] >= left) left = ch[c]+1;
            ch[c] = right;
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}