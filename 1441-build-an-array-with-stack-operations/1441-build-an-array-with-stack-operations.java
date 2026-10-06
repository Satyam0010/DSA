class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int done = 0;
        for(int i = 1; i <= n; i++){
            if(done == target.length) break;
            ans.add("Push");
            if(i == target[done]) done++;
            else ans.add("Pop");

        }
        return ans;
    }
}