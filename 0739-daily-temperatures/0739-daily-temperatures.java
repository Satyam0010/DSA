class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length;i++){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int in = stack.pop();
                ans[in] = i - in;
            }
            stack.push(i);
        }
        return ans;
    }
}