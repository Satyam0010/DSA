class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            int position = i+1;
            int value = 'z' - c + 1;
            ans += value*position;
        }
        return ans;
    }
}