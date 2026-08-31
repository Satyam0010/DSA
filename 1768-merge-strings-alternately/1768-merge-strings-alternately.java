class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0,j = 0,l1 = word1.length(),l2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int min = (l1 < l2) ? l1 : l2;
        for(; i < min;i++,j++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
        }
        while(i < l1){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < l2){
            sb.append(word2.charAt(j));
            j++;
        }
        return new String(sb);
    }
}