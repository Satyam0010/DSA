class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length(), ans = 0, start = 0;
        for(int right = k-1 ; right < n;right++){
            for(int length = k ; length <= right - start + 1; length++){
                int left = right - length + 1;
                if(check(s,left,right)){
                    ans++;
                    start = right + 1;
                    break;
                }
            }
        }
        return ans;
    }

    private boolean check(String s,int left,int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}