class Solution {
    public int trap(int[] height) {
        int lmax , rmax , total , l , r = height.length - 1;
        lmax = rmax = total = l = 0;
        while(l<r){
            if(height[l] <= height[r]){
                if(lmax > height[l]) total += lmax-height[l];
                else lmax = height[l];
                l += 1;
            } else {
                if(rmax > height[r]) total += rmax-height[r];
                else rmax = height[r];
                r -= 1;
            }
        }
        return total;
    }
}