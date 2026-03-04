class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        if(x < 0)
        return false;
        else if (x > 0)
        {
            int xi = x;
            while(xi > 0)
            {
                int d = xi%10;
                sum = (sum*10)+d;
                xi /= 10;
            }
            
            if(x == sum)
            {
                return true;
            }
            else
            return false;
        }
        else
        return true;
    }
}