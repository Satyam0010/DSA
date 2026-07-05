class Solution {

    Set<Integer> valid = Set.of(2,5,6,9);
    Set<Integer> invalid = Set.of(3,4,7);

    public int rotatedDigits(int n) {
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(check(i)) count++;
        }
        return count;
    }
    
    private boolean check(int num){
        boolean ans = false;
        while(num > 0){
            int digit = num%10;
            if(invalid.contains(digit)) return false;
            if(valid.contains(digit)) ans = true;
            num /= 10;
        }
        return ans;
    }
}