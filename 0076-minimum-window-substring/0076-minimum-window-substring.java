class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";
        int[] ch = new int[128];
        for(char c : t.toCharArray()){
            ch[c]++;
        }
        int left = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;
        int count = t.length();
        for(int right = 0; right < s.length();right++){
            char rightChar = s.charAt(right);
            if(ch[rightChar] > 0) count--;
            ch[rightChar]--;
            while(count == 0){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                ch[leftChar]++;
                if(ch[leftChar] > 0) count++;
                left++;
            }
        }
        return ( minLength == Integer.MAX_VALUE ) ? "" : s.substring(minLeft,minLeft+minLength);
    }
}