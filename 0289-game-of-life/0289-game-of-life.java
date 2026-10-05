class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            int zeroes = 0, ones = 0;
            for (int j = 0; j < n; j++) {
                int digit = board[i][j];
                if (i - 1 >= 0) {
                    if (j - 1 >= 0) {
                        if (board[i - 1][j - 1] == 0)
                            zeroes++;
                        else
                            ones++;
                    }
                    if (board[i - 1][j] == 0)
                        zeroes++;
                    else
                        ones++;
                    if (j + 1 < n) {
                        if (board[i - 1][j + 1] == 0)
                            zeroes++;
                        else
                            ones++;
                    }
                }
                if (j - 1 >= 0) {
                    if (board[i][j - 1] == 0)
                        zeroes++;
                    else
                        ones++;
                }
                if (j + 1 < n) {
                    if (board[i][j + 1] == 0)
                        zeroes++;
                    else
                        ones++;
                }
                if (i + 1 < m) {
                    if (j - 1 >= 0) {
                        if (board[i + 1][j - 1] == 0)
                            zeroes++;
                        else
                            ones++;
                    }
                    if (board[i + 1][j] == 0)
                        zeroes++;
                    else
                        ones++;
                    if (j + 1 < n) {
                        if (board[i + 1][j + 1] == 0)
                            zeroes++;
                        else
                            ones++;
                    }
                }

                if (digit == 1) {
                    if (ones < 2)
                        ans[index++] = 0;
                    else if (ones == 2 || ones == 3)
                        ans[index++] = 1;
                    else
                        ans[index++] = 0;
                } else {
                    if (ones == 3)
                        ans[index++] = 1;
                    else
                        index++;
                }
                zeroes = 0;
                ones = 0;
            }
        }
        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ans[index++];
            }
        }
    }
}