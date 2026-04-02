class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n[] = new int[friends.length];
        int c= 0;
        for(int i = 0; i < order.length;i++){
            for(int j = 0 ; j < friends.length;j++){
                if(order[i]==friends[j]){
                    n[c++] = order[i];
                }
            }
        }
        return n;
    }
}