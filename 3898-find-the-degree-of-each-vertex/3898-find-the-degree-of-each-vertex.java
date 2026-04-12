class Solution {
    public int[] findDegrees(int[][] matrix) {
        int[] sum = new int[matrix.length];
        int edge;
        for(int i = 0; i < matrix.length; i++){
            edge = 0;
            for(int j = 0; j < matrix.length;j++){
                if(matrix[i][j] == 1){
                    edge++;
                }
            }
            sum[i] = edge;
        }
        return sum;
    }
}