class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int len = s.length();
        int[] ch = new int[26];
        for (char c : s.toCharArray()) {
            ch[c - 'a']++;
        }
        int oddNum = 0;
        char mid = 0;
        for(int i = 0; i < ch.length;i++){
            if(ch[i]%2 == 1){
                mid = (char)(i+97);
                oddNum++;
            }
        }
        if(oddNum > 1) return "";
        for(int i = 0; i < 26;i++){
            ch[i] /= 2;
        }
        int newLength = len/2;

        char[] left = new char[newLength];

        if(buildleft(0,false,target,ch,left,mid,len)){
            String leftPart = new String(left);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            String palin = leftPart;
            if(len%2 == 1) palin += mid;
            palin += rightPart;
            return palin;
        }
        return "";
    }

    private boolean buildleft(int curr,boolean agtt,String target,int[] ch, char[] left,char mid,int len){
        if(curr == left.length){
            String leftPart = new String(left);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            String palin = leftPart;
            if(len%2 == 1) palin += mid;
            palin += rightPart;
            return palin.compareTo(target) > 0;
        }
        char firstCharToTry;
        if(agtt){
            firstCharToTry = 'a';
        } else {
            firstCharToTry = target.charAt(curr);
        }
        for(char cc = firstCharToTry; cc <= 'z';cc++){
            int cindex = cc-'a';
            if(ch[cindex] == 0) continue;
            left[curr] = cc;
            ch[cindex]--;
            boolean ngtt = agtt || cc > target.charAt(curr);
            if(buildleft(curr+1,ngtt,target,ch,left,mid,len)) return true;
            ch[cindex]++;
        }
        return false;
    }

}