class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int max = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] == arr[i-1]){
                max++;
            }else {
                max = 1;
            }
            if(max > n/4) return arr[i];
        }
        return arr[0];
    }
}