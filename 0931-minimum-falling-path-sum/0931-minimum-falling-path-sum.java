class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] memo = new Integer[n][n];
        int[] ans = new int[n];
        for(int i = 0; i < n;i++){
            ans[i] = check(0,i,n-1,n-1,matrix,memo);
        }
        int finalAns = Integer.MAX_VALUE;
        for(int num : ans){
            if(num < finalAns) finalAns = num;
        }
        return finalAns;
    }
    private int check(int currRow,int currCol,int totalRow,int totalCol,int[][] matrix,Integer[][] memo){
        if(currRow == totalRow) return matrix[currRow][currCol];
        if(memo[currRow][currCol] != null) return memo[currRow][currCol];
        int choice1 = Integer.MAX_VALUE;
        int choice2 = Integer.MAX_VALUE;
        int choice3 = Integer.MAX_VALUE;
        if(currRow+1 <= totalRow && currCol-1 >= 0) choice1 = matrix[currRow][currCol] + check(currRow+1,currCol-1,totalRow,totalCol,matrix,memo);
        if(currRow+1 <= totalRow) choice2 = matrix[currRow][currCol] + check(currRow+1,currCol,totalRow,totalCol,matrix,memo);
        if(currRow+1 <= totalRow && currCol+1 <= totalCol) choice3 = matrix[currRow][currCol] + check(currRow+1,currCol+1,totalRow,totalCol,matrix,memo);
        return memo[currRow][currCol] = Math.min(choice1,Math.min(choice2,choice3));
    }
}