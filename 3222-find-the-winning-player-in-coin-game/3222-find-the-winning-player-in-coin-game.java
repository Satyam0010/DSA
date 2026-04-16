class Solution {
    public String winningPlayer(int x, int y) {
        int count = 1;
        while(x > 0 && y > 3){
            x -= 1;
            y -= 4;
            count++;
        }
        if(count%2 == 0) return "Alice";

        return "Bob";
    }
}