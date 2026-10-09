class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int n = s.length();
        int open = 0;
        for(int i = 0; i < n;i++){
            if(s.charAt(i) == '(') open++;
            else{
                if(i+1 < n && s.charAt(i+1) == ')') i++;
                else ans += 1;
                if(open > 0) open--;
                else ans += 1;
            }
        }
        ans += open*2;
        return ans;
    }
}