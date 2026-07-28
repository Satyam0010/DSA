class Solution {
    public String smallestPalindrome(String s) {
        int l = s.length();
        int[] ch = new int[26];
        for(int i = 0; i< l/2;i++){
            int idx = s.charAt(i)-'a';
            ch[idx]++;
        }
        char middle = '\0';
        if(l%2 == 1){
            middle = s.charAt(l/2);
        }
        int inn = 97;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26;i++){
            char c = (char) inn;
            int ii = ch[i];
            while(ii > 0){
                sb.append(c);
                ii--;
            }
            inn++;
        }
        StringBuilder ans = new StringBuilder(sb);
        if(middle != '\0'){
            ans.append(middle);
        }
        ans.append(new StringBuilder(sb.reverse()));
        return ans.toString();
    }
}