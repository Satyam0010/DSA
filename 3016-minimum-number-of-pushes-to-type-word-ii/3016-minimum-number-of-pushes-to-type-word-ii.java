class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        int[] ch = new int[26];
        for(char c : word.toCharArray()){
            ch[c-'a']++;
        }
        
        Arrays.sort(ch);

        int ans = 0;
        int position = 0;
        
        for(int i = 25; i > -1;i--){
            int push = (position/8)+1;
            ans += ch[i]*push;
            position++;
        }
        return ans;
    }
}