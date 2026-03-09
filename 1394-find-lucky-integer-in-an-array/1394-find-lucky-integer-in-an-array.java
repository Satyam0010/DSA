class Solution {
    public int findLucky(int[] arr) {
        int[] fre = new int[501];

        for(int n : arr){
            fre[n]++;
        }

        int ans = -1;
        for(int i = 1 ; i < 501 ; i++){
            if(fre[i] == i){
                ans = i;    
            }
        }

        return ans;
    }
}