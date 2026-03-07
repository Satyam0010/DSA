class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        int i = 0;
        int j = 0;

        while(j < l1){
            

            if(haystack.charAt(j) == needle.charAt(i)){
                i++;

                if(i == needle.length()){
                int ans = j - i + 1;
                return ans;
            }
            }else{
              j = j - i;
              i = 0;
            }

            j++;
        }
        return -1;
    }
}