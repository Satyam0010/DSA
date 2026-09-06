class Solution {
    public String longestPrefix(String s) {
        int l = s.length();
        int arr[] = new int[l];
        int j = 0;
        for(int i = 1; i < l;i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)) j = arr[j-1];
            if(s.charAt(i) == s.charAt(j)) j++;
            arr[i] = j;
        }
        return s.substring(0,arr[l-1]);
    }
}