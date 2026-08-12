class Solution {
    public int secondHighest(String s) {
        int[] num = new int[10];
        int len = s.length();
        for(int i = 0; i < len;i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                num[ch-'0'] = 1;
            }
        }
        int count = 0;
        for(int i = 9 ; i >= 0; i--){
            if(num[i] == 1){
                if(count == 0) count = 1;
                else if(count == 1) return i;
            }
        }
        return -1;
    }
}