class Solution {
    String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry=0;
        StringBuilder result = new StringBuilder();
        while(i>=0 || j>=0 || carry != 0){
            int bitA = (i >= 0)? (a.charAt(i)-'0'):0;
            int bitB = (j >= 0)? (b.charAt(j)-'0'):0;
            int sum = bitA + bitB + carry;
            carry = sum/2;
            result.append(sum % 2);
            i--;
            j--;
        }
        result.reverse().toString();
        return result.toString();
    }
};