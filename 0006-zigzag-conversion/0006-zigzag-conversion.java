class Solution {
    public String convert(String s, int numRows) {
        String[] ss = new String[numRows];
        for(int i = 0; i < numRows;i++){
            ss[i] = "";
        }
        int i = 0;
        while(i < s.length()){
            for(int index = 0; index < numRows && i < s.length();index++){
                ss[index] += s.charAt(i++);
            }
            for(int index = numRows-2;index > 0 && i < s.length();index--){
                ss[index] += s.charAt(i++);
            }
        }
        String result = "";
        for(String st : ss){
            result += st;
        }
        return result;
    }
}