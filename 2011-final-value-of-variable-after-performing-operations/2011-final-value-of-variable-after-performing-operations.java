class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(int i = 0; i < operations.length ; i++){
            String op = operations[i];
            if(op.equals("++X")){
                ++x;
            }
            if(op.equals("X++")){
                x++;
            }
            if(op.equals("--X")){
                --x;
            }
            if(op.equals("X--")){
                x--;
            }
        }
        return x;
    }
}