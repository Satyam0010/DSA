class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                if(img1[i][j] == 1) l1.add(new int[]{i,j});
                if(img2[i][j] == 1) l2.add(new int[]{i,j});
            }
        }
        Map<String,Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] n1 : l1){
            for(int[] n2 : l2){
                int row = n2[0]-n1[0];
                int col = n2[1]-n1[1];
                String k = row+","+col;
                int count = map.getOrDefault(k,0)+1;
                map.put(k,count);
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}