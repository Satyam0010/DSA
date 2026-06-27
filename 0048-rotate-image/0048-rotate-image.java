class Solution {
    public void rotate(int[][] matrix) {
        int l1 = matrix.length;
        for(int i = 0; i < l1 ; i++){
            for(int j = i+1; j < l1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int[] row : matrix){
            int left = 0;
            int right = l1-1;
            while(left < right){
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
}