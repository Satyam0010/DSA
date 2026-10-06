class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String s : logs){
            String[] parts = s.split(":");
            int id = Integer.parseInt(parts[0]);
            int value = Integer.parseInt(parts[2]);
            if(parts[1].equals("start")){
               if(!st.isEmpty()){
                ans[st.peek()] += value - prev;
               }
               st.push(id);
               prev = value;
            }else{
                ans[st.pop()] += value - prev + 1;
                prev = value+1;
            }
        }
        return ans;
     }
}