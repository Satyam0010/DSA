class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;


        for(int num : nums){
            int sum = 0;
            int count = 0;

            for(int i = 1; i*i <= num; i++){
                if(num%i==0){
                    int num1 = i;
                    int num2 = num/i;

                    if(num1 == num2){
                        count++;
                        sum += num1;
                    } else {
                        count = count +2;
                        sum = sum + num1 + num2;
                    }
                if(count > 4) break;
                }
            }
            if(count==4)
            total += sum;
        }
        return total;
    }
}