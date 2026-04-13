class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        back(1,k,n,new ArrayList<>(),ans);
        return ans;
    }

    private void back(int start,int k,int n,List<Integer> current,List<List<Integer>> ans){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if(k == 0|| n < 0) return;
        for(int i = start; i <= 9 ;i++){
            if(i > n ) break;

            current.add(i);
            back(i+1,k-1,n-i,current,ans);
            current.remove(current.size()-1);
        }
    }
}