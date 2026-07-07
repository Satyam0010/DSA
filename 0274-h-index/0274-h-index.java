class Solution {
    public int hIndex(int[] c) {
        int l = c.length;
        ArrayList<Integer>[] arr = new ArrayList[l+1];
        for(int i = 0; i <= l;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < l; i++){
            int a = Math.min(l,c[i]);
            while(a > -1){
                arr[a].add(c[i]);
                a--;
            }
        }
        for(int i = l; i > -1; i--){
            if(arr[i].size() >= i) return i;
        } 
        return 0;
    }
}