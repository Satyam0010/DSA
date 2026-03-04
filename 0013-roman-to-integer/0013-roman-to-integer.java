class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int sum=0;
        int prevalue = 0;
        for(int i = n-1 ; i >= 0;i--){
            int value = 0;
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                     value = 1;
                     break;
                case 'V':
                     value = 5;
                     break;
                case 'X':
                     value = 10;
                     break;
                case 'L':
                     value = 50;
                     break;
                case 'C':
                     value = 100;
                     break;
                case 'D':
                     value = 500;
                     break;
                case 'M':
                     value = 1000;
                     break;
                default:
                     value = 0;
                     break;
                     }
                if(value < prevalue)
                sum -= value;
                else
                sum += value;

                prevalue = value;
        }
        return sum;
    }
}