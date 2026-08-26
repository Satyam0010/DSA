class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n;i++){
            int[] ch = new int[26];
            for(int j = i;j < n;j++){
                ch[s.charAt(j)-'a']++;
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int num : ch){
                if(num > 0){
                max = Math.max(num,max);
                min = Math.min(num,min);
                }  
            }
            ans += (max-min);
        }
        }
        return ans;
    }
}