class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < num.length(); i++){
             while(ans.length() > 0 && k > 0 && ans.charAt(ans.length() - 1) > num.charAt(i)){
                ans.deleteCharAt(ans.length()-1);
                k--;
            }
            ans.append(num.charAt(i));
        }
        while(k > 0){
            ans.deleteCharAt(ans.length()-1);
            k--;
        }
        int l = 0;
        while (l < ans.length() && ans.charAt(l) == '0'){ l++;}
        String result = ans.substring(l);
        return result.length() == 0 ? "0" : result;
    }
}