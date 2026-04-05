class Solution {
    public boolean judgeCircle(String moves) {
        int robot = 0;
        for(int i = 0; i < moves.length();i++){
            char c = moves.charAt(i);
            if(c == 'U'){
                robot += 10;
            }
            if(c == 'D'){
                robot -= 10;
            }
            if(c == 'R'){
                robot += 1;
            }
            if(c == 'L'){
                robot -= 1;
            }
        }
        if(robot == 0)
        return true;
        return false;
    }
}