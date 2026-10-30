class Solution {
    class Node {
        int eff, row, col;

        Node(int eff, int row, int col) {
            this.eff = eff;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int totalRow = heights.length;
        int totalCol = heights[0].length;
        int[][] efforts = new int[totalRow][totalCol];
        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.eff));
        q.offer(new Node(0, 0, 0));
        int[] rd = { -1, 0, 1, 0 };
        int[] cd = { 0, -1, 0, 1 };
        while (!q.isEmpty()) {
            Node current = q.poll();
            int currEffort = current.eff;
            int currRow = current.row;
            int currCol = current.col;
            if (currRow == totalRow - 1 && currCol == totalCol - 1)
                return currEffort;
            if (currEffort > efforts[currRow][currCol])
                continue;
            for (int i = 0; i < 4; i++) {
                int newRow = currRow + rd[i];
                int newCol = currCol + cd[i];
                if (newRow >= 0 && newRow < totalRow && newCol >= 0 && newCol < totalCol) {
                    int nextEff = Math.max(currEffort, Math.abs(heights[newRow][newCol] - heights[currRow][currCol]));
                    if (nextEff < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = nextEff;
                        q.offer(new Node(nextEff, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }
}