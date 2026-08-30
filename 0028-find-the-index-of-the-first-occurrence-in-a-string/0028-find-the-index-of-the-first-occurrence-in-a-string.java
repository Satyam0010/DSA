class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0,j=0,l1 = haystack.length(),l2 = needle.length();
        while(j<l1){
            if(haystack.charAt(j) == needle.charAt(i)){
                i++;
                if(i == l2) return j-i+1;
            }else{
                    j = j-i;
                    i = 0;
                }
            j++;
        }
        return -1;
    }
}