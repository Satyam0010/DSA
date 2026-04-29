class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int z = i;
            while(i < s.length() && s.charAt(i)!=' ') i++;
        
        for(int j = i-1 ; j >= z ; j--){
            char ch = s.charAt(j);
            ans.append(ch);
        }
        if(i < s.length()) ans.append(" ");
        i++;
        }
        
        return ans.toString();
    }
}