class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        Integer[][] memo = new Integer[size][size];
        int ans = check(0,0,size-1,triangle,memo);
        return ans;
    }
    private int check(int currRow,int currIndex,int totalRow,List<List<Integer>> triangle,Integer[][] memo){
        if(currRow == totalRow) return triangle.get(currRow).get(currIndex);
        if(memo[currRow][currIndex] != null) return memo[currRow][currIndex];
        int choice1 = triangle.get(currRow).get(currIndex) + check(currRow+1,currIndex,totalRow,triangle,memo);
        int choice2 = triangle.get(currRow).get(currIndex) + check(currRow+1,currIndex+1,totalRow,triangle,memo);
        return memo[currRow][currIndex] = Math.min(choice1,choice2);
    }
}