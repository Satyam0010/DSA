class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int r = 0;
        int l = 0;
        int length = 0;
        String new1 = "";
        for(int i = 0 ; i< moves.length();i++){
            char c = moves.charAt(i);
            if(c == 'R')
            r++;
            if(c == 'L')
            l++;
        }
        if(r > l){
        new1 = moves.replace('_','R');
        }
        else if(r < l){
        new1 = moves.replace('_','L');
         } else {
         new1 = moves.replace('_','L');
         }

        for(int i = 0 ; i < new1.length();i++){
            char c = new1.charAt(i);
             if(c == 'R')
             length++;
            if(c == 'L')
            length--;
        }

        return Math.abs(length);
    }
}