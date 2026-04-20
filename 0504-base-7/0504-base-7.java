class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuilder s = new StringBuilder();
        boolean neg = num < 0;
        num = Math.abs(num);
        while(num >= 7){
            int d = num%7;
            s.append(d+"");
            num /= 7;
        }
        s.append(num+"");
        if(neg) s.append("-");
        return s.reverse().toString();
    }
}