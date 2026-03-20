class Solution {
    public int countEven(int num) {
        int count = 0;
        int i = 1;
        while(i <= num){
            int sum = 0;
            int temp = i;
            while(temp > 0){
                int d = temp%10;
                sum += d;
                temp /= 10;
            }
            if(sum%2 ==0){
                count++;
            }
            i++;
        }

        return count;
    }
}