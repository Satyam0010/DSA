class Solution {
    public String customSortString(String order, String s) {
        int[] ch = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            ch[c-'a']++;
        }
        for(char c : order.toCharArray()){
            while(ch[c-'a'] > 0) {
                sb.append(c);
                ch[c-'a']--;
            }
        }
        for(int i = 0; i < 26;i++){
            while(ch[i] > 0){
                sb.append((char)(i+'a'));
                ch[i]--;
            }
        }
        return sb.toString();
    }
}