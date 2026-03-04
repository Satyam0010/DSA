class Solution {
    public boolean hasAlternatingBits(int n) {
        String bin = "";
        int count = 0;
        while(n>0){
            int d = n%2;
            bin = d + bin;
            n /= 2;
        }
        for(int i = 0; i < (bin.length()-1);i++){
            if(bin.charAt(i)==bin.charAt(i+1))
            return false;
        }
        return true;
    }
}