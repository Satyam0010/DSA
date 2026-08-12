class Solution {
    public int maxDistinct(String s) {
        int[] ch = new int[26];
        for(char c : s.toCharArray()){
            ch[c-'a']++;
        }
        int ans = 0;
        for(int num : ch){
            if(num != 0) ans++;
        }
        return ans;
    }
}