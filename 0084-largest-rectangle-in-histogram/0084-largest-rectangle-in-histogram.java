class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                int element = s.pop();
                int current = heights[element]*(s.isEmpty() ? i : (i - s.peek() -1));
                ans = Math.max(ans,current);
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int element = s.pop();
            int current = heights[element]*(s.isEmpty() ? n : (n-s.peek()-1));
            ans = Math.max(ans,current);
        }
        return ans;
    }
}