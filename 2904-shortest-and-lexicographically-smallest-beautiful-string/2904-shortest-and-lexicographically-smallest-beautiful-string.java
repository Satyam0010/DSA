class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int count = 0;
        String ans = "";
        for(int right = 0; right < n;right++){
            if(s.charAt(right) == '1') count++;
            while(count == k){
                String curr = s.substring(left,right+1);
                if(ans.equals("") || curr.length() < ans.length() || (curr.length() == ans.length() && curr.compareTo(ans) < 0)) ans = curr;
                if(s.charAt(left) == '1') count--;
                left++;
            }
        }
        return ans;
    }
}