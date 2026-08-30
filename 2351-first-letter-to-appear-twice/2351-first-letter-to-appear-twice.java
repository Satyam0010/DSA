class Solution {
    public char repeatedCharacter(String s) {
        int[] ch = new int[26];
        for(char c : s.toCharArray()){
            if(ch[c-'a'] != 0) return c;
            ch[c - 'a']++;
        }
        return '\0';
    }
}