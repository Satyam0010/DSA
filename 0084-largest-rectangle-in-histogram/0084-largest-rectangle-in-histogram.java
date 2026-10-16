class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
       int ans = 0;
       Stack<Integer> st = new Stack<>();
       for(int i = 0; i < n; i++){
        while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            int element = st.pop();
            int current = heights[element]*(st.isEmpty() ? i : i  - st.peek()-1);
            ans = Math.max(ans,current);
        }
        st.push(i);
       } 
       while(!st.isEmpty()){
        int element = st.pop();
        int current = heights[element]*(st.isEmpty() ? n : n - st.peek()-1);
        ans = Math.max(ans,current);
       }
       return ans;
    }
}