class Solution {
    public boolean squareIsWhite(String coordinates) {
        char c1 = coordinates.charAt(0);
        int c2 = coordinates.charAt(1) - 0;
        if(c1 == 'a' ||c1 == 'c' ||c1 == 'e' ||c1 == 'g'){
            if(c2%2 == 0) return true;
            else return false;
        }
        if(c1 == 'b' ||c1 == 'd' ||c1 == 'f' ||c1 == 'h'){
            if(c2%2 != 0) return true;
            else return false;
        }
        return false;
    }
}