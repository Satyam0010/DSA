class Solution {
    public boolean validDigit(int n, int x) {
        int temp = n;
        boolean found = false;

        do {
            int d = temp % 10;
            if (d == x) found = true;
            temp /= 10;
        } while (temp > 0);

        int first = n;
        while (first >= 10) {
            first /= 10;
        }

        return found && first != x;
    }
}