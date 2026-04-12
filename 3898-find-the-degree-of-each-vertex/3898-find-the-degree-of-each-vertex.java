class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] sum = new int[n];
        for(int i = 0; i < n; i++){
            int edge = 0;
            for(int j = 0; j < n;j++){
                if(matrix[i][j] == 1)
                    edge++;
            }
            sum[i] = edge;
        }
        return sum;
    }
}