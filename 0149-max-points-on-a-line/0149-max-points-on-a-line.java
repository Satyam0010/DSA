class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0;
        int n = points.length;
        if(n <= 2) return n;
        for(int i = 0; i < n;i++){
            int localMax = 0;
            HashMap<String,Integer> map = new HashMap<>();
            for(int j = 0; j < n;j++){
                if(i == j) continue;
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int g = gcd(Math.abs(dx),Math.abs(dy));
                dx /= g;
                dy /= g;
                if(dx < 0){
                    dx = -dx;
                    dy = -dy;
                }
                String slope = dx + "/" + dy;

                map.put(slope,map.getOrDefault(slope,0)+1);
                localMax = Math.max(localMax,map.get(slope));
            }
            ans = Math.max(ans,localMax+1);
        }
        return ans;
    }

    private int gcd(int x, int y){
        while(y > 0){
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }
}