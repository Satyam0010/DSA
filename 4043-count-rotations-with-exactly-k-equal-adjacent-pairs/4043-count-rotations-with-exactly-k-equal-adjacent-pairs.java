class Solution {
    public int countRotations(String s, int k) {
        String s2 = s+s;
        int l = s.length();
        int ans = 0;
         for(int i = 0; i < l;i++){
            int temp = 0;
            for(int j = 0; j < l-1;j++){
                if(s2.charAt(i+j) == s2.charAt(i+j+1)) temp++;
            }
            if(temp == k) ans++;
         }
         return ans;
    }
}