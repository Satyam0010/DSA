class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        find(1,n,k,curr);
        return ans;
    }

    private void find(int start, int n, int k, List<Integer> curr){
        if(k == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(start > n) return;
        curr.add(start);
        find(start+1,n,k-1,curr);
        curr.remove(curr.size()-1);
        find(start+1,n,k,curr);
    }
}