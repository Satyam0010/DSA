class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int l1 = num1.length();
        int l2 = num2.length();
        int[] ans = new int[l1+l2];
        for(int i = l1-1;i>=0;i--){
            for(int j = l2-1;j>=0;j--){
                int m = (num1.charAt(i) - '0') * (num2.charAt(j)-'0');
                int s = m + ans[i+j+1];

                ans[i+j+1] = s%10;
                ans[i+j] += s/10;
            }
        }
        int k = 0;
        while(k < ans.length && ans[k] == 0){
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for(;k<ans.length;k++){
            sb.append(ans[k]);
        }


        return sb.toString();
    }
}