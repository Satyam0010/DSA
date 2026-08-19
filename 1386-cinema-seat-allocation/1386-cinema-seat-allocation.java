class Solution {
    public int maxNumberOfFamilies(int n, int[][] reserved) {
        int left = 0b0000011110;
        int middle = 0b0001111000;
        int right = 0b0111100000;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] seat : reserved){
            int row = seat[0];
            int col = seat[1];
            map.put(row,map.getOrDefault(row,0)|(1<<col-1));
        }
        int ans = (n-map.size())*2;
        for(int value : map.values()){
            boolean isLeft = (left & value) == 0;
            boolean isMiddle = (middle & value) == 0;
            boolean isRight = (right & value) == 0;
            if(isLeft && isRight) ans += 2;
            else if(isLeft || isMiddle || isRight) ans += 1;
        }
        return ans;
    }
}