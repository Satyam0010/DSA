class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < cols ;j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            ans = Math.max(ans,findLargest(heights));
        }
        return ans;
    }

    private int findLargest(int[] heights){
        int n = heights.length;
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                int element = st.pop();
                int current = heights[element]*(st.isEmpty() ? i : i - st.peek() -1);
                ans = Math.max(ans,current);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int element = st.pop();
            int current = heights[element]*(st.isEmpty() ? n : n - st.peek() -1);
            ans = Math.max(ans,current);
        }
        return ans;
    }
}