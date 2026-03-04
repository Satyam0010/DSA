class Solution {
    public int primePalindrome(int n) {

        // handle small cases
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;

        int num, count, revnum, sum, nn;

        for (int x = 1; x < 100000; x++) {

            num = x;
            nn = x / 10;
            while (nn > 0) {
                num = num * 10 + (nn % 10);
                nn /= 10;
            }

            if (num < n) continue;

            count = 0;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    count = 1;
                    break;
                }
            }
            if (count == 0)
                return num;
        }
        return -1;
    }
}